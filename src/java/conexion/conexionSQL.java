package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionSQL {

    private static conexionSQL instance; //objeto singleton
    private Connection conexion = null;
    private String bd = "bd_tallerjavaweb";
    private String usuario = "root";
    private String clave = "";

    private conexionSQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/"+bd, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la parte de la conexion :"+ e);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public static synchronized conexionSQL getIntance() {
        if (instance == null) {
            instance = new conexionSQL();
        }
        return instance;
    }

    public void cerrarConexion() {
        /*    if(conexion != null)
        {
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println("Error :"+ e.getMessage());
            }
        }*/
        instance = null;
    }
}