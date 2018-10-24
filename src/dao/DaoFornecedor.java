package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.GestaoFornecedor;

public class DaoFornecedor extends GenericDao implements CRUDBasico {

    /*
    Metodo utilizado para salvar GestaoFornecedor na tabela/entidade estoque,
    de acordo com objeto GestaoFornecedor recebido.
    */
    @Override
    public void salvar(Object object) {
        try {
            GestaoFornecedor fornecedor = (GestaoFornecedor) object;
            String insert = "INSERT INTO fornecedor (nome,cnpj,endereco,recorrente,taxa_desconto) VALUES(?,?,?,?,?) ";
            save(insert, fornecedor.getNome(), fornecedor.getCnpj(), fornecedor.getEndereco(), fornecedor.isRecorrente(), fornecedor.getTaxaDesconto());
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("CNPJ Ja existe");
            JOptionPane.showMessageDialog(null, "CNPJ ja existe no Banco de Dados");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor");
        }
    }

    /*
        Metedo utilizado para modificar tabela/entidade fornecedor,
        Recebe como parametro o objeto do tipo GestaoFornecedor,
        e modifica no banco de acordo com id deste objeto.
     */
    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoFornecedor fornecedorUpdate = (GestaoFornecedor) object;
        String update = "UPDATE fornecedor SET nome = ? , endereco = ? , recorrente = ?, taxa_desconto = ?  WHERE cnpj =  ? ";
        update(update, fornecedorUpdate.getCnpj(), fornecedorUpdate.getNome(), fornecedorUpdate.getEndereco(), fornecedorUpdate.isRecorrente(), fornecedorUpdate.getTaxaDesconto());
        System.out.println("Metodo atualizar DaoFornecedor realizado");
    }

    /*
    Metodo utilizado para deletar um estoque da tabela/entidade estoque,
    de acordo com cnpj ou idFornecedor.
     */
    @Override
    public void deletar(String cnpj) throws SQLException {
        delete("DELETE FROM fornecedor WHERE cnpj = ? ", cnpj);
    }

    /*
        Metodo utiliado para pegar um fornecdor da tabela/entidade fornecedor
        de acordo com id recebido,
        e retorna este objeto Gestao fornecedor encontrado.
     */
    @Override
    public Object getById(int id) throws SQLException {
        GestaoFornecedor fornecedor = null;
        //PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM fornecedor WHERE id_fornecedor = "+id);
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM fornecedor WHERE id_fornecedor = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            fornecedor = new GestaoFornecedor(rs.getInt("id_fornecedor"), rs.getString("nome"), rs.getString("cnpj"), rs.getString("endereco"), rs.getBoolean("recorrente"), rs.getInt("taxa_desconto"));
        }
        rs.close();
        stmt.close();
        return fornecedor;
    }

    /*
        Metodo utilizado para pegar todos os fornecedores na tabela/entidade fornecedor,
        e retorna um ArrayList deste objeto GestaoFornecedor.
     */
    @Override
    public ArrayList<Object> getAll() throws SQLException {
        ArrayList<Object> fornecedores = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM fornecedor");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            GestaoFornecedor fornecedor = new GestaoFornecedor(rs.getInt("id_fornecedor"), rs.getString("nome"), rs.getString("cnpj"), rs.getString("endereco"), rs.getBoolean("recorrente"), rs.getInt("taxa_desconto"));
            fornecedores.add(fornecedor);
        }
        rs.close();
        stmt.close();
        return fornecedores;
    }

}
