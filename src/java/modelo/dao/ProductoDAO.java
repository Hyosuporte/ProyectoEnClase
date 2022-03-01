package modelo.dao;

import conexion.conexionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.ProductoDTO;
import modelo.interfaces.interfasDAO;

public class ProductoDAO implements interfasDAO <ProductoDTO>{

    private static final String SQL_CREATE="insert into tb_producto (nombre_producto,descripcion_producto,unidades,valor) values (?,?,?,?)";
    private static final String SQL_DELETE="delete from tb_producto where id_producto = ?";
    private static final String SQL_UPDATE="update tb_producto set nombre_producto = ?, descripcion_producto,unidades =?, valor = ? where id_producto = ?";
    private static final String SQL_READ="select * from tb_producto where id_producto = ?";
    private static final String SQL_READALL="select * from tb_producto";
    
    private conexionSQL conexion = conexionSQL.getIntance();
    
    @Override
    public boolean create(ProductoDTO temp) {
        try{
            PreparedStatement consulta;
            consulta = conexion.getConexion().prepareStatement(SQL_CREATE);
            consulta.setString(1, temp.getNombre());
            consulta.setString(2, temp.getDescripcion());
            consulta.setInt(3, temp.getUnidad());
            consulta.setLong(4, temp.getValor());
            conexion.getConexion().close();
            return consulta.executeUpdate()> 0;
            
        } catch (SQLException ex) {
           System.out.println("Error: "+ ex);
        }finally{
            //conexion.cerrarConexion();
           
        }
        return false;
    }

    @Override
    public List<ProductoDTO> readAll() {
        List<ProductoDTO> lista = new ArrayList<ProductoDTO>();
        try{
            Statement consulta;
            consulta = conexion.getConexion().createStatement();
            ResultSet registro = consulta.executeQuery(SQL_READALL);
            while(registro.next()){
                ProductoDTO objP = new ProductoDTO(registro.getInt("id_producto"),registro.getString("nombre_producto"),registro.getString("descripcion_producto"),registro.getInt("unidades"),registro.getLong("valor"));
                lista.add(objP);
            }
        }catch(SQLException ex){
            System.out.println("Error consultar : "+ex.getLocalizedMessage());
        }finally{
            conexion.cerrarConexion();
        }
        return lista;
    }

    @Override
    public ProductoDTO read(ProductoDTO filt) {
        ProductoDTO objP = null;
        PreparedStatement consulta;
        try{
            consulta = conexion.getConexion().prepareStatement(SQL_READ);
            consulta.setInt(1, filt.getId());
            ResultSet registro = consulta.executeQuery();
            if(registro.next()){
                objP = new ProductoDTO(registro.getInt("id_producto"),
                        registro.getString("nombre_producto"),
                        registro.getString("descripcion_producto"),
                        registro.getInt("unidades"),
                        registro.getLong("valor"));
            }
        }catch(SQLException ex){
            System.out.println("Erro al consultar: "+ex);
        }finally{
            conexion.cerrarConexion();
        }
        return objP;
    }

    @Override
    public boolean update(ProductoDTO temp) {
        PreparedStatement consulta;
        try{
            consulta = conexion.getConexion().prepareStatement(SQL_UPDATE);
            consulta.setString(1, temp.getNombre());
            consulta.setString(2, temp.getDescripcion());
            consulta.setInt(3, temp.getUnidad());
            consulta.setLong(4, temp.getValor());
            consulta.setInt(5, temp.getId());
            return consulta.executeUpdate()> 0;
        }catch(SQLException ex){
            System.out.println("Error actualizar: "+ ex);
        }
        return false;
    }

    @Override
    public boolean delete(ProductoDTO temp) {
        PreparedStatement consulta;
        try{
            consulta = conexion.getConexion().prepareStatement(SQL_DELETE);
            consulta.setInt(1, temp.getId());
            return consulta.executeUpdate()>0;
        }catch(SQLException ex){
            System.out.println("Erro al eliminar: "+ex);
        }
        return false;
    }

}
