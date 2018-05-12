package ModelBD;

import Exceptions.ConexionProblemas;
import Exceptions.DuenioNoExiste;
import ModelUML.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import proyectoesport_moh.Controladora;

/**
 *
 * @author MIGUEL
 */
public class DuenioBD extends GenericoBD {

    private Connection con;

    // INSERTAR DUENIO
    public void insertarDuenioBD(Duenio duenio, String tipo) throws SQLException, ClassNotFoundException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        LoginBD loginBD = new LoginBD();
        Integer codLogin = loginBD.generarLogin(duenio.getDni(), duenio.getNombre(), duenio.getApellido(), tipo);

        PreparedStatement pS = con.prepareStatement("INSERT INTO duenio d (d.dni, d.nombre, d.apellido, d.codLogin) VALUES (?,?,?,?)");
        pS.setString(1, duenio.getDni().toUpperCase());
        pS.setString(2, duenio.getNombre());
        pS.setString(3, duenio.getApellido());
        pS.setInt(4, codLogin);
        pS.executeUpdate();

        cerrarConexion(con);
    }

    // LOCALIZAR DUEÑO
    public Duenio localizarDuenio(String dni) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        Duenio duenio = new Duenio();

        String consultaSQL = "SELECT d.codDuenio, d.dni, d.nombre, d.apellido, d.codLogin, l.codLogin, l.usuario, l.passwd FROM duenio d, login l  WHERE (d.codLogin = l.codLogin) AND d.dni = ?";

        PreparedStatement pS = con.prepareStatement(consultaSQL);

        pS.setString(1, dni.toUpperCase());

        ResultSet datosRS = pS.executeQuery();
        if (!datosRS.next()) {
            throw new DuenioNoExiste();
        } else {

            duenio.setCodDuenio(datosRS.getInt("codDuenio"));
            duenio.setDni(datosRS.getString("dni"));
            duenio.setNombre(datosRS.getString("nombre"));
            duenio.setApellido(datosRS.getString("apellido"));
            duenio.setLogin(new Login(datosRS.getInt("codLogin")));
            duenio.getLogin().setUser(datosRS.getString("usuario"));
            duenio.getLogin().setPassword(datosRS.getString("passwd"));
        }

        cerrarConexion(con);

        return duenio;
    }

    /*
    // LOCALIZAR TODOS LOS DUENIOS PARA RELLENAR EL COMBO EN EQUIPO / ALTA
    public ArrayList<Duenio> traerTodosLosDuenioBD() throws SQLException, ConexionProblemas {
        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        ArrayList <Duenio> listaDuenios = new ArrayList();
        String consultaSQL = "SELECT * FROM duenio";
        
        Statement sT=con.createStatement();
        
        ResultSet rS = sT.executeQuery(consultaSQL);
        while (rS.next()) {
            Duenio dUn = new Duenio();
        
            dUn.setDni(rS.getString("dni"));
            
            listaDuenios.add(dUn);
        }

        cerrarConexion(con);

        return listaDuenios;

    }
     */
// VOY A POR OTRO
    public ArrayList traerTodosLosDueniosBD() throws SQLException, ConexionProblemas {
        
        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);
 
        ArrayList<Duenio> listaDuenios = new ArrayList();
           
        try {
           
            CallableStatement cS = con.prepareCall("{call ESPORT_MOH_2.PROCE_rellenarcomboDuenios(?)}");
            
            // CADENA DEVUELTA POR EL CURSOR
            cS.registerOutParameter(1, OracleTypes.CURSOR); 

            // EJECUTO EL PROCEDIMIENTO
            cS.execute(); 
            ResultSet rS = (ResultSet) cS.getObject(1);

            if (rS.next()) {
                do {
                    Duenio dUn = new Duenio();
                    dUn.setDni(rS.getString("dni"));
                    dUn.setNombre(rS.getString("nombre"));
                    listaDuenios.add(dUn);
                } while (rS.next());
            } else {
                System.out.println("No hay nada");
            }

            //cadena = llamada.getString(2);// recupero la cadena
            cerrarConexion(con);
        } catch (Exception e) {
            System.out.println(e);

        }

        return listaDuenios;
    }

    // ELIMINAR DUENIO
    public void eliminarDeLaBDDuenio(String dni) throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("DELETE FROM duenio WHERE dni = ?");
        pS.setString(1, dni);

        pS.executeUpdate();

        cerrarConexion(con);

    }

}
