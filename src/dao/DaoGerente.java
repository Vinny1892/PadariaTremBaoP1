package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GestaoGerente;

public class DaoGerente extends GenericDao implements CRUDBasico {

    /*
        Metodo utilizado para salvar gerente na tabela/entidade gerente,
        de acordo com objeto GestaoGerente recebido,
        se cpf nao for repetido.
     */
    @Override
    public void salvar(Object object) throws SQLException {
        try {
            GestaoGerente gerenteSalvar = (GestaoGerente) object;
            String insert = "INSERT INTO gerente (nome,cpf,endereco,telefone,salario_base_mensal,porcentagem_gratificacao) VALUES(?,?,?,?,?,?) ";
            save(insert, gerenteSalvar.getNome(), gerenteSalvar.getCpf(), gerenteSalvar.getEndereco(), gerenteSalvar.getTelefone(), gerenteSalvar.getSalarioBaseMensal(), gerenteSalvar.getPorcentagemGratificacao());
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("CPF Ja existe");
            JOptionPane.showMessageDialog(null, "CPF ja existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor");
        }
    }

    /*
    Metodo utilizado para editar um gerente na tabela/entidade gerente, 
    com o objeto recebido,
    de acordo com id deste objeto,
     */
    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoGerente gerenteUpdate = (GestaoGerente) object;
        String update = "UPDATE gerente SET nome = ? , endereco = ? , telefone = ? ,  salario_base_mensal = ? , porcentagem_gratificacao = ? WHERE cpf =  ? ";
        update(update, gerenteUpdate.getCpf(), gerenteUpdate.getNome(), gerenteUpdate.getEndereco(), gerenteUpdate.getTelefone(), gerenteUpdate.getSalarioBaseMensal(), gerenteUpdate.getPorcentagemGratificacao());
    }

    /*
    Metodo utilizado para deletar um gerente na tabela/entidade gerente,
    de acordo com cpf ou id.
     */
    @Override
    public void deletar(String id) throws SQLException {
        delete("DELETE FROM gerente WHERE id_gerente = ? ", id);
    }

    /*
    Metodo utilizado para pegar um gerente da tabela/entidade gerente
    de cordo com id
    retornando este objeto GesgtaoGerente encontrado.
     */
    @Override
    public Object getById(int id) throws SQLException {
        GestaoGerente gerente = null;
        PreparedStatement stmt = getConnection().prepareStatement("SELECT  * FROM gerente WHERE idgerente = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            gerente = new GestaoGerente(rs.getInt("idgerente"), rs.getString("nome"), rs.getString("cpf"), rs.getString("endereco"), rs.getString("telefone"), rs.getFloat("salario_base_mensal"), rs.getInt("porcentagem_gratificacao"));
        }
        rs.close();
        stmt.close();
        return gerente;
    }

    /*
    Metodo utilizado para pegar todos os gerentes da tabela/entidade gerente,
    retornando um ArrayList de objeto do tipo GestaoGerentes.
     */
    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> gerentes = new ArrayList<Object>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM gerente");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            GestaoGerente gerente = new GestaoGerente(rs.getInt("idgerente"), rs.getString("nome"), rs.getString("cpf"), rs.getString("endereco"),
                    rs.getString("telefone"), rs.getFloat("salario_base_mensal"), rs.getInt("porcentagem_gratificacao"));
            gerentes.add(gerente);
        }
        rs.close();
        stmt.close();

        return gerentes;
    }
}
