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
        this.ventana1.btnSiguiente.setEnabled(false);
                 
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
