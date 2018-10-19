package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.SQLException;
import java.util.List;
import controller.ControllerVendedor;
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
            System.out.println("codigo do produto ja existe");
            JOptionPane.showMessageDialog(null, "Código do produto já existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor");
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
    }

    @Override
    public Object getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> fornecedores = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM fornecedor");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Vendedor vendedor = new Vendedor(rs.getInt("idfornecedor"), rs.getString("nome"), rs.getString("cnpj"), rs.getString("endereco"),
                    rs.getBoolean("recorrente"), rs.getInt("taxa_desconto"));
            ;
            fornecedores.add(fornecedor);
        }
        rs.close();
        stmt.close();
        return fornecedores;
    }

}
