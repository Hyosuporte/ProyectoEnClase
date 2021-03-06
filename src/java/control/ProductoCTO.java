package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.ProductoDTO;

public class ProductoCTO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Facade fcdFacade = new Facade();
            String accion = request.getParameter("accion");
            switch (accion) {
                case "listarProductos":
                    List<ProductoDTO> listaProductos = new ArrayList<ProductoDTO>();
                    listaProductos = fcdFacade.listarProductos();
                    request.setAttribute("listaProductos", listaProductos);
                    request.getRequestDispatcher("/productoVTA.jsp").forward(request, response);
                    break;
                case "editar":
                    break;
                case "eliminar":
                    ProductoDTO objEli = new ProductoDTO();
                    objEli.setId(Integer.parseInt(request.getParameter("id")));
                    if (fcdFacade.eliminarProducto(objEli)) {
                        System.out.println("Eliminado Con Exito");
                        request.getRequestDispatcher("ProductoCTO?accion=listarProductos").forward(request, response);
                    }else{
                        System.out.println("Error al intentar ELIMINAR");
                    }
                    break;
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
