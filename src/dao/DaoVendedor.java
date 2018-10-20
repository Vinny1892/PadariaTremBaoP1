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

    @Override
    public void atualizar(Object object) throws SQLException {
        Vendedor vendedor = (Vendedor) object;
        String update = "UPDATE vendedor SET montante_venda = ?,salario_base = ?,telefone = ?,nome = ?, endereco = ? WHERE cpf =  ? ";
        update(update, vendedor.getCpf(), vendedor.getMontanteVenda(), vendedor.getSalarioBaseMensal(), vendedor.getTelefone(), vendedor.getNome(), vendedor.getEndereco());
        System.out.println("Metodo atualizar DaoVendedor realizado");
    }

    @Override
    public void deletar(String cpf) throws SQLException {
        delete("DELETE FROM vendedor WHERE cpf = ? ", cpf);
        System.out.println("Metodo deletar DaoVendedor realizado");
    }

    @Override
    public Object getById(int id) throws SQLException {
        ArrayList<Object> vendedores = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM vendedor WHERE id_vendedor = " + id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Vendedor vendedor = new Vendedor(rs.getDouble("montante_vendas"), id, rs.getFloat("salario_base"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("nome"), rs.getString("endereco"));
            vendedores.add(vendedor);
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getById() DaoVendedor realizado");
        return vendedores;
    }

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
