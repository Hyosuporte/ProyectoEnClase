package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author carlos andres
 */
public class sesionCTO extends HttpServlet {

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
            String accion = request.getParameter("accion");
            switch (accion) {
                case "validar":
                    UsuarioDAO dao = new UsuarioDAO();
                    String usuario = request.getParameter("txtusuario");
                    //Usamos el metodo encriptarClave para guardar la clave encirptada del usuario
                    String clave = encriptarClave(request.getParameter("txtpassword"));
                    UsuarioDTO dto = new UsuarioDTO(usuario, clave);
                    dto = dao.valSesion(dto);
                    if (dto != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("usActual", dto);
                        request.getRequestDispatcher("ProductoCTO?accion=listarProductos").forward(request, response);
                    } else {
                        System.out.println("Error al validar");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    break;
                case "registrar":
                    break;
                case "salir":
                    break;
            }
        }
    }

    private String encriptarClave(String clave) {
        String claveNue = "";
        try {
            MessageDigest sna256 = MessageDigest.getInstance("SHA-256");
            sna256.reset();
            //Se pasa la clave a sna256
            sna256.update(clave.getBytes("utf8"));
            //se pasa la clave de sna256 a base 64
            claveNue = Base64.getEncoder().encodeToString(sna256.digest());
            System.out.println(claveNue);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println("Error al codificar la clave");
        }
        return claveNue;
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
