package com.mycompany.lojapereirao.controller;

import com.mycompany.lojapereirao.dao.ProdutoDao;
import com.mycompany.lojapereirao.dao.VendaDao;
import com.mycompany.lojapereirao.model.Cliente;
import com.mycompany.lojapereirao.model.Produto;
import com.mycompany.lojapereirao.model.Venda;
import java.util.ArrayList;

public class VendaController {

    public static boolean ValidarCpf(long cpf) {
        boolean retorno = false;

        retorno = VendaDao.ValidarCpf(cpf);

        return retorno;
    }

    public static String[] ValidarSaldo(int codprod) {

        Produto objRetorno = VendaDao.ValidarSaldo(codprod);
        String[] retorno = null;

        if (objRetorno != null) {

            retorno = new String[]{String.valueOf(objRetorno.getSaldo())
            };
        }

        return retorno;
    }

    public static String[] consultaCodCli(long cpf) {

        Cliente objRetorno = VendaDao.consultaCodCli(cpf);
        String[] retorno = null;

        if (objRetorno != null) {

            retorno = new String[]{String.valueOf(objRetorno.getCodCli())
            };
        }

        return retorno;
    }

    public static ArrayList<String[]> IncluirLinha(int codprod, int qtd) {

        ArrayList<Venda> listaVendas = VendaDao.Listar(codprod, qtd);

        ArrayList<String[]> listaRetorno = new ArrayList<>();

        for (Venda vend : listaVendas) {
            listaRetorno.add(new String[]{String.valueOf(vend.getCodProd()),
                String.valueOf(qtd),
                String.valueOf(vend.getValorUnt()),
                String.valueOf(qtd * vend.getValorUnt()),});
        }

        return listaRetorno;
    }

    public static boolean Salvar(int codcli, long cpf, int codprod, int qtd, String dataVenda, double total) {
        Venda obj = new Venda();
        obj.setCodCli(codcli);
        obj.setCpf(cpf);
        obj.setCodProd(codprod);
        obj.setQtdProd(qtd);
        obj.setDataVenda(dataVenda);
        obj.setValorTotal(total);

        return VendaDao.Salvar(obj);
    }

}
