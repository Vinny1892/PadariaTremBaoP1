package controller;

import dao.DaoFornecedor;
import java.sql.SQLException;
import java.util.List;
import model.GestaoFornecedor;
import dao.CRUDBasico;
public class ControllerFornecedor{
    
  public void salvar(String nome ,String taxaDesconto, String endereco, boolean recorrente, String cnpj) throws SQLException{
      int taxaDesc = Integer.parseInt(taxaDesconto);
      GestaoFornecedor fornecedor = new GestaoFornecedor(nome, cnpj, endereco, true,taxaDesc);
      new DaoFornecedor().salvar(fornecedor);
  }
  
  public void deletar(int id) throws SQLException{
     new DaoFornecedor().deletar(id);
  }
  
  public void editar(String nome ,String endereco ,String cnpj,int taxaDesconto,boolean recorrente) throws SQLException{
      GestaoFornecedor fornecedor = new GestaoFornecedor(nome, cnpj, endereco, recorrente, taxaDesconto);
      new DaoFornecedor().atualizar(fornecedor);
      System.out.println("editar ControllerFonecedor realizado");
  }
    //testes
    public static void main(String[] args) throws SQLException {
        ControllerFornecedor cf = new ControllerFornecedor();
        cf.salvar("kkkkkk",10,"endereco1",false,"11111111111111");
        //cf.editar("nome11", "end11", "21111111111111", 10, true);
        //cf.deletar(3);
    }

}
