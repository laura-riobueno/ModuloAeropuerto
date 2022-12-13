package moduloaeropuerto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interfaz.Ventana1;
import interfaz.Ventana2;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
public class Controlador implements ActionListener{

    private Vuelo vuelo;
    private VueloDAO vueloDAO;
    private Ventana1 ventana1;
    private Ventana2 ventana2;
    private String aerolinea;
    
    public Controlador(Vuelo vuelo, Ventana1 vnt1, Ventana2 vnt2){
        
        VueloDAO vuelodao = new VueloDAO();
        
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
        
        /*this.ventana1.cbPais.addItem(null);
        for(int i=0; i < vuelodao.listaPaises().size(); i++){
            this.ventana1.cbPais.addItem(vuelodao.listaPaises().get(i));
        }
        
        this.ventana1.cbOrigen.addItem(null);
        for(int i=0; i < vuelodao.listaAeropuertos().size(); i++){
            this.ventana1.cbOrigen.addItem(vuelodao.listaAeropuertos().get(i));
        }
        
        this.ventana1.cbDestino.addItem(null);
        for(int i=0; i < vuelodao.listaAeropuertos().size(); i++){
            this.ventana1.cbDestino.addItem(vuelodao.listaAeropuertos().get(i));
        }
        
        this.ventana1.cbAerolinea.addItem(null);
        for(int i=0; i < vuelodao.listaAerolineas().size(); i++){
            this.ventana1.cbAerolinea.addItem(vuelodao.listaAerolineas().get(i));
        }*/
        
        /////////////////////// PRUEBAS ////////////////////
        ArrayList<String> prueba = new ArrayList();
        prueba.add("a");
        prueba.add("b");
        prueba.add("c");
        
        this.ventana1.cbPais.addItem(null);
        for(int i=0; i < prueba.size(); i++){
            this.ventana1.cbPais.addItem(prueba.get(i));
        }
        
        this.ventana1.cbOrigen.addItem(null);
        for(int i=0; i < prueba.size(); i++){
            this.ventana1.cbOrigen.addItem(prueba.get(i));
        }
        
        this.ventana1.cbDestino.addItem(null);
        for(int i=0; i < prueba.size(); i++){
            this.ventana1.cbDestino.addItem(prueba.get(i));
        }
        
        this.ventana1.cbAerolinea.addItem(null);
        for(int i=0; i < prueba.size(); i++){
            this.ventana1.cbAerolinea.addItem(prueba.get(i));
        }
        /////////////////////////////////////////////////////
        
        this.ventana2 = vnt2;
        this.ventana2.cbAerolinea.addActionListener(this);
        this.ventana2.cbAviones.addActionListener(this);
        this.ventana2.btnGuardar.addActionListener(this);
        this.ventana2.btnSalir.addActionListener(this);
        
        for(int i=0; i < vuelodao.listaAerolineasCondicional().size(); i++){
            this.ventana2.cbAerolinea.addItem(vuelodao.listaAerolineasCondicional().get(i));
        }
        
        for(int i=0; i < vuelodao.listaAviones(aerolinea).size(); i++){
            this.ventana2.cbAviones.addItem(vuelodao.listaAviones(aerolinea).get(i));
        }
    }
    
    public void listarAviones(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.ventana1.btnAgregar){
            if(this.ventana1.cbPais.getSelectedItem() != null && this.ventana1.cbOrigen.getSelectedItem() != null
                    && this.ventana1.cbDestino.getSelectedItem() != null && this.ventana1.cbAerolinea.getSelectedItem() != null
                    && this.ventana1.dtFecha.getDate() != null && this.ventana1.cbMinuto.getSelectedItem() != null 
                    && this.ventana1.cbHora.getSelectedItem() != null){
                vuelo = new Vuelo();
                vuelo.setPais((String) this.ventana1.cbPais.getSelectedItem());
                vuelo.setOrigen((String) this.ventana1.cbOrigen.getSelectedItem());
                vuelo.setDestino((String) this.ventana1.cbDestino.getSelectedItem());
                vuelo.setAerolinea((String) this.ventana1.cbAerolinea.getSelectedItem());
                vuelo.setHora((String) this.ventana1.cbMinuto.getSelectedItem() + ":" + (String) this.ventana1.cbHora.getSelectedItem());
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
                this.ventana1.btnSiguiente.setEnabled(true);

                this.ventana1.cbPais.setSelectedIndex(0);
                this.ventana1.cbOrigen.setSelectedIndex(0);
                this.ventana1.cbDestino.setSelectedIndex(0);
                this.ventana1.cbAerolinea.setSelectedIndex(0);
                this.ventana1.dtFecha.setCalendar(null);
                this.ventana1.cbMinuto.setSelectedIndex(0);
                this.ventana1.cbHora.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Los datos no están completos");
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
        }
        
        if(e.getSource()== this.ventana1.btnSiguiente){            
            this.ventana2.setVisible(true);
            this.ventana1.setVisible(false);
        }
        if(e.getSource()== this.ventana2.btnGuardar){
            
        }
        if(e.getSource()== this.ventana2.btnSalir){
            this.ventana2.setVisible(false);
            this.ventana2.dispose();
            System.exit(0);
        }
    }
}
/*
    ArrayList<String> prueba = new ArrayList();
    prueba.add("a");
    prueba.add("b");
    prueba.add("c");
        
    for(int i=0; i < prueba.size(); i++){
        this.ventana2.cbAviones.addItem(prueba.get(i));
    }
    
*/
