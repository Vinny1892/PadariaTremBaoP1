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

    /*
    Metodo utiliado para salvar padeiro na tabela/entidade padeiro,
    o objeto GestaoPadeiro recebido como parametro,
    se cpf nao for repetido.
     */
    @Override
    public void salvar(Object object) throws SQLException {
        try {
            Padeiro padeiro = (Padeiro) object;
            String insert = "INSERT INTO padeiro (horario_alternativo,salario_base,cpf,telefone,nome, endereco) VALUES(?,?,?,?,?,?) ";
            save(insert, padeiro.getHorasTrabalhadaNoturno(), padeiro.getSalarioBaseMensal(), padeiro.getCpf(), padeiro.getTelefone(), padeiro.getNome(), padeiro.getEndereco());
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("CPF padeiro ja existe");
            JOptionPane.showMessageDialog(null, "CPF padeiro já existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir padeiro");
        }
    }

    /*
    Metodo utilizado para editar objeto da tabela/entidade padeiro,
    com objeto recebido
    de acordo com id este objeto recebido
     */
    @Override
    public void atualizar(Object object) throws SQLException {
        Padeiro padeiro = (Padeiro) object;
        String update = "UPDATE padeiro SET nome = ?, endereco = ? , telefone = ? ,  salario_base = ? , horario_alternativo = ? WHERE cpf =  ? ";
        update(update, padeiro.getCpf(), padeiro.getNome(), padeiro.getEndereco(), padeiro.getTelefone(), padeiro.getSalarioBaseMensal(), padeiro.getHorasTrabalhadaNoturno());
    }

    /*
    Metodo utilizado para deletar padeiro da tabela/entidade padeiro,
    o objeto GestaoPadeiro de acordo com cpf ou id recebido
     */
    @Override
    public void deletar(String cpf) throws SQLException {
        delete("DELETE FROM padeiro WHERE cpf = ? ", cpf);
    }

    /*
    Metodo utilizado para pega um padeiro da tabela/entidade padeiro,
    de acordo com id,
    e retorna o objeto do tipo padeiro encontrado.
     */
    @Override
    public Object getById(int id) throws SQLException {
        Padeiro padeiro = null;
        PreparedStatement stmt = getConnection().prepareStatement("SELECT  * FROM padeiro WHERE id_padeiro = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            padeiro = new Padeiro(rs.getString("nome"), rs.getString("endereco"), rs.getString("cpf"), rs.getString("telefone"), rs.getFloat("salario_base"), rs.getFloat("horario_alternativo"));
        }
        rs.close();
        stmt.close();
        return padeiro;
    }

    /*
    Metodo utilizado para pegar todos os padeiros da tabela/entidade padeiro,
    retornando um ArrayList de objeto do tipo padeiro.
     */
    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> padeiros = new ArrayList<Object>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM padeiro");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Padeiro padeiro = new Padeiro(rs.getString("nome"), rs.getString("endereco"), rs.getString("cpf"), rs.getString("telefone"), rs.getFloat("salario_base"), rs.getFloat("horario_alternativo"));
            padeiros.add(padeiro);
        }
        rs.close();
        stmt.close();

        return padeiros;
    }

}
