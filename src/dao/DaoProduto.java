package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.GestaoProduto;

/**
 * na entidade PRODUTO, podemos declarar produtos mas nao sua data de validade e
 * a quantidade, a entidade produto funciona mais como um catalogo produtos
 */
public class DaoProduto extends GenericDao implements CRUDBasico {

    @Override
    public void salvar(Object object) throws SQLException {
        try {
            GestaoProduto produto = (GestaoProduto) object;
            String insert = "INSERT INTO produto (nome,preco_custo,perecivel,data_validade,apelido) VALUES(?,?,?,?,?) ";
            save(insert, produto.getNome(), produto.getPrecoCusto(), produto.isPerecivel(), produto.getDataValidade(), produto.getApelido());
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("Código já existe");
            JOptionPane.showMessageDialog(null, "Código ja existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto");
        }
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoProduto produto = (GestaoProduto) object;
        String update = "UPDATE produto SET nome = ?,preco_custo = ?,perecivel = ?,data_validade = ? WHERE codigo =  ? ";
        update(update, produto.getCodigo(), produto.getNome(), produto.getPrecoCusto(), produto.isPerecivel(), produto.getDataValidade());
        System.out.println("Metodo atualizar DaoProduto realizado");
    }

    public void deletar(String codigoS) throws SQLException {
        int codigo = Integer.parseInt(codigoS);
        delete("DELETE FROM produto WHERE codigo = ? ", codigo);
    }

    @Override
    public Object getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
