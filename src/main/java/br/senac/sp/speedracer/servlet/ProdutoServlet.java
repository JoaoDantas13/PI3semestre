    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.servlet;

import br.senac.sp.speedracer.dao.ProdutoDAO;
import br.senac.sp.speedracer.entidade.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        
        List<Produto> listaProdutos = ProdutoDAO.getProdutos();
        
        request.setAttribute("listaProdutos", listaProdutos);
        
        request.getRequestDispatcher("/protegido/gerente/produtos/listaProdutos.jsp").forward(request, response);
    }            
}