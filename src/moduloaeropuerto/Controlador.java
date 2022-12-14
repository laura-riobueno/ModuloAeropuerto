package moduloaeropuerto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interfaz.Ventana1;
import interfaz.Ventana2;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

public class Controlador implements ActionListener{

    private Vuelo vuelo;
    private VueloDAO vueloDAO = new VueloDAO();
    private Ventana1 ventana1;
    private Ventana2 ventana2;
    private String aerolinea;
    private ArrayList<Vuelo> vuelos = new ArrayList();
    private ArrayList<String> listaTemporal = new ArrayList();
    
    public Controlador(ArrayList<Vuelo> vuelos, Ventana1 vnt1, Ventana2 vnt2){
        
        
        
        
        this.ventana1 = vnt1;
        this.ventana1.btnAgregar.addActionListener(this);
        this.ventana1.btnSiguiente.addActionListener(this);
        this.ventana1.btnSiguiente.setEnabled(false);
        this.ventana1.cbPais.addActionListener(this);
        this.ventana1.cbOrigen.addActionListener(this);
        this.ventana1.cbDestino.addActionListener(this);
        this.ventana1.cbAerolinea.addActionListener(this);
        this.ventana1.cbHora.addActionListener(this);
        this.ventana1.cbMinuto.addActionListener(this);
        
        
        this.ventana1.cbHora.addItem(null);
        for(int i=0; i<24; i++){
            this.ventana1.cbHora.addItem("" + i + "");
        }
        
        this.ventana1.cbMinuto.addItem(null);
        for(int i=0; i<4; i++){
            this.ventana1.cbMinuto.addItem("" + i*15 + "");
        }
        
        listaTemporal = vueloDAO.listaPaises();
        this.ventana1.cbPais.addItem(null);
        for(int i=0; i < listaTemporal.size(); i++){
            this.ventana1.cbPais.addItem(listaTemporal.get(i));
        }
        
        listaTemporal = vueloDAO.listaAeropuertos();
        this.ventana1.cbOrigen.addItem(null);
        for(int i=0; i < listaTemporal.size(); i++){
            this.ventana1.cbOrigen.addItem(listaTemporal.get(i));
        }
        
        this.ventana1.cbDestino.addItem(null);
        for(int i=0; i < listaTemporal.size(); i++){
            this.ventana1.cbDestino.addItem(listaTemporal.get(i));
        }
        listaTemporal = vueloDAO.listaAerolineas();
        this.ventana1.cbAerolinea.addItem(null);
        for(int i=0; i < listaTemporal.size(); i++){
            this.ventana1.cbAerolinea.addItem(listaTemporal.get(i));
        }
       
        
        this.ventana2 = vnt2;
        this.ventana2.cbAerolinea.addActionListener(this);
        this.ventana2.cbAviones.addActionListener(this);
        this.ventana2.btnTerminar.addActionListener(this);
        this.ventana2.btnSalir.addActionListener(this);
        
        
        this.ventana2.cbAerolinea.addItem(null);
        for(int i=0; i < listaTemporal.size(); i++){
            this.ventana2.cbAerolinea.addItem(listaTemporal.get(i));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.ventana1.btnAgregar){
            
            Date in = new Date();
            LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
            Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
            
            if(this.ventana1.cbPais.getSelectedItem() != null && this.ventana1.cbOrigen.getSelectedItem() != null
                    && this.ventana1.cbDestino.getSelectedItem() != null && this.ventana1.cbAerolinea.getSelectedItem() != null
                    && this.ventana1.dtFecha.getDate() != null && this.ventana1.cbMinuto.getSelectedItem() != null 
                    && this.ventana1.cbHora.getSelectedItem() != null && this.ventana1.dtFecha.getDate().compareTo(out)>0
                    && this.ventana1.cbOrigen.getSelectedItem().equals(this.ventana1.cbDestino.getSelectedItem()) == false){
                vuelo = new Vuelo();
                vuelo.setPais((String) this.ventana1.cbPais.getSelectedItem());
                vuelo.setOrigen((String) this.ventana1.cbOrigen.getSelectedItem());
                vuelo.setDestino((String) this.ventana1.cbDestino.getSelectedItem());
                vuelo.setAerolinea((String) this.ventana1.cbAerolinea.getSelectedItem());
                vuelo.setHora((String) this.ventana1.cbHora.getSelectedItem() + ":" + (String) this.ventana1.cbMinuto.getSelectedItem());
                Date date = new Date();
                date = this.ventana1.dtFecha.getDate();
                DateFormat df1 = new SimpleDateFormat("dd/mm/yyyy");
                vuelo.setFecha(df1.format(date));

                DateFormat df2 = new SimpleDateFormat("EEEE MMMM dd yyyy", Locale.ENGLISH);
                String dia = df2.format(date);
                String[] fecha = dia.split(" ");
                dia = fecha[0];
                switch(dia){
                    case "Monday":
                        dia = "Luens";
                        break;
                    case "Tuesday":
                        dia = "Martes";
                        break;
                    case "Wednesday":
                        dia = "Miércoles";
                        break;
                    case "Thursday":
                        dia = "Jueves";
                        break;
                    case "Friday":
                        dia = "Viernes";
                        break;
                    case "Saturday":
                        dia = "Sábado";
                        break;
                    case "Sunday":
                        dia = "Domingo";
                        break;    
                }

                vuelo.setDia(dia);
                
                vuelos.add(vuelo);
                
                this.ventana1.btnSiguiente.setEnabled(true);

                this.ventana1.cbPais.setSelectedIndex(0);
                this.ventana1.cbOrigen.setSelectedIndex(0);
                this.ventana1.cbDestino.setSelectedIndex(0);
                this.ventana1.cbAerolinea.setSelectedIndex(0);
                this.ventana1.dtFecha.setCalendar(null);
                this.ventana1.cbMinuto.setSelectedIndex(0);
                this.ventana1.cbHora.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Datos incompletos o información inválida");
            }
            
        }
        if(e.getSource() == this.ventana1.cbPais){
            if(this.ventana1.cbPais.getSelectedItem() != null){
                this.ventana1.btnSiguiente.setEnabled(false);
            }
        }
        
        if(e.getSource() == this.ventana1.cbOrigen){
            if(this.ventana1.cbOrigen.getSelectedItem() != null){
                this.ventana1.btnSiguiente.setEnabled(false);
            }
        }
        
        if(e.getSource() == this.ventana1.cbDestino){
            if(this.ventana1.cbDestino.getSelectedItem() != null){
                this.ventana1.btnSiguiente.setEnabled(false);
            }
        }
        
        if(e.getSource() == this.ventana1.cbAerolinea){
            if(this.ventana1.cbAerolinea.getSelectedItem() != null){
                this.ventana1.btnSiguiente.setEnabled(false);
            }
        }
        
        if(e.getSource() == this.ventana1.cbHora){
            if(this.ventana1.cbHora.getSelectedItem() != null){
                this.ventana1.btnSiguiente.setEnabled(false);
            }
        }
        
        if(e.getSource() == this.ventana1.cbMinuto){
            if(this.ventana1.cbMinuto.getSelectedItem() != null){
                this.ventana1.btnSiguiente.setEnabled(false);
            }
        }
        
        if(e.getSource() == this.ventana2.cbAerolinea){
            aerolinea = (String) this.ventana2.cbAerolinea.getSelectedItem();
            
            listaTemporal = vueloDAO.listaAviones(aerolinea);
            this.ventana2.cbAviones.addItem(null);
            for(int i=0; i < listaTemporal.size(); i++){
                this.ventana2.cbAviones.addItem(listaTemporal.get(i));
            }
    
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"Pais", "Aeropuerto de Origen", "Aeropuerto de Destino","Dia","Hora","No.Vuelo","Avion"});
            
