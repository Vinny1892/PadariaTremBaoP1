package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Vendedor;

public class DaoVendedor extends GenericDao implements CRUDBasico {

    
    /*
    Metodo utilizado para salvar novos vendedores na tabela/entidade vendedor,
    com o objeto recebido como parametro.
    */
    @Override
    public void salvar(Object object) throws SQLException {
        try {
            Vendedor vendedor = (Vendedor) object;
            String insert = "INSERT INTO vendedor (montante_venda,salario_base,cpf,telefone,nome, endereco) VALUES(?,?,?,?,?,?) ";
            save(insert, vendedor.getMontanteVenda(), vendedor.getSalarioBaseMensal(), vendedor.getCpf(), vendedor.getTelefone(), vendedor.getNome(), vendedor.getEndereco());
            System.out.println("Metodo salvar DaoVendedor realizado");
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("CPF vendedor ja existe");
            JOptionPane.showMessageDialog(null, "CPF do vendedor já existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir vendedor");
        }
    }

    /*
    Metodo utilizado para editar um vendedor na tabela/entidade vendedor,
    com o objeto recebido como parametro
    de acordo com seu id.
    */
    @Override
    public void atualizar(Object object) throws SQLException {
        Vendedor vendedor = (Vendedor) object;
        String update = "UPDATE vendedor SET montante_venda = ?,salario_base = ?,telefone = ?,nome = ?, endereco = ? WHERE cpf =  ? ";
        update(update, vendedor.getCpf(), vendedor.getMontanteVenda(), vendedor.getSalarioBaseMensal(), vendedor.getTelefone(), vendedor.getNome(), vendedor.getEndereco());
        System.out.println("Metodo atualizar DaoVendedor realizado");
    }
    
    /*
    Metodo utilizado para deletar um vendedor da tabela/entidade vendedor,
    de acordo com cpf ou id.
    */
    @Override
    public void deletar(String cpf) throws SQLException {
        delete("DELETE FROM vendedor WHERE cpf = ? ", cpf);
        System.out.println("Metodo deletar DaoVendedor realizado");
    }

    /*
    Metodo utilizado para pegar um vendedor da tabela/entidade vendedor,
    de acordo com id passado como parametro,
    retornando um objeto do tipo Vendedor.
    */
    @Override
    public Object getById(int id) throws SQLException {
        Vendedor vendedor = null;
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM vendedor WHERE id_vendedor = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            vendedor = new Vendedor(rs.getDouble("montante_vendas"), id, rs.getFloat("salario_base"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("nome"), rs.getString("endereco"));
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getById() DaoVendedor realizado");
        return vendedor;
    }

    /*
    Metodo utilizado para pegar todos os vendedores da tabela/entidade vendedor,
    retornando um ArrayList de objetos do tipo vendedor.
    */
    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> vendedores = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM vendedor");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Vendedor vendedor = new Vendedor(rs.getDouble("montante_vendas"), rs.getInt("id_vendedor"), rs.getFloat("salario_base"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("nome"), rs.getString("endereco"));
            vendedores.add(vendedor);
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getAll() GestaoVendedor realizado");
        return vendedores;
    }

}
