package controller;

import dao.DaoFornecedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GestaoFornecedor;


public class ControllerFornecedor {

    public void salvar(String nome, String taxaDesconto, String endereco, boolean recorrente, String cnpj) throws SQLException {
        if(recorrente){
           int taxaDesc = Integer.parseInt(taxaDesconto);
        GestaoFornecedor fornecedor = new GestaoFornecedor(nome, taxaDesc, endereco, true, cnpj);
        
        new DaoFornecedor().salvar(fornecedor);
        }else{
        GestaoFornecedor fornecedor = new GestaoFornecedor(cnpj, recorrente,nome, endereco);
        new DaoFornecedor().salvar(fornecedor);
        
        }
     
        System.out.println("Metodo salvar ControllerFonecedor realizado");
    }

    public void deletar(String cnpj) throws SQLException {
        new DaoFornecedor().deletar(cnpj);
    }

    public void editar(String nome, String endereco, String cnpj, int taxaDesconto, boolean recorrente) throws SQLException {
        GestaoFornecedor fornecedor = new GestaoFornecedor(nome, taxaDesconto, endereco, true, cnpj);
        new DaoFornecedor().atualizar(fornecedor);
        System.out.println("Metodo editar ControllerFornecedor realizado");
    }


    public ArrayList<GestaoFornecedor> getAll() throws SQLException {
        ArrayList< GestaoFornecedor> fornecedores = (ArrayList<GestaoFornecedor>) (ArrayList<?>) new DaoFornecedor().getAll();
        System.out.println("Metodo getAll realizado");
        return fornecedores;
    }


    
//    
//    public static void main(String[] args)  throws SQLException {
//        ControllerFornecedor cf = new ControllerFornecedor();
//        //cf.salvar("São Gabriel", "10", "Rua são", true, "22222233333344");
//        //cf.editar("São Gabriel", "Rua Gabriel", "22222233333344", 5, true);
//        cf.deletar("22222233333344");
//    }
}

