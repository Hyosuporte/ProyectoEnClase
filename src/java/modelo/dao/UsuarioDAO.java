package modelo.dao;

import conexion.conexionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.dto.UsuarioDTO;
import modelo.interfaces.interfasDAO;

public class UsuarioDAO  implements interfasDAO<UsuarioDTO>{
    
    private static final String VALIDAR_US = "select * from tb_usuario WHERE correo = ? AND clave = ?";
    
    private conexionSQL conexion = conexionSQL.getIntance();
     
    @Override
    public boolean create(UsuarioDTO temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioDTO read(UsuarioDTO filt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UsuarioDTO temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(UsuarioDTO temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public UsuarioDTO valSesion(UsuarioDTO temp){
        UsuarioDTO nn = null;
        PreparedStatement consulta;
        try{
            consulta = conexion.getConexion().prepareStatement(VALIDAR_US);
            consulta.setString(1, temp.getCorreo());
            consulta.setString(2, temp.getClave());
            ResultSet datos = consulta.executeQuery();
            if(datos.next()){
                nn = new UsuarioDTO(datos.getInt("id"), 
                        datos.getString("nombre1"), 
                        datos.getString("nombre2"), 
                        datos.getString("apellido1"), 
                        datos.getString("apellido2"),
                        datos.getString("n_identificacion"), 
                        datos.getString("correo"));
            }
        }catch(SQLException ex){
            System.out.println("Erro al consultar la validacion del usuario");
        }finally{
            conexion.cerrarConexion();
        }
        return nn;
    }
}
