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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GestaoInformacao;

public final class ControllerInformacao {

    public ControllerInformacao(String type, String location) {
        List<Object> objects = convertType(type);
    }

    public ControllerInformacao(String type, String location, int cod) {
       Object object = convertType(type, cod);
    }

    //nao sei se retorna uma dao ou um model...
    protected List<Object> convertType(String option) {
        switch (option) {
            case "Fornecedores":
                try {
                    return new DaoFornecedor().getAll();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Produtos":
                try {
                    return new DaoProduto().getAll();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Padeiros":
                try {
                    return new DaoPadeiro().getAll();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Vendedores":
                try {
                    return new DaoVendedor().getAll();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Gerentes":
                try {
                    return new DaoGerente().getAll();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Clientes":
                try {
                    return new DaoCliente().getAll();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Venda":
                try {
                    return new DaoVenda().getAll();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Estoque":
                try {
                    return new DaoEstoque().getAll();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            default:
                return null;
        }        
    }

    private Object convertType(String type, int cod) {
        switch (type) {
            case "Fornecedores":
                try {
                    return new DaoFornecedor().getById(cod);
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Produtos":
                try {
                    return new DaoProduto().getById(cod);
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Padeiros":
                try {
                    return new DaoPadeiro().getById(cod);
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Vendedores":
                try {
                    return new DaoVendedor().getById(cod);
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Gerentes":
                try {
                    return new DaoGerente().getById(cod);
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Clientes":
                try {
                    return new DaoCliente().getById(cod);
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Venda":
                try {
                    return new DaoVenda().getById(cod);
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "Estoque":
                try {
                    return new DaoEstoque().getById(cod);
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return null;
    }
}
