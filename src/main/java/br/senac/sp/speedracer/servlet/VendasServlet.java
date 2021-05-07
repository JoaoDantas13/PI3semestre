/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.servlet;

import br.senac.sp.speedracer.dao.VendasDAO;
import br.senac.sp.speedracer.entidade.Vendas;
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
public class VendasServlet extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       List<Vendas> listaVendas = VendasDAO.getVendas();
        
       request.setAttribute("listaVendas", listaVendas);
       
       request.getRequestDispatcher("/listaVendas.jsp").forward(request, response);
        
    }

}
