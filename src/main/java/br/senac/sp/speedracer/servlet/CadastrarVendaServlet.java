/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.speedracer.servlet;

import br.senac.sp.speedracer.dao.VendaDAO;
import br.senac.sp.speedracer.entidade.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João Dantas
 */
public class CadastrarVendaServlet extends HttpServlet {
      
       
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String placa = request.getParameter("placa");
        String cpfCli = request.getParameter("cpfCli");
        double precoUnit = Double.parseDouble(request.getParameter("precoUnit"));
        int filial = Integer.parseInt(request.getParameter("filial"));
        
        String dataForm = request.getParameter("data");
        Date date = Date.valueOf(dataForm);
                             
        Venda venda = new Venda(placa, cpfCli, precoUnit, filial, date);
         boolean ok = VendaDAO.cadastrar(venda, date);
         
         if(ok){
            
            response.sendRedirect(request.getContextPath() + "/sucesso.jsp");
        } else {
            String msg = "Não foi possível cadastrar a venda";
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
    
}
