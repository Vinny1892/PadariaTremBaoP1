package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.GestaoGerente;

public class DaoGerente extends GenericDao implements CRUDBasico{

    @Override
    public void salvar(Object object) throws SQLException {
        GestaoGerente gerenteSalvar = (GestaoGerente) object;
        String insert = "INSERT INTO gerente (nome,cpf,endereco,telefone,salario_base_mensal,porcentagem_gratificacao) VALUES(?,?,?,?,?,?) ";
        save(insert, gerenteSalvar.getNome(),gerenteSalvar.getCpf(),gerenteSalvar.getEndereco(),gerenteSalvar.getTelefone(),gerenteSalvar.getSalarioBaseMensal(),gerenteSalvar.getPorcentagemGratificacao());
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoGerente gerenteUpdate = (GestaoGerente)object;
        String update = "UPDATE gerente SET nome = ? , endereco = ? , telefone = ? , cpf = ? , salario_base_mensal = ? , porcentagem_gratificacao = ? WHERE id =  ? " ;
        update(update, gerenteUpdate.getNome(),gerenteUpdate.getEndereco(),gerenteUpdate.getTelefone(),gerenteUpdate.getCpf(),gerenteUpdate.getSalarioBaseMensal(), gerenteUpdate.getPorcentagemGratificacao());
    }

    @Override
    public void deletar(int id) throws SQLException {
        delete("DELETE FROM gerente WHERE id = ? ", id);
    }

    @Override
    public Object getById(int id) throws SQLException {
        GestaoGerente gerente = null;
        PreparedStatement stmt = getConnection().prepareStatement("SELECT  * FROM gerente WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            gerente = new GestaoGerente(rs.getLong("idgerente"), rs.getString("nome"), rs.getString("cpf"), rs.getString("endereco"), 
            rs.getString("telefone"), rs.getFloat("salario_base_mensal"), rs.getInt("porcentagem_gratificacao"));       
        }
        rs.close();
        stmt.close();
        return gerente;
        }

    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> gerentes = new ArrayList<Object>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM gerente");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            GestaoGerente gerente = new GestaoGerente(rs.getLong("idgerente"), rs.getString("nome"), rs.getString("cpf"), rs.getString("endereco"), 
            rs.getString("telefone"), rs.getFloat("salario_base_mensal"), rs.getInt("porcentagem_gratificacao"));  
            gerentes.add(gerente);
        }
       rs.close();
       stmt.close();
       
       return gerentes;
    }
}

    
    

