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
import java.util.Locale;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Controlador implements ActionListener{

    private Vuelo vuelo;
    private VueloDAO vueloDAO = new VueloDAO();
    private Ventana1 ventana1;
    private Ventana2 ventana2;
    private String aerolinea;
    private ArrayList<Vuelo> vuelos = new ArrayList();
    private ArrayList<String> listaTemporal = new ArrayList();
    private ArrayList<Vuelo> listaTemporal2 = new ArrayList();
    
    public Controlador(ArrayList<Vuelo> vuelos, Ventana1 vnt1, Ventana2 vnt2){
        
        
        
        
        this.ventana1 = vnt1;
        this.ventana1.btnAgregar.addActionListener(this);
        this.ventana1.btnSiguiente.addActionListener(this);
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
        this.ventana1.cbMinuto.addItem("00");
        this.ventana1.cbMinuto.addItem("15");
        this.ventana1.cbMinuto.addItem("30");
        this.ventana1.cbMinuto.addItem("45");
        
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
        this.ventana2.btnReporte.addActionListener(this);
        
        
        this.ventana2.cbAerolinea.addItem(null);
        for(int i=0; i < listaTemporal.size(); i++){
            this.ventana2.cbAerolinea.addItem(listaTemporal.get(i));
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.ventana1.btnAgregar){
            
            // tener una date de la fecha actual
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
                DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
                vuelo.setFecha(df1.format(date));

                DateFormat df2 = new SimpleDateFormat("EEEE MMMM dd yyyy", Locale.ENGLISH);
                String dia = df2.format(date);
                String[] fecha = dia.split(" ");
                dia = fecha[0];
                switch(dia){
                    case "Monday":
                        dia = "1";
                        break;
                    case "Tuesday":
                        dia = "2";
                        break;
                    case "Wednesday":
                        dia = "3";
                        break;
                    case "Thursday":
                        dia = "4";
                        break;
                    case "Friday":
                        dia = "5";
                        break;
                    case "Saturday":
                        dia = "6";
                        break;
                    case "Sunday":
                        dia = "7";
                        break;    
                }

                vuelo.setDia(dia);
                DateFormat df3 = new SimpleDateFormat("dd/MM/yyyy");
                String fc = df3.format(out);
                vuelo.setFechaCreacion(fc);
                
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
                    String dia = vuelos.get(i).getDia();
                    switch(dia){
                    case "1":
                        dia = "Lunes";
                        break;
                    case "2":
                        dia = "Martes";
                        break;
                    case "3":
                        dia = "Miércoles";
                        break;
                    case "4":
                        dia = "Jueves";
                        break;
                    case "5":
                        dia = "Viernes";
                        break;
                    case "6":
                        dia = "Sábado";
                        break;
                    case "7":
                        dia = "Domingo";
                        break;
                    }
                    model.addRow(new Object[]{vuelos.get(i).getPais(), vuelos.get(i).getOrigen(),vuelos.get(i).getDestino(),
                        dia, vuelos.get(i).getHora()});
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
                    vueloDAO.ingresarVuelo(vuelo);
                    System.out.println(this.ventana2.tbVuelos.getValueAt(i, 5));
                    System.out.println(i);
                } 
            }
        }
        if(e.getSource()== this.ventana2.btnReporte){
            Document documento = new Document();
            try{
                String ruta = System.getProperty("user/lain-");
                PdfWriter.getInstance(documento, new FileOutputStream("Reporte_Vuelos.pdf"));
                documento.open();
                listaTemporal2 = vueloDAO.listaVuelos();
                for(int i=0;i < listaTemporal2.size();i++){
                    String codLinea = listaTemporal2.get(i).getAerolinea();
                    switch(codLinea){
                        case "101":
                            codLinea = "Avianca";
                            break;
                        case "102":
                            codLinea = "Latam";
                            break;
                        case "103":
                            codLinea = "Viva Air Colombia";
                            break;
                        case "104":
                            codLinea = "Wingo";
                            break;
                    }
                    int rnd = (int) (Math.random()*4)+1;
                    String horallegada;
                    if(listaTemporal2.get(i).getHora().length() == 4){
                        int aux = Integer.parseInt(listaTemporal2.get(i).getHora().substring(0, 1))+rnd;
                        horallegada = aux + ":" + listaTemporal2.get(i).getHora().substring(2, 4);
                    }else{
                        int aux = Integer.parseInt(listaTemporal2.get(i).getHora().substring(0, 2))+rnd;
                        horallegada = aux + ":" + listaTemporal2.get(i).getHora().substring(3, 5);    
                    }
                    Paragraph parrafo = new Paragraph("El programa de Vuelo "+ listaTemporal2.get(i).getNumeroV() +" de "+ codLinea +" "
                                                    + "con vuelo en la fecha "+ listaTemporal2.get(i).getFecha()+" despega del Aeropuerto "+ listaTemporal2.get(i).getOrigen()
                                                    + " a las "+ listaTemporal2.get(i).getHora() +" y aterriza en el aeropuerto "+ listaTemporal2.get(i).getDestino()
                                                    + " a las "+ horallegada +".\n\n");
                    Paragraph parrafoP = new Paragraph("Hola");
                    documento.add(parrafo);
                }
                documento.close();
                JOptionPane.showMessageDialog(null, "Reporte creado");
            }catch (Exception ex){
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "No se pudo crear el reporte");
            }
        }
        
        if(e.getSource()== this.ventana2.btnSalir){
            this.ventana2.setVisible(false);
            this.ventana2.dispose();
            System.exit(0);
        }
        
        
    }
}