package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Padeiro;

public class DaoPadeiro extends GenericDao implements CRUDBasico{

    @Override
    public void salvar(Object object) throws SQLException {
        Padeiro padeiro = (Padeiro) object;
        String insert = "INSERT INTO padeiro (horarioalternativo,salario_base_mensal,cpf,telefone,nome, endereco) VALUES(?,?,?,?,?,?) ";
        save(insert, padeiro.getHorasTrabalhadaNoturno(),padeiro.getSalarioBaseMensal(),padeiro.getCpf(), padeiro.getTelefone(), padeiro.getNome(), padeiro.getEndereco());
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        Padeiro padeiro = (Padeiro) object;
        String update = "UPDATE padeiro SET nome = ? , cpf = ?, endereco = ? , telefone = ? ,  salario_base_mensal = ? , horarioalternativo = ? WHERE idpadeiro =  ? " ;
        update(update, padeiro.getId(), padeiro.getNome(),padeiro.getCpf(),padeiro.getEndereco(), padeiro.getTelefone(), padeiro.getSalarioBaseMensal(), padeiro.getHorasTrabalhadaNoturno());
    }

    @Override
    public void deletar(String nome) throws SQLException {
        delete("DELETE FROM padeiro WHERE nome = ? ", nome);
    }

    @Override
    public Object getById(int id) throws SQLException {
        Padeiro padeiro = null;
        PreparedStatement stmt = getConnection().prepareStatement("SELECT  * FROM gerente WHERE idgerente = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            padeiro = new Padeiro(rs.getLong("idpadeiro"), rs.getString("nome"), rs.getString("endereco"), rs.getString("cpf"), rs.getString("telefone"), rs.getFloat("salario_base_mensal"), rs.getFloat("horarioalternativo"));       
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
        while(rs.next()){
            Padeiro padeiro = new Padeiro(rs.getLong("idpadeiro"), rs.getString("nome"), rs.getString("endereco"), rs.getString("cpf"), rs.getString("telefone"), rs.getFloat("salario_base_mensal"), rs.getFloat("horarioalternativo"));  
            padeiros.add(padeiro);
        }
       rs.close();
       stmt.close();
       
       return padeiros; 
    }
    
}
