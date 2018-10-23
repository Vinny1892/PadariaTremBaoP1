package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import controller.ControllerFornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GestaoProduto;
import model.GestaoFornecedor;

/**
 * na entidade PRODUTO, podemos declarar produtos mas nao sua data de validade e
 * a quantidade, a entidade produto funciona mais como um catalogo produtos
 */
public class DaoProduto extends GenericDao implements CRUDBasico {
    /*
    Metodo utilizado para salvar produto na tabela/entidade produto,
    o objeto GestaoProduto recebido como parametro.
    */
    @Override
    public void salvar(Object object) throws SQLException {
        try {
            GestaoProduto produto = (GestaoProduto) object;
            String insert = "INSERT INTO produto (nome, preco_custo, apelido, id_fornecedor, perecivel) VALUES(?,?,?,?,?) ";
            save(insert, produto.getNome(), produto.getPrecoCusto(), produto.getApelido(), produto.getFornecedor().getIdfornecedor(), produto.isPerecivel());
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("codigo do produto ja existe");
            JOptionPane.showMessageDialog(null, "Código do produto já existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor");
        }
    }
    /*
    Metodo utilizado para editar um produto na tabela/entidade produto,
    com o objeto recebido, de acordo com id deste objeto.
    */
    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoProduto produto = (GestaoProduto) object;
        String update = "UPDATE produto SET nome = ?,preco_custo = ?, apelido = ?,id_fornecedo = ?, perecivel = ? WHERE id_produto =  ? ";
        update(update, produto.getIdproduto(), produto.getNome(), produto.getPrecoCusto(), produto.getApelido(), produto.getFornecedor(), produto.isPerecivel());
        System.out.println("Metodo atualizar DaoProduto realizado");
    }

    /*
    Metodo utilizado para deletar um produto na tabela/entidade produto,
    de acordo com codigo ou id recebido.
    */    
    public void deletar(String codigoS) throws SQLException {
        int codigo = Integer.parseInt(codigoS);
        delete("DELETE FROM produto WHERE id_produto = ? ", codigoS);
    }
    
    /*
    Metodo utilizado para pegar um produto na tabela/entidade produto,
    de acordo com id
    retornando um objeto do tipo produto.
    */
    public /*List<Object>*/ GestaoProduto getById(int id) throws SQLException {
        //ArrayList<Object> produtos = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM produto WHERE id_produto = " + id);
        ResultSet rs = stmt.executeQuery();
        //while (rs.next()) {
        GestaoFornecedor fornecedor = (GestaoFornecedor) new ControllerFornecedor().selecionaObjeto(rs.getInt("id_fornecedor"));
        GestaoProduto produto = new GestaoProduto(rs.getString("nome"), id, fornecedor, rs.getFloat("preco_custo"), rs.getString("apelido"), rs.getBoolean("perecivel"));
        //produtos.add(produto);
        //}
        rs.close();
        stmt.close();
        return produto;
    }
    
    /*
    Metodo utilizado para pegar todos os produtos na tabela/entidade produto,
    retornando um ArrayList de objetos do tipo produto.
    */
    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> produtos = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM produto");
        ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
         //       System.out.println("idFornecedor: "+rs.getInt("id_fornecedor"));
          //      System.out.println("idProduto: "+rs.getInt("id_produto"));
                GestaoFornecedor fornecedor = (GestaoFornecedor) new controller.ControllerFornecedor().selecionaObjeto(rs.getInt("id_fornecedor"));
                GestaoProduto produto = new GestaoProduto(rs.getString("nome"), rs.getInt("id_produto"), fornecedor, rs.getFloat("preco_custo"), rs.getString("apelido"), rs.getBoolean("perecivel"));
                produtos.add(produto);
            }
            
        rs.close();
        stmt.close();
        System.out.println("Metodo getAll() GestaoEstoque realizado");
        return produtos;
    }



}
