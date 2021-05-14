package com.mycompany.lojapereirao.controller;

import com.mycompany.lojapereirao.dao.RelatorioDao;
import com.mycompany.lojapereirao.model.Relatorio;
import java.util.ArrayList;

public class RelatorioController {

    public static ArrayList<String[]> Listar(String dataI, String dataF, String dateInical, String dateFinal) {

        ArrayList<Relatorio> listaRelatorios = RelatorioDao.Listar(dataI, dataF);

        ArrayList<String[]> listaRetorno = new ArrayList<>();

        for (Relatorio rel : listaRelatorios) {
            listaRetorno.add(new String[]{String.valueOf(rel.getCpfCli()),
                 String.valueOf(dateInical),
                 String.valueOf(dateFinal),
                 String.valueOf(rel.getTotal()),
               
            });
        }

        return listaRetorno;
    }

}
