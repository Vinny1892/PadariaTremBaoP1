package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.CartaoFidelidade;
import model.GestaoCliente;

public class DaoCartaoFidelidade extends GenericDao implements CRUDBasico {

    @Override
    public void salvar(Object object) throws SQLException {
        //try {
            CartaoFidelidade cartaoFidelidade = (CartaoFidelidade) object;
            String insert = "INSERT INTO cartao_fidelidade (gold, platinum) VALUES(?,?,?,?) ";
            save(insert, cartaoFidelidade.isGold(), cartaoFidelidade.isPlatinum());
            System.out.println("Metodo salvar DaoCartaoFidelidade realizado");
        /*} catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("CPF Ja existe");
            JOptionPane.showMessageDialog(null, "CPF ja existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Cartão de fidelidade");
        }*/
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        CartaoFidelidade cartao = (CartaoFidelidade) object;
        String update = "UPDATE cartao_fidelidade SET gold = ?,platinum = ? WHERE id_cartao =  ? ";
        update(update, cartao.getIdcartaoFidelidade(), cartao.isGold(), cartao.isPlatinum());
        System.out.println("Metodo atualizar DaoCartaoFidelidade realizado");
    }

    @Override
    public void deletar(String idString) throws SQLException {
        int id = Integer.parseInt(idString);
        delete("DELETE FROM cartao_fidelidade WHERE id_cartao = ? ", id);
        System.out.println("Metodo deletar DaoCartaoFidelidade realizado");
    }

    
 // TALVEZ N PRECISE DE WHILE
    @Override
    public Object getById(int id) throws SQLException {
        CartaoFidelidade cartao = null;
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM cartao_fidelidade WHERE id_cartao = " + id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            cartao = new CartaoFidelidade(id, rs.getBoolean("gold"), rs.getBoolean("platinum")/*, cliente*/);
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getById() DaoCartaoFidelidade realizado");
        return cartao;
    }

    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> Cartoes = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM cartao_fidelidade");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            CartaoFidelidade cartao = new CartaoFidelidade(rs.getInt("id_cartao"), rs.getBoolean("gold"), rs.getBoolean("platinum"));
            Cartoes.add(cartao);
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getAll() DaoCartaoFidelidade realizado");
        return Cartoes;
    }

}
