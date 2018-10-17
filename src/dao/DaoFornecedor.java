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
import model.GestaoFornecedor;

public class DaoFornecedor extends GenericDao implements CRUDBasico {

    @Override
    public void salvar(Object object) {
        try{
            GestaoFornecedor fornecedor = (GestaoFornecedor) object;
            String insert = "INSERT INTO fornecedor (nome,cnpj,endereco,recorrente,taxa_desconto) VALUES(?,?,?,?,?) ";
            save(insert, fornecedor.getNome(),fornecedor.getCnpj(),fornecedor.getEndereco(),fornecedor.isRecorrente(),fornecedor.getTaxaDesconto());
        }catch(MySQLIntegrityConstraintViolationException e){
            System.out.println("CNPJ Ja existe");
            JOptionPane.showMessageDialog(null, "CNPJ ja existe no Banco de Dados");  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor");
        } 
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoFornecedor fornecedorUpdate = (GestaoFornecedor)object;
        String update = "UPDATE fornecedor SET nome = ? , endereco = ? ,cnpj = ? , taxa_desconto = ? , recorrente = ? WHERE idfornecedor =  ? " ;
        update(update, fornecedorUpdate.getId(), fornecedorUpdate.getNome(),fornecedorUpdate.getEndereco(),fornecedorUpdate.getCnpj(),fornecedorUpdate.isRecorrente(),fornecedorUpdate.getTaxaDesconto());
        System.out.println("Metodo atualizar DaoFornecedor realizado");
    }

    @Override
    public void deletar(String nome) throws SQLException {
        delete("DELETE FROM fornecedor WHERE nome = ? ", nome);
    }
    
    @Override
    public Object getById(int id) throws SQLException {
        GestaoFornecedor fornecedor = null;
        PreparedStatement stmt = getConnection().prepareStatement("SELECT  * FROM fornecedor WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            fornecedor = new GestaoFornecedor(rs.getLong("id"), rs.getString("nome"), rs.getString("cnpj"), rs.getString("endereco"), 
                    rs.getBoolean("recorrente"), rs.getInt("taxa"));       
        }
       rs.close();
       stmt.close();
        System.out.println("Metodo getById() realizado");
       return fornecedor; 
    }

    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> fornecedores = new ArrayList<Object>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM fornecedor");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            GestaoFornecedor fornecedor = new GestaoFornecedor(rs.getLong("idfornecedor"), rs.getString("nome"), rs.getString("cnpj"), rs.getString("endereco"), 
                    rs.getBoolean("recorrente"), rs.getInt("taxa_desconto"));
            fornecedores.add(fornecedor);
        }
       rs.close();
       stmt.close();
        System.out.println("Metodo getAll() realizado");
        
   
       return fornecedores;
    }
    
      
    
}