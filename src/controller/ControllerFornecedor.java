/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Kaio
 */
import dao.DaoFornecedor;
import java.sql.SQLException;
import java.util.List;
import model.GestaoFornecedor;


public class ControllerFornecedor {
    

  public void salvar(String nome ,int taxaDesconto, String endereco, boolean recorrente, String cnpj) throws SQLException{
      GestaoFornecedor fornecedor = new GestaoFornecedor(nome, cnpj, endereco, true,taxaDesconto);
      new DaoFornecedor().salvar(fornecedor);
  }
  
  
  public void deletar(int id) throws SQLException{
     new DaoFornecedor().deletar(id);
  }
  
  public void editar(String nome ,String endereco ,String cnpj,int taxaDesconto,boolean recorrente) throws SQLException{
      GestaoFornecedor fornecedor = new GestaoFornecedor(nome, cnpj, endereco, recorrente, taxaDesconto);
      new DaoFornecedor().atualizar(fornecedor);    
  }

            //testes
    public static void main(String[] args) throws SQLException {
        ControllerFornecedor cf = new ControllerFornecedor();
        cf.salvar("nome1",10,"endereco1",false,"11111111111111");
    }
  
  
    
    
    
}
