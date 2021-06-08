package br.senac.sp.speedracer.servlet;

import br.senac.sp.speedracer.dao.UsuarioDAO;
import br.senac.sp.speedracer.entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vinicius-Hilário
 */
public class LoginServlet extends HttpServlet {
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Usuario usuario = UsuarioDAO.getUsuario(login, senha);
        
        if(usuario != null){
            
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/protegido/index.jsp");
        }
    }

}
