/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.servlet;

import br.senac.sp.speedracer.dao.RelatorioAnaliticoDAO;
import br.senac.sp.speedracer.entidade.RelatorioAnalitico;
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
public class GerarRelatorioAnaliticoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<RelatorioAnalitico> relatorio = new ArrayList<>();
        String buscaPor = request.getParameter("buscapor");
        String palavraChave = request.getParameter("palavrachave");

        Date dataInicial = Date.valueOf(request.getParameter("datainicial"));
        Date dataFinal = Date.valueOf(request.getParameter("datafinal"));
        
        switch(buscaPor){
            case "filial":
                relatorio = RelatorioAnaliticoDAO.relatorioPorFilial(palavraChave, dataInicial, dataFinal);
                break;
            case "cliente":
                relatorio = RelatorioAnaliticoDAO.relatorioPorProduto(palavraChave, dataInicial, dataFinal);
                break;
            case "produto":
                relatorio = RelatorioAnaliticoDAO.relatorioPorProduto(palavraChave, dataInicial, dataFinal);
                break;
        }

        request.setAttribute("relatorio", relatorio);
        request.getRequestDispatcher("./relatorioAnalitico.jsp").forward(request, response);
    }
}
