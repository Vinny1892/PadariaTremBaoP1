package controller;

import dao.DaoFornecedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GestaoFornecedor;
public class ControllerFornecedor{
    
  public void salvar(String nome ,String taxaDesconto, String endereco, boolean recorrente, String cnpj) throws SQLException{
      int taxaDesc = Integer.parseInt(taxaDesconto);
      GestaoFornecedor fornecedor = new GestaoFornecedor(nome, cnpj, endereco, true,taxaDesc);
      Object objeto = (Object) fornecedor;
      new DaoFornecedor().salvar(objeto);
      System.out.println("Metodo salvar ControllerFonecedor realizado");
  }
  
  public void deletar(String nome) throws SQLException{
     new DaoFornecedor().deletar(nome);
  }
  
  public void editar(String nome ,String endereco ,String cnpj,int taxaDesconto,boolean recorrente) throws SQLException{
      GestaoFornecedor fornecedor = new GestaoFornecedor(nome, cnpj, endereco, recorrente, taxaDesconto);
      new DaoFornecedor().atualizar(fornecedor);
      System.out.println("Metodo editar ControllerFornecedor realizado");
  }
  
  public ArrayList<Object> getAll() throws SQLException{   
      
      
   return new DaoFornecedor().getAll();
     
  }
  
 

}
