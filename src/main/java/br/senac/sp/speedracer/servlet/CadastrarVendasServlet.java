
package br.senac.sp.speedracer.servlet;

import br.senac.sp.speedracer.dao.VendasDAO;
import br.senac.sp.speedracer.entidade.Vendas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class CadastrarVendasServlet extends HttpServlet {
      
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String PLACA = request.getParameter("PLACA");
        String NOME = request.getParameter("NOME");
        int QUANTIDADE = request.getIntHeader("QUANTIDADE");
        double PRECOUNIT = request.getDateHeader("PRECOUNIT");
  
        
        Vendas vendas = new Vendas(PLACA, NOME, QUANTIDADE, PRECOUNIT);
        boolean ok = VendasDAO.cadastrar(vendas);
        
       
    }  

}

    

