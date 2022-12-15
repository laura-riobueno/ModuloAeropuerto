package moduloaeropuerto;

public class Vuelo {
    
    private String numeroV;
    private String pais;
    private String origen;
    private String destino;
    private String aerolinea;
    private String dia;
    private String fecha;
    private String hora;
    private String avion;
    private String fechaCreacion;
    
    public Vuelo(){
         
    }
    
    
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    // getter y setters
    
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {    
        this.aerolinea = aerolinea;
    }

    public String getNumeroV() {
        return numeroV;
    }

    public void setNumeroV(String numeroV) {
        this.numeroV = numeroV;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }
 
    
}
