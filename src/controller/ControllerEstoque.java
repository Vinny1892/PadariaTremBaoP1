package controller;

import model.GestaoEstoque;
import dao.DaoEstoque;
import java.sql.SQLException;
import java.util.Date;

import model.GestaoProduto;
import model.GestaoFornecedor;
import controller.ControllerFornecedor;
import java.util.ArrayList;
import java.util.List;

public class ControllerEstoque {
    /*
    Metodo utilizado para chamar o metodo salvar() da classe DaoEstoque,
    passando como parametro o objeto GestaoEstoque.
    */
    public void salvar(int qtdProduto, String dataValidade, GestaoProduto produto) throws SQLException {
        GestaoEstoque estoque = new GestaoEstoque(qtdProduto, dataValidade, produto);
        new DaoEstoque().salvar(estoque);
        System.out.println("Metodo salvar ControllerEstoque realizado");
    }

    /*
    Metodo utilizado para chamar o metodo deletar() da classe Dao estoque,
    passando como parametro o idestoque.
    */
    public void deletar(String idestoqueSt) throws SQLException {
        new DaoEstoque().deletar(idestoqueSt);
        System.out.println("Metodo deletar ControllerEstoque realizado");
    }

    /*
    Metodo utilizado para chamar o metodo atuzalizar() da classe DaoEstoque,
    passando como parametro o objeto a ser editado e seus novos parametros.
    */
    public void editar(int qtdProduto, String dataValidade, GestaoProduto produto) throws SQLException {
        GestaoEstoque estoque = new GestaoEstoque(qtdProduto, dataValidade, produto);
        new DaoEstoque().atualizar(estoque);
        System.out.println("Metodo editar ControllerEstoque realizado");
    }
    
    /*
    Metodo utilizado para chamar o metodo getAll() da classes DaoEstoque,
    retornando um ArrayList de objetos GestaoEstoque.
    */
    public ArrayList<GestaoEstoque> getAll() throws SQLException {
        ArrayList< GestaoEstoque> todoEstoque = (ArrayList<GestaoEstoque>) (ArrayList<?>) new DaoEstoque().getAll();
        System.out.println("Metodo getAll ControllerEstoque realizado");
        return todoEstoque;
    }
    
    /*
    Metodo utilizado para chamar o metodo getById() da classes DaoEstoque,
    retornando um ArrayList de objetos GestaoEstoque, pois o id_estoque pode se repetir.
    */
    public ArrayList<GestaoEstoque> selecionaObjetosById(int id) throws SQLException{
        ArrayList<GestaoEstoque> estoquesById = (ArrayList<GestaoEstoque>) (ArrayList<?>) new DaoEstoque().getById(id);
        System.out.println("Metodo selecionaObjetosById ControllerEstoque realizado");
        return estoquesById;
    }
    
 
    

//    public static void main(String[] args) throws SQLException {
//        ControllerFornecedor cf = new ControllerFornecedor();
//        cf.salvar("São Gabriel", "10", "Fazendo Sao Gabriel", true, "88888877777");
//        GestaoFornecedor fornecedor = new GestaoFornecedor("São Gabriel", 10, "Fazendo Sao Gabriel", true, "88888877777")        
//        ControllerProduto cp = new ControllerProduto();
//       cp.salvar("leite caixa", fornecedor, 0, "leite de caixinha");
//        GestaoProduto produto = new GestaoProduto("leite caixa", fornecedor, 0, "leite de caixinha");
//        
//        ControllerEstoque ce = new ControllerEstoque();
//        ce.salvar(20, "01/11/2018" , produto);
//    }
    
    /*
    public static void main(String[] args) throws SQLException {
        ControllerEstoque cee = new ControllerEstoque();
        ArrayList<GestaoEstoque> estoques = cee.getAll();
        System.out.println(estoques.size());
        for (int i = 0; i < estoques.size(); i++) {
             System.out.println(estoques.get(i).getProduto().getNome());
        }
    }*/

} 
