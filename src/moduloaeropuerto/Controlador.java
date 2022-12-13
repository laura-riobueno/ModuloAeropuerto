package moduloaeropuerto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interfaz.Ventana1;
import interfaz.Ventana2;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import java.util.Date;
import java.util.Locale;
public class Controlador implements ActionListener{

    private Vuelo vuelo;
    private VueloDAO vueloDAO;
    private Ventana1 ventana1;
    private Ventana2 ventana2;
    
    public Controlador(Vuelo vuelo, Ventana1 vnt1){
        
        this.ventana1 = vnt1;
        this.ventana1.btnAgregar.addActionListener(this);
        this.ventana1.btnSiguiente.addActionListener(this);
        
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
    }
}
/*
    
*/
