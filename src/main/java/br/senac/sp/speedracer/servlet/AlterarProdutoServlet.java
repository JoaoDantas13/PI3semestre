
package br.senac.sp.speedracer.servlet;

import br.senac.sp.speedracer.dao.ProdutoDAO;
import br.senac.sp.speedracer.entidade.Produto;
import br.senac.sp.speedracer.utils.Redirect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOME
 */
public class AlterarProdutoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String placa = request.getParameter("placa");
        
        Produto produto = ProdutoDAO.getProduto(placa);
        request.setAttribute("produto", produto);
        
        request.getRequestDispatcher("/produtos/alterarProduto.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String placa = request.getParameter("placa");
        String nome = request.getParameter("nome");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        double precoUnit = Double.parseDouble(request.getParameter("precoUnit"));
        int loja = Integer.parseInt(request.getParameter("loja"));
        String status = request.getParameter("status");
        
        Produto produto = new Produto(placa, nome, quantidade, precoUnit, loja, status);
        boolean ok = ProdutoDAO.atualizar(produto);
        Redirect.sendRedirect(ok, response);
        
    }


}
