package moduloaeropuerto;

import interfaz.Ventana1;
import interfaz.Ventana2;
import java.util.ArrayList;

public class ModuloAeropuerto {

    public static void main(String[] args) {
        
        ArrayList<Vuelo> vuelos = new ArrayList();
	Ventana1 interfaz1 = new Ventana1();
        Ventana2 interfaz2 = new Ventana2();
        Controlador controlador = new Controlador(vuelos, interfaz1, interfaz2);
        interfaz1.setVisible(true);
    }
}