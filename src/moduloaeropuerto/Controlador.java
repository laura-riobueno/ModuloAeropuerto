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
                 
        for(int i=0; i < vuelodao.listaPaises().size(); i++){
            this.ventana1.cbPais.addItem(vuelodao.listaPaises().get(i));
        }
        
        for(int i=0; i < vuelodao.listaAeropuertos().size(); i++){
            this.ventana1.cbOrigen.addItem(vuelodao.listaAeropuertos().get(i));
        }
        
        for(int i=0; i < vuelodao.listaAeropuertos().size(); i++){
            this.ventana1.cbDestino.addItem(vuelodao.listaAeropuertos().get(i));
        }
        
        for(int i=0; i < vuelodao.listaAerolineas().size(); i++){
            this.ventana1.cbAerolinea.addItem(vuelodao.listaAerolineas().get(i));
        }
        
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
            vuelo = new Vuelo();
            vuelo.setPais((String) this.ventana1.cbPais.getSelectedItem());
            vuelo.setOrigen((String) this.ventana1.cbOrigen.getSelectedItem());
            vuelo.setDestino((String) this.ventana1.cbDestino.getSelectedItem());
            vuelo.setAerolinea((String) this.ventana1.cbDestino.getSelectedItem());
            vuelo.setHora((String) this.ventana1.cbHora.getSelectedItem() + ":" + (String) this.ventana1.cbMinuto.getSelectedItem());
            Date date = new Date();
            date = this.ventana1.dtFecha.getDate();
            DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
            vuelo.setFecha(df.format(date));
            
            /*Date date = new Date();
            date = this.ventana1.dtFecha.getDate();
            DateFormat df = new SimpleDateFormat("EEEE MMMM dd yyyy", Locale.ENGLISH);
            String fecha = df.format(date);
            String[] dia = fecha.split(" ");
            fecha = dia[0];
            switch(fecha){
                case "Monday":
                    fecha = "1";
                    break;
                case "Tuesday":
                    fecha = "2";
                    break;
                case "Wednesday":
                    fecha = "3";
                    break;
                case "Thursday":
                    fecha = "4";
                    break;
                case "Friday":
                    fecha = "5";
                    break;
                case "Saturday":
                    fecha = "6";
                    break;
                case "Sunday":
                    fecha = "7";
                    break;    
            }*/
        }
        if(e.getSource() == this.ventana2.cbAerolinea){
            aerolinea = (String) this.ventana2.cbAerolinea.getSelectedItem();
        }
        
        if(e.getSource()== this.ventana1.btnSiguiente){
            /*vuelo = new Vuelo();
            vuelo.setPais((String) this.ventana1.cbPais.getSelectedItem());
            vuelo.setOrigen((String) this.ventana1.cbOrigen.getSelectedItem());
            vuelo.setDestino((String) this.ventana1.cbDestino.getSelectedItem());
            vuelo.setAerolinea((String) this.ventana1.cbDestino.getSelectedItem());
            vuelo.setHora((String) this.ventana1.cbHora.getSelectedItem() + ":" + (String) this.ventana1.cbMinuto.getSelectedItem());
            Date date = new Date();
            date = this.ventana1.dtFecha.getDate();
            DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
            vuelo.setFecha(df.format(date));*/
            
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
    
*/
