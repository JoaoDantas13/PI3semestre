/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.servlet;

import br.senac.sp.speedracer.dao.VendaDAO;
import br.senac.sp.speedracer.entidade.Venda;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author saulo.ambezerra
 */
public class GerarRelatorioPorLojaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loja = request.getParameter("loja");
        String ordenacao = request.getParameter("ordenacao");

        String dataForm1 = request.getParameter("datainicial");
        Date dataInicial = Date.valueOf(dataForm1);
        String dataForm2 = request.getParameter("datafinal");
        Date dataFinal = Date.valueOf(dataForm2);

        List<Venda> listaVendas = VendaDAO.vendasPorLoja(loja, dataFinal, dataInicial, ordenacao);

        request.setAttribute("listaVendas", listaVendas);

        request.getRequestDispatcher("/relatorio.jsp").forward(request, response);
    }
}
