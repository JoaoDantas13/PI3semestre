/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.servlet;

import br.senac.sp.speedracer.dao.ProdutoDAO;
import br.senac.sp.speedracer.entidade.Produto;
import br.senac.sp.speedracer.utils.Redirect;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOME
 */
public class CadastraProdutoServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String placa = request.getParameter("placa");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String tipo = request.getParameter("tipo");
        int quantidade = 1;
        double precoUnit = Double.parseDouble(request.getParameter("precoUnit"));
        int loja = Integer.parseInt(request.getParameter("loja"));
        String status = "Ativo";
        
        Produto produto = new Produto(placa, marca, modelo, tipo, quantidade, precoUnit, loja, status);
        boolean ok = ProdutoDAO.cadastrar(produto);
        
        if(ok){
            
            response.sendRedirect(request.getContextPath() + "/sucesso.jsp");
            
        } else {
            
            String msg = "O cadastro não foi realizado!!";
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
            
        }

    }  
}
