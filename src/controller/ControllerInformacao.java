package controller;

import dao.DaoCliente;
import dao.DaoEstoque;
import dao.DaoFornecedor;
import dao.DaoGerente;
import dao.DaoPadeiro;
import dao.DaoProduto;
import dao.DaoVenda;
import dao.DaoVendedor;
import dao.GenericDao;
import model.GestaoInformacao;

public class ControllerInformacao {

    public ControllerInformacao(String type, String location) {
        
    }

    public ControllerInformacao(String type, String location, int cod) {
    }

    //nao sei se retorna uma dao ou um model...
    GenericDao convertType(String option) {
        GenericDao myClass;
        switch (option) {
            case "Fornecedores":
                myClass = new DaoFornecedor();
                break;
            case "Produtos":
                myClass = new DaoProduto();
                break;
            case "Padeiros":
                myClass = new DaoPadeiro();
                break;
            case "Vendedores":
                myClass = new DaoVendedor();
                break;
            case "Gerentes":
                myClass = new DaoGerente();
                break;
            case "Clientes":
                myClass = new DaoCliente();
                break;
            case "Venda":
                myClass = new DaoVenda();
                break;
            case "Estoque":
                myClass = new DaoEstoque();
                break;
            default:
                myClass = null;
        }
        return myClass;
    }
}
