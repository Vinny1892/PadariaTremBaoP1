package dao;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GestaoEstoque;

public class DaoEstoque extends GenericDao implements CRUDBasico {

    @Override
    public void salvar(Object object) throws SQLException {
        try {
            GestaoEstoque estoque = (GestaoEstoque) object;
            String insert = "INSERT INTO estoque (produto_idproduto,data_validade,quantidade) VALUES(?,?,?) ";
            save(insert, estoque.getProduto(), estoque.getQtdProduto(), estoque.getDataValidade());
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("CPF Ja existe");
            JOptionPane.showMessageDialog(null, "CPF ja existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor");
        }
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoEstoque estoque = (GestaoEstoque) object;
        String update = "UPDATE estoque SET data_validade = ? , quantidade = ? WHERE idestoque =  ? ";
        update(update, estoque.getIdEstoque(), estoque.getDataValidade(), estoque.getQtdProduto());
    }

    @Override
    public void deletar(String idestoqueSt) throws SQLException {
        long idestoque = Long.parseLong(idestoqueSt);
        delete("DELETE FROM estoque WHERE idestoque = ? ", idestoque);
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
