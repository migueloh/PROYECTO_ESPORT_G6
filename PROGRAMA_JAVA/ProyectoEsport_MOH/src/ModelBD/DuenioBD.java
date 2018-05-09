package ModelBD;

import Exceptions.ConexionProblemas;
import Exceptions.DuenioNoExiste;
import ModelUML.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

        PreparedStatement pS = con.prepareStatement("INSERT INTO duenio (dni, nombre, apellido, codLogin) VALUES (?,?,?,?)");
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
