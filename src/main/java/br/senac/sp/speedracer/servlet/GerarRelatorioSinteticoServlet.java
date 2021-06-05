/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.servlet;

import br.senac.sp.speedracer.dao.RelatorioSinteticoDAO;
import br.senac.sp.speedracer.entidade.RelatorioSintetico;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author saulo.ambezerra
 */
public class GerarRelatorioSinteticoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<RelatorioSintetico> relatorio = new ArrayList<>();
        String buscaPor = request.getParameter("buscapor");

        Date dataInicial = Date.valueOf(request.getParameter("datainicial"));
        Date dataFinal = Date.valueOf(request.getParameter("datafinal"));
        
        switch(buscaPor){
            case "produto":
                relatorio = RelatorioSinteticoDAO.relatorioPorModelo(dataInicial, dataFinal);
                break;
            case "cliente":
                relatorio = RelatorioSinteticoDAO.relatorioCliente(dataInicial, dataFinal);
                break;
            case "filial":
                relatorio = RelatorioSinteticoDAO.relatorioPorFilial(dataInicial, dataFinal);
                break;
        }

        request.setAttribute("relatorio", relatorio);
        request.setAttribute("buscaPor", buscaPor);
        request.getRequestDispatcher("./relatorioSintetico.jsp").forward(request, response);
    }
}
