package control;

import java.util.List;
import modelo.dao.ProductoDAO;
import modelo.dto.ProductoDTO;

public class Facade {
    
    public List<ProductoDTO> listarProductos(){
        List<ProductoDTO> lista;
        ProductoDAO dao = new ProductoDAO();
        lista = dao.readAll();
        return lista;
    }
    
    public boolean eliminarProducto(ProductoDTO temp){
        ProductoDAO dao = new ProductoDAO();
        return dao.delete(temp);
    }
    
}
