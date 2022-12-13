package moduloaeropuerto;

import interfaz.Ventana1;

public class ModuloAeropuerto {

    public static void main(String[] args) {
        
        Vuelo vuelo = new Vuelo();
	Ventana1 interfaz = new Ventana1();
        Controlador controlador = new Controlador(vuelo, interfaz);
        interfaz.setVisible(true);
    }
}