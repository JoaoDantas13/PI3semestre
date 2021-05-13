/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.servlet;

import br.senac.sp.speedracer.dao.ClienteDAO;
import br.senac.sp.speedracer.entidade.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicius Hilario
 */
public class ClienteInativoServlet extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Cliente> listaClientesInativos = ClienteDAO.getClientesInativos();
        
       request.setAttribute("listaClientesInativos", listaClientesInativos);
       
       request.getRequestDispatcher("/listaClientesInativos.jsp").forward(request, response);
    }

    
    
    
}