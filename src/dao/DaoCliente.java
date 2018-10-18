package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.SQLException;
import java.util.List;
import model.GestaoCliente;
import dao.DaoCliente;
import javax.swing.JOptionPane;

public class DaoCliente extends GenericDao implements CRUDBasico {

    @Override
    public void salvar(Object object) throws SQLException {
        try {
            GestaoCliente cliente = (GestaoCliente) object;
            String insert = "INSERT INTO cliente (nome,endereco,cpf,telefone) VALUES(?,?,?,?) ";
            save(insert, cliente.getNome(), cliente.getEndereco(), cliente.getCpf(), cliente.getTelefone());
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
        GestaoCliente cliente = (GestaoCliente) object;
        String update = "UPDATE cliente SET nome = ?,endereco = ?,telefone = ? WHERE cpf =  ? ";
        update(update, cliente.getCpf(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone());
        System.out.println("Metodo atualizar DaoCliente realizado");
    }

    @Override
    public void deletar(String cpf) throws SQLException {
        delete("DELETE FROM cliente WHERE cpf = ? ", cpf);
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
