package moduloaeropuerto;

import interfaz.Ventana1;
import interfaz.Ventana2;

public class ModuloAeropuerto {

    public static void main(String[] args) {
        
        Vuelo vuelo = new Vuelo();
	Ventana1 interfaz1 = new Ventana1();
        Ventana2 interfaz2 = new Ventana2();
        Controlador controlador = new Controlador(vuelo, interfaz1, interfaz2);
        interfaz1.setVisible(true);
    }
}