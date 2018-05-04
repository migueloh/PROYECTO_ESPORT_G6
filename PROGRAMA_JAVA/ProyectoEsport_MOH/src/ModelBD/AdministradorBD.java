package ModelBD;

import Exceptions.*;
import ModelUML.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author MIGUEL
 */
public class AdministradorBD extends GenericoBD {

    private Connection con;

    // INSERTAR ADMINISTRADOR
    public void insertarAdministradorBD(Administrador administrador, String tipo) throws SQLException, ClassNotFoundException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        LoginBD loginBD = new LoginBD();
        Integer codLogin = loginBD.generarLogin(administrador.getDni(), administrador.getNombre(), administrador.getApellido(), tipo);

        PreparedStatement pS = con.prepareStatement("INSERT INTO administrador (dni, nombre, apellido, codLogin) VALUES (?,?,?,?)");
        pS.setString(1, administrador.getDni());
        pS.setString(2, administrador.getNombre());
        pS.setString(3, administrador.getApellido());
        pS.setInt(4, codLogin);
        pS.executeUpdate();

        con.close();
    }

    // LOCALIZAR ADMINISTRADOR
    public Administrador localizarAdministrador(String dni) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        Administrador administrador = new Administrador();

        String consultaSQL = "SELECT codAdministrador, dni, nombre, apellido, codLogin FROM administrador WHERE dni = ?";

        PreparedStatement pS = con.prepareStatement(consultaSQL);

        pS.setString(1, dni.toUpperCase());

        ResultSet datosRS = pS.executeQuery();
            if (!datosRS.next()) {
                throw new AdminNoExiste();
            } else {

                administrador.setCodAdministrador(datosRS.getInt("codAdministrador"));
                administrador.setDni(datosRS.getString("dni"));
                administrador.setNombre(datosRS.getString("nombre"));
                administrador.setApellido(datosRS.getString("apellido"));
                administrador.setLogin(new Login(datosRS.getInt("codLogin")));
            }
        
        con.close();
        return administrador;
    }
    
    // EDITAR ADMINISTRADOR
    public void ejecutarModificacion(Administrador administradorUML) throws SQLException, ConexionProblemas {
        
        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        String editaSQL = "UPDATE administrador SET nombre = ?  where dni = ?";

        PreparedStatement pS = con.prepareStatement(editaSQL);
        
        pS.setString(1, administradorUML.getNombre());
        pS.setString(2, administradorUML.getDni());
        
        
        pS.executeUpdate();
        
        con.close();

    }
    

    

}
