package dao;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import controller.ControllerProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GestaoEstoque;
import model.GestaoProduto;

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
        System.out.println("Metodo salvar DaoEstoque realizado");
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoEstoque estoque = (GestaoEstoque) object;
        String update = "UPDATE estoque SET data_validade = ? , quantidade = ? WHERE idestoque =  ? ";
        update(update, estoque.getIdEstoque(), estoque.getDataValidade(), estoque.getQtdProduto());
        System.out.println("Metodo atualizar DaoEstoque realizado");
    }

    @Override
    public void deletar(String idestoqueSt) throws SQLException {
        long idestoque = Long.parseLong(idestoqueSt);
        delete("DELETE FROM estoque WHERE idestoque = ? ", idestoque);
        System.out.println("Metodo deletar DaoEstoque realizado");
    }

    @Override
    public List<Object> getById(int id) throws SQLException {
        ArrayList<Object> todoEstoque = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM estoque WHERE id_estoque = " + id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ControllerProduto cp = null;
            GestaoProduto produto = (GestaoProduto) cp.selecionaObjeto(id);
            GestaoEstoque estoque = new GestaoEstoque(id, rs.getInt("quantidade"), rs.getString("data_validade"), produto);
            todoEstoque.add(estoque);
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getById() DaoEstoque realizado");
        return todoEstoque;
    }

    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> todoEstoque = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM estoque");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ControllerProduto cf = null;
            GestaoProduto produto = (GestaoProduto) cf.selecionaObjeto(rs.getInt("id_produto"));
            GestaoEstoque estoque = new GestaoEstoque(rs.getInt("id_estoque"), rs.getInt("quantidade"), rs.getString("data_validade"), produto);
            todoEstoque.add(estoque);
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getAll() GestaoEstoque realizado");
        return todoEstoque;
    }

}
