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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicius-Hilário
 */
public class CadastrarClienteServlet extends HttpServlet {
      
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        String cidade = request.getParameter("cidade");
        char sexo = request.getParameter("sexo").charAt(0);
        int ativo = request.getIntHeader("ativo");
        int loja = Integer.parseInt(request.getParameter("loja"));
        
        Cliente cliente = new Cliente(nome, email, cpf, endereco, cidade, sexo, ativo, loja);
        boolean ok = ClienteDAO.cadastrar(cliente);
        
        if(ok){
            
            response.sendRedirect(request.getContextPath() + "/sucesso.jsp");
            
        } else {
            
            String msg = "O cadastro não foi realizado!!";
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
            
        }
    }  

}
