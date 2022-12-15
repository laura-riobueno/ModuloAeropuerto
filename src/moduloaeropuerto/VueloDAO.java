package moduloaeropuerto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VueloDAO {
    
    private Connection con;//Crea objeto de tipo conexion
    private Statement st;//Crea objeto de tipo Statement
    private ResultSet rs;//Crea objeto de tipo ResulSet

    public VueloDAO() {
        con = null;
        st = null;
        rs = null;
    }

    public void ingresarVuelo(Vuelo vuelo){ //Método que inserta en BD las personas que se le envíen en forma de objeto
        //AQUI ASIGNA A UN STRING EL QUERY DE INSERCIÓN CON LOS DATOS EXTRAIDOS DEL OBJETO RECIBIDO DE CONTROL
        String codLinea = vuelo.getAerolinea();
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
        String aux;
        if(vuelo.getHora().length()==4){
            aux = vuelo.getHora().substring(0,1) + "" + vuelo.getHora().substring(2,4);
        }else{
            aux = vuelo.getHora().substring(0,2) + "" + vuelo.getHora().substring(3,5);
        }
        int hora = Integer.parseInt(aux);
        
        String consulta = "insert into hora (idhora) values ('"+ hora +"');"
                        + "insert into programavuelo (codlinea,idprograma,idlugar,lug_idlugar,lug_idlugar2,fechacrea) "
                            + "values ('"+ codLinea +"','"+ vuelo.getNumeroV() +"','"+ vuelo.getPais().substring(0,1) +"','"+ vuelo.getOrigen().substring(0,2) +"','"+ vuelo.getDestino().substring(0,2) +"','"+ vuelo.getFechaCreacion()+"');"
                        + "insert into dia (iddia,codlinea,idprograma) values ('"+ vuelo.getDia() +"','"+ codLinea +"','"+ vuelo.getNumeroV() +"');"
                        + "insert into destino (idhora, codlinea, idprograma) values ('"+ hora +"','"+ codLinea +"','"+ vuelo.getNumeroV()+"');"
                        + "insert into vuelo (idvuelo, codlinea,idprograma,placaavion,fecha,plazasvacia) "
                            + "values ('"+ vuelo.getNumeroV() +"','"+ codLinea +"','"+ vuelo.getNumeroV() +"','"+ vuelo.getAvion() +"','"+ vuelo.getFecha() +"',"
                            + "(select capacidad from modeloavion MA, avion AV where MA.idmodelo = AV.idmodelo and AV.placaavion = '"+ vuelo.getAvion() +"'));";
        try{
            con = (Connection) ConexionBD.getConnection();//SE LLAMA A LA CONEXIÓN
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            st.executeUpdate(consulta);// SE EJECUTA LA INSECIÓN
            st.close();//SE CIERRA EL OBJETO STATEMENT
            ConexionBD.dissconect();// SE CIERRA LA CONEXION

        }catch(SQLException e){
            System.out.println("Consulta imposible");
            JOptionPane.showMessageDialog(null, "Faltan datos");
            System.out.println(e);
        }
        
    }
    
    //Consultas de selección
    
    //Consultar paises
    
    public ArrayList<String> listaPaises(){ //Método que obtiene, guarda y devuelve un arraylist
        ArrayList<String> aPaisesTemp = new ArrayList<>();//Creo ArrayList temporal
        String consulta = "select idlugar ||' '|| nomlugar as \"paises\""
                        + "from lugar "
                        + "where idtipolu = '1';";//Establezco consulta BD
        try {
            con = ConexionBD.getConnection();//Obtengo la conexión
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            rs = st.executeQuery(consulta);//Ejecuto la consulta y la guardo en el objeto rs
            while (rs.next()) {
                String pais = new String(); //Creo un nuevo string pais
                pais = rs.getString("paises"); //Seteo los datos de la iteración
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
        String consulta = "select idlugar ||' '|| nomlugar as \"aeropuertos\""
                        + "from lugar "
                        + "where idtipolu = '5' or idtipolu = '6';";//Establezco consulta BD
        try {
            con = ConexionBD.getConnection();//Obtengo la conexión
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            rs = st.executeQuery(consulta);//Ejecuto la consulta y la guardo en el objeto rs
            while (rs.next()) {
                String aeropuerto = new String(); //Creo un nuevo string pais
                aeropuerto = rs.getString("aeropuertos"); //Seteo los datos de la iteración
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
        String consulta = "select * from avion where codlinea = '" + codLinea + "'";//Establezco consulta BD
        try {
            con = ConexionBD.getConnection();//Obtengo la conexión
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            rs = st.executeQuery(consulta);//Ejecuto la consulta y la guardo en el objeto rs
            while (rs.next()) {
                String avion = new String(); //Creo un nuevo string pais
                avion = rs.getString("placaavion"); //Seteo los datos de la iteración
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
    
    //Consultar Vuelos para reporte
    
    public ArrayList<Vuelo> listaVuelos(){ //Método que obtiene, guarda y devuelve un arraylist
        ArrayList<Vuelo> aVueloTemp = new ArrayList<>();//Creo ArrayList temporal
        String consulta = "select PV.codlinea, PV.idprograma, L1.nomlugar as \"origen\", L2.nomlugar as \"destino\", V.fecha, DI.iddia, DS.idhora "
                        + "from programavuelo PV, vuelo V, dia DI, destino DS, lugar L1, lugar L2 " 
                        + "where PV.idprograma = V.idprograma and PV.idprograma = DI.idprograma and PV.idprograma = DS.idprograma "
                        + "and PV.lug_idlugar = L1.idlugar and PV.lug_idlugar2 = L2.idlugar;";//Establezco consulta BD
        
        try {
            con = ConexionBD.getConnection();//Obtengo la conexión
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            rs = st.executeQuery(consulta);//Ejecuto la consulta y la guardo en el objeto rs
            while (rs.next()) {
                Vuelo vuelo = new Vuelo();
                vuelo.setAerolinea(rs.getString("codlinea"));
                vuelo.setNumeroV(rs.getString("idprograma"));
                vuelo.setOrigen(rs.getString("origen"));
                vuelo.setDestino(rs.getString("destino"));
                vuelo.setFecha(rs.getString("fecha"));
                vuelo.setDia(rs.getString("iddia"));
                String hora;
                if(rs.getString("idhora").length()== 3){
                    hora = (String) rs.getString("idhora").substring(0,1) + ":" + rs.getString("idhora").substring(1, 3);
                }else{
                    hora = (String) rs.getString("idhora").substring(0, 2) + ":" + rs.getString("idhora").substring(2, 4);
                }
                System.out.println(hora);
                vuelo.setHora(hora);//Seteo los datos de la iteración
                aVueloTemp.add(vuelo);//Añado a arraylist el objeto
            }
            st.close();// cierro la conexión
            ConexionBD.dissconect(); //me desconecto de la base de datos
        } catch (SQLException e) {//Si captura algún error lo muestra
            System.out.println("Consulta imposible");
            System.out.println(e);
        }
        return aVueloTemp;//Retorno arraylist
    }
}
