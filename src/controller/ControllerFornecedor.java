package controller;

import dao.DaoFornecedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GestaoFornecedor;


public class ControllerFornecedor {

    public void salvar(String cnpj, boolean recorrente, String nome, String endereco, String taxa) throws SQLException {
        if(recorrente){
          
            GestaoFornecedor fornecedor = new GestaoFornecedor(nome, cnpj, endereco, recorrente, Integer.parseInt(taxa));
            new DaoFornecedor().salvar(fornecedor);
        }else{
         GestaoFornecedor fornecedor = new GestaoFornecedor(cnpj, recorrente, nome, endereco);
         new DaoFornecedor().salvar(fornecedor);

        }
//        System.out.println("Metodo salvar ControllerFonecedor realizado");
    }

    public void deletar(String cnpj) throws SQLException {
        new DaoFornecedor().deletar(cnpj);
        System.out.println("Metodo deletar ControllerFonecedor realizado");
    }
//
//    public void editar(int idFornecedor, String nome, int taxaDesconto, String endereco, boolean recorrente, String cnpj) throws SQLException {
//        GestaoFornecedor fornecedor = new GestaoFornecedor(idFornecedor, nome, taxaDesconto, endereco, recorrente, cnpj);
//        new DaoFornecedor().atualizar(fornecedor);
//        System.out.println("Metodo editar ControllerFornecedor realizado");
//    }


    public ArrayList<GestaoFornecedor> getAll() throws SQLException {
        ArrayList< GestaoFornecedor> fornecedores = (ArrayList<GestaoFornecedor>) (ArrayList<?>) new DaoFornecedor().getAll();
        return fornecedores;
    }
    
    
    public Object selecionaObjeto(int id) throws SQLException{
        GestaoFornecedor fornecedor = (GestaoFornecedor) new DaoFornecedor().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerFornecedor realizado");
        return fornecedor;
    }
    


    
//    
//    public static void main(String[] args)  throws SQLException {
//        ControllerFornecedor cf = new ControllerFornecedor();
//        //cf.salvar("São Gabriel", "10", "Rua são", true, "22222233333344");
//        //cf.editar("São Gabriel", "Rua Gabriel", "22222233333344", 5, true);
//        cf.deletar("22222233333344");
//    }
}

