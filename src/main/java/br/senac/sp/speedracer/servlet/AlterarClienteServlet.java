/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.servlet;

import br.senac.sp.speedracer.dao.ClienteDAO;
import br.senac.sp.speedracer.entidade.Cliente;
import br.senac.sp.speedracer.utils.Redirect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicius Hilario
 */
public class AlterarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cpf = request.getParameter("cpf");
        
        Cliente cliente = ClienteDAO.dadosAlterar(cpf);
        request.setAttribute("cliente", cliente);
        
        request.getRequestDispatcher("/clientes/alterar.jsp").forward(request, response);
        
    }

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
        
        Cliente cliente = new Cliente(nome, email, cpf, endereco, cidade, sexo, ativo);
        boolean ok = ClienteDAO.alterar(cliente);
        Redirect.sendRedirect(ok, response);
    }
}
