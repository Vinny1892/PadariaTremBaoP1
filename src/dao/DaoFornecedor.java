
package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.GestaoFornecedor;


public class DaoFornecedor extends GenericDao implements CRUDBasico {

    @Override
    public void salvar(Object object) throws SQLException {
       GestaoFornecedor fornecedor = (GestaoFornecedor) object;
        String insert = "INSERT INTO fornecedor (nome,cnpj,endereco,recorrente,taxa_desconto) VALUES(?,?,?,?,?) ";
        save(insert, fornecedor.getNome(),fornecedor.getCnpj(),fornecedor.getEndereco(),fornecedor.isRecorrente(),fornecedor.getTaxaDesconto());
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoFornecedor fornecedorUpdate = (GestaoFornecedor)object;
       String update = "UPDATE fornecedor SET nome = ? , endereco = ? ,cnpj = ? , recorrente = ? , taxaDesconto = ? WHERE id =  ? " ;
        update(update, fornecedorUpdate.getId(), fornecedorUpdate.getNome(),fornecedorUpdate.getEndereco(),fornecedorUpdate.getCnpj(),
                fornecedorUpdate.isRecorrente(),fornecedorUpdate.getTaxaDesconto());
       
    }

    @Override
    public void deletar(int id) throws SQLException {
        delete("DELETE FROM fornecedor WHERE id = ? ", id);
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
       return fornecedor;
        
    }

    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> fornecedores = new ArrayList<Object>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM fornecedor");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            GestaoFornecedor fornecedor = new GestaoFornecedor(rs.getLong("id"), rs.getString("nome"), rs.getString("cnpj"), rs.getString("endereco"), 
                    rs.getBoolean("recorrente"), rs.getInt("taxa"));
            fornecedores.add(fornecedor);
        }
       rs.close();
       stmt.close();
       
       return fornecedores;
    }

    public void deletar(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
}
