package moduloaeropuerto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VueloDAO {
    
    private Connection con;//Crea objeto de tipo conexion
    private Statement st;//Crea objeto de tipo Statement
    private ResultSet rs;//Crea objeto de tipo ResulSet

    public VueloDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /*public void ingresarVuelo(Vuelo objVuelo){ //Método que inserta en BD las personas que se le envíen en forma de objeto
        //AQUI ASIGNA A UN STRING EL QUERY DE INSERCIÓN CON LOS DATOS EXTRAIDOS DEL OBJETO RECIBIDO DE CONTROL
        String consulta = "insert into PERSONA(CEDULA,NOMBRE,APELLIDO,CORREO,TELEFONO) values ('"+ objVuelo.getCedula() + "','" + 
                objPersona.getNombre() + "','" + objPersona.getApellido() + "','" + objVuelo.getCorreo() + "','" + objPersona.getTelefono() + "')";
        try{
            con = (Connection) ConexionBD.getConnection();//SE LLAMA A LA CONEXIÓN
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            st.executeUpdate(consulta);// SE EJECUTA LA INSECIÓN
            st.close();//SE CIERRA EL OBJETO STATEMENT
            ConexionBD.dissconect();// SE CIERRA LA CONEXION

        }catch(SQLException e){
            System.out.println("Consulta imposible");
            System.out.println(e);
        }
        
    }*/
    
    //Consultas de selección
    
    //Consultar paises
    
    public ArrayList<String> listaPaises(){ //Método que obtiene, guarda y devuelve un arraylist
        ArrayList<String> aPaisesTemp = new ArrayList<>();//Creo ArrayList temporal
        String consulta = "select * from Lugar where idLugar = '1'";//Establezco consulta BD
        try {
            con = ConexionBD.getConnection();//Obtengo la conexión
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            rs = st.executeQuery(consulta);//Ejecuto la consulta y la guardo en el objeto rs
            while (rs.next()) {
                String pais = new String(); //Creo un nuevo string pais
                pais = rs.getString("nomLugar"); //Seteo los datos de la iteración
                aPaisesTemp.add(pais);//Añado a arraylist el objeto
            }
            st.close();// cierro la conexión
            ConexionBD.dissconect(); //me desconecto de la base de datos
        } catch (SQLException e) {//Si captura algún error lo muestra
            System.out.println("Consulta imposible");
            System.out.println(e);
        }
        return aPaisesTemp;//Retorno arraylist
    }
    
    //Consultar Aeropuertos
    
    public ArrayList<String> listaAeropuertos(){ //Método que obtiene, guarda y devuelve un arraylist
        ArrayList<String> aAeropuertosTemp = new ArrayList<>();//Creo ArrayList temporal
        String consulta = "select * from lugar where idtipolu = '5' or idLugar = '6';";//Establezco consulta BD
        try {
            con = ConexionBD.getConnection();//Obtengo la conexión
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            rs = st.executeQuery(consulta);//Ejecuto la consulta y la guardo en el objeto rs
            while (rs.next()) {
                String aeropuerto = new String(); //Creo un nuevo string pais
                aeropuerto = rs.getString("nomLugar"); //Seteo los datos de la iteración
                aAeropuertosTemp.add(aeropuerto);//Añado a arraylist el objeto
            }
            st.close();// cierro la conexión
            ConexionBD.dissconect(); //me desconecto de la base de datos
        } catch (SQLException e) {//Si captura algún error lo muestra
            System.out.println("Consulta imposible");
            System.out.println(e);
        }
        return aAeropuertosTemp;//Retorno arraylist
    }
    
    //Consultar Aerolineas
    
    public ArrayList<String> listaAerolineas(){ //Método que obtiene, guarda y devuelve un arraylist
        ArrayList<String> aAerolineasTemp = new ArrayList<>();//Creo ArrayList temporal
        String consulta = "select * from LineaAerea";//Establezco consulta BD
        try {
            con = ConexionBD.getConnection();//Obtengo la conexión
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            rs = st.executeQuery(consulta);//Ejecuto la consulta y la guardo en el objeto rs
            while (rs.next()) {
                String aerolinea = new String(); //Creo un nuevo string pais
                aerolinea = rs.getString("nombreLinea"); //Seteo los datos de la iteración
                aAerolineasTemp.add(aerolinea);//Añado a arraylist el objeto
            }
            st.close();// cierro la conexión
            ConexionBD.dissconect(); //me desconecto de la base de datos
        } catch (SQLException e) {//Si captura algún error lo muestra
            System.out.println("Consulta imposible");
            System.out.println(e);
        }
        return aAerolineasTemp;//Retorno arraylist
    }

    /*/Consultar Aerolineas según si tienen vuelo al día siguiente
    
    public ArrayList<String> listaAerolineasCondicional(){ //Método que obtiene, guarda y devuelve un arraylist
        ArrayList<String> aAerolineasTemp = new ArrayList<>();//Creo ArrayList temporal
        String consulta = "select codLinea"
                        + "from LineaAerea LA, ProgramaVuelo PV, Vuelo V"
                        + "where LA.codLinea = PV.codLinea,"
                        + "and PV.codLinea = V.codLinea,"
                        + "and V.fecha = ((current_date::date)+'1day'::interval)::date;";//Establezco consulta BD
       
        try {
            con = ConexionBD.getConnection();//Obtengo la conexión
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            rs = st.executeQuery(consulta);//Ejecuto la consulta y la guardo en el objeto rs
            while (rs.next()) {
                String aerolinea = new String(); //Creo un nuevo string pais
                aerolinea = rs.getString("nombreLinea"); //Seteo los datos de la iteración
                aAerolineasTemp.add(aerolinea);//Añado a arraylist el objeto
            }
            st.close();// cierro la conexión
            ConexionBD.dissconect(); //me desconecto de la base de datos
        } catch (SQLException e) {//Si captura algún error lo muestra
            System.out.println("Consulta imposible");
            System.out.println(e);
        }
        return aAerolineasTemp;//Retorno arraylist
    }*/
    
    // Consultar Aviones por aerolinea
    
    public ArrayList<String> listaAviones(String codLinea){ //Método que obtiene, guarda y devuelve un arraylist
        ArrayList<String> aAvionesTemp = new ArrayList<>();//Creo ArrayList temporal
        switch(codLinea){
            case "Avianca":
                codLinea = "101";
                break;
            case "Latam":
                codLinea = "102";
                break;
            case "Viva Air Colombia":
                codLinea = "103";
                break;
            case "Wingo":
                codLinea = "104";
                break;
        
        }
        String consulta = "select idmodelo from avion where codlinea = '" + codLinea + "'";//Establezco consulta BD
        try {
            con = ConexionBD.getConnection();//Obtengo la conexión
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            rs = st.executeQuery(consulta);//Ejecuto la consulta y la guardo en el objeto rs
            while (rs.next()) {
                String avion = new String(); //Creo un nuevo string pais
                avion = rs.getString("idModelo"); //Seteo los datos de la iteración
                aAvionesTemp.add(avion);//Añado a arraylist el objeto
            }
            st.close();// cierro la conexión
            ConexionBD.dissconect(); //me desconecto de la base de datos
        } catch (SQLException e) {//Si captura algún error lo muestra
            System.out.println("Consulta imposible");
            System.out.println(e);
        }
        return aAvionesTemp;//Retorno arraylist
    }
}
