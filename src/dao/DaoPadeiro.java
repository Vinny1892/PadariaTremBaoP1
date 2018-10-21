package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Padeiro;

public class DaoPadeiro extends GenericDao implements CRUDBasico {

    @Override
    public void salvar(Object object) throws SQLException {
        try {
            Padeiro padeiro = (Padeiro) object;
            String insert = "INSERT INTO padeiro (horario_alternativo,salario_base,cpf,telefone,nome, endereco) VALUES(?,?,?,?,?,?) ";
            save(insert, padeiro.getHorasTrabalhadaNoturno(), padeiro.getSalarioBaseMensal(), padeiro.getCpf(), padeiro.getTelefone(), padeiro.getNome(), padeiro.getEndereco());
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("codigo do produto ja existe");
            JOptionPane.showMessageDialog(null, "Código do produto já existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir padeiro");
        }
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        Padeiro padeiro = (Padeiro) object;
        String update = "UPDATE padeiro SET nome = ?, endereco = ? , telefone = ? ,  salario_base = ? , horario_alternativo = ? WHERE cpf =  ? ";
        update(update, padeiro.getCpf(), padeiro.getNome(), padeiro.getEndereco(), padeiro.getTelefone(), padeiro.getSalarioBaseMensal(), padeiro.getHorasTrabalhadaNoturno());
    }

    @Override
    public void deletar(String cpf) throws SQLException {
        delete("DELETE FROM padeiro WHERE cpf = ? ", cpf);
    }

    @Override
    public Object getById(int id) throws SQLException {
        Padeiro padeiro = null;
        PreparedStatement stmt = getConnection().prepareStatement("SELECT  * FROM padeiro WHERE id_padeiro = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            padeiro = new Padeiro(rs.getString("nome"), rs.getString("endereco"), rs.getString("cpf"), rs.getString("telefone"), rs.getFloat("salario_base_mensal"), rs.getFloat("horarioalternativo"));
        }
        rs.close();
        stmt.close();
        return padeiro;
    }

    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> padeiros = new ArrayList<Object>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM padeiro");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Padeiro padeiro = new Padeiro(rs.getString("nome"), rs.getString("endereco"), rs.getString("cpf"), rs.getString("telefone"), rs.getFloat("salario_base_mensal"), rs.getFloat("horarioalternativo"));
            padeiros.add(padeiro);
        }
        rs.close();
        stmt.close();

        return padeiros;
    }

}
