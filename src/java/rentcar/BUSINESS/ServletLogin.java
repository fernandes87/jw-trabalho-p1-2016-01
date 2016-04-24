/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentcar.BUSINESS;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rentcar.BEANS.Usuario;
import rentcar.DAO.UsuarioDAOImpl;
import rentcar.UTIL.JavaWebException;

/**
 *
 * @author LEONE
 */
public class ServletLogin extends HttpServlet {

    
    //private static final long serialVersionUID = 1;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String usuario = request.getParameter("edtUsuario");
        String senha = request.getParameter("edtSenha");
        try {
            Usuario validando = new UsuarioDAOImpl().getUsuario(usuario, senha);
            if (validando != null) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletLogin</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet ServletLogin at " + validando.getusuario() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletLogin</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Usuario errado.</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (JavaWebException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }
}