            for(int i=0; i < vuelos.size(); i++){
                if(vuelos.get(i).getAerolinea() == aerolinea){
                    model.addRow(new Object[]{vuelos.get(i).getPais(), vuelos.get(i).getOrigen(),vuelos.get(i).getDestino(),
                        vuelos.get(i).getDia(), vuelos.get(i).getHora()});
                }
            }
            this.ventana2.tbVuelos.setModel(model);
            TableColumn tc = this.ventana2.tbVuelos.getColumnModel().getColumn(6);
            TableCellEditor tce = new DefaultCellEditor(this.ventana2.cbAviones);
            tc.setCellEditor(tce);
        }
        
        if(e.getSource()== this.ventana1.btnSiguiente){            
            this.ventana2.setVisible(true);
            this.ventana1.setVisible(false);
        }
        if(e.getSource()== this.ventana2.btnTerminar){
            for (int i = 0; i < this.ventana2.tbVuelos.getRowCount(); i++){
                if(vuelos.get(i).getAerolinea() == aerolinea){
                    vuelos.get(i).setNumeroV((String) this.ventana2.tbVuelos.getValueAt(i, 5));
                    vuelos.get(i).setAvion((String) this.ventana2.tbVuelos.getValueAt(i, 6));
                    System.out.println(vuelos.get(i).getNumeroV()+ " " + vuelos.get(i).getOrigen());
                } 
            }

        }
        if(e.getSource()== this.ventana2.btnSalir){
            this.ventana2.setVisible(false);
            this.ventana2.dispose();
            System.exit(0);
        }
    }
}