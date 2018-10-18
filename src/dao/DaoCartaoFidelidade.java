package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.CartaoFidelidade;

public class DaoCartaoFidelidade extends GenericDao implements CRUDBasico {

    @Override
    public void salvar(Object object) throws SQLException {
        try {
            CartaoFidelidade cartaoFidelidade = (CartaoFidelidade) object;
            String insert = "INSERT INTO cartao_fidelidade (gold, platinum) VALUES(?,?,?,?) ";
            save(insert, cartaoFidelidade.isGold(), cartaoFidelidade.isPlatinum());
            System.out.println("Metodo salvar DaoCliente realizado");
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("CPF Ja existe");
            JOptionPane.showMessageDialog(null, "CPF ja existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor");
        }
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String nome) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
