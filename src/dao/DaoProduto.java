package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import controller.ControllerFornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.GestaoProduto;
import model.GestaoFornecedor;


/**
 * na entidade PRODUTO, podemos declarar produtos mas nao sua data de validade e
 * a quantidade, a entidade produto funciona mais como um catalogo produtos
 */
public class DaoProduto extends GenericDao implements CRUDBasico {

    @Override
    public void salvar(Object object) throws SQLException {
        try {
            GestaoProduto produto = (GestaoProduto) object;
            String insert = "INSERT INTO produto (nome, preco_custo, apelido, id_fornecedor) VALUES(?,?,?,?) ";
            save(insert, produto.getNome(), produto.getPrecoCusto(), produto.getApelido(), produto.getFornecedor().getIdfornecedor());
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("codigo do produto ja existe");
            JOptionPane.showMessageDialog(null, "Código do produto já existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor");
        }
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoProduto produto = (GestaoProduto) object;
        String update = "UPDATE produto SET nome = ?,preco_custo = ?, apelido = ?,id_fornecedo = ? WHERE id_produto =  ? ";
        update(update, produto.getCodigo(), produto.getNome(), produto.getPrecoCusto(), produto.getApelido(), produto.getFornecedor());
        System.out.println("Metodo atualizar DaoProduto realizado");
    }

    public void deletar(String codigoS) throws SQLException {
        int codigo = Integer.parseInt(codigoS);
        delete("DELETE FROM produto WHERE id_produto = ? ", codigo);
    }

    @Override
    public Object getById(int id) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM produto WHERE id_produto = " + id);
        ResultSet rs = stmt.executeQuery();
        ControllerFornecedor cf = null;
        GestaoFornecedor fornecedor = (GestaoFornecedor) cf.selecionaObjeto(rs.getInt("id_fornecedor"));
        GestaoProduto produto = new GestaoProduto(rs.getString("nome"), id,  fornecedor, rs.getFloat("preco_custo"),rs.getString("apelido"));
        rs.close();
        stmt.close();
        return produto;
    }
    

    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> produtos = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM produto");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ControllerFornecedor cf = null;
            GestaoFornecedor fornecedor = (GestaoFornecedor) cf.selecionaObjeto(rs.getInt("id_fornecedor"));
            GestaoProduto produto = new GestaoProduto(rs.getString("nome"), rs.getInt("id_produto"), fornecedor, rs.getFloat("preco_custo"), rs.getString("apelido"));
            produtos.add(produto);
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getAll() GestaoEstoque realizado");
        return produtos;
    }

}
