package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CartaoFidelidade;

public class DaoCartaoFidelidade extends GenericDao implements CRUDBasico {

    /*
        Metodo utilizado para salvar novo cartao na tabela/entidade cartao_fidelidade,
    com o objeto passado como parametro.
     */
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

    /*
        Metedo utilizado para modificar cartao fidelidade no banco de dados
        Recebe como parametro o objeto do tipo CartaoFidelidade
        e modifica no banco de acordo com id deste objeto
     */
    @Override
    public void atualizar(Object object) throws SQLException {
        CartaoFidelidade cartao = (CartaoFidelidade) object;
        String update = "UPDATE cartao_fidelidade SET gold = ?,platinum = ? WHERE id_cartao =  ? ";
        update(update, cartao.getIdcartaoFidelidade(), cartao.isGold(), cartao.isPlatinum());
        System.out.println("Metodo atualizar DaoCartaoFidelidade realizado");
    }

    /*
        Metodo utilizado para deletar um cartao de acordo com id
     */
    @Override
    public void deletar(String idString) throws SQLException {
        int id = Integer.parseInt(idString);
        delete("DELETE FROM cartao_fidelidade WHERE id_cartao = ? ", id);
        System.out.println("Metodo deletar DaoCartaoFidelidade realizado");
    }

    /*
        Metodo utilizado para encontrar um cartao no banco apatir do id
        retornando este objeto, do tipo CartaoFidelidade
     */
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

    /*
        Metodo utilizado para preencher um ArrayList do tipo objeto CartaoCliente, e retorna o mesmo
        retorna todos os cartoes encontrado na entidade/tabela cartao_cliente 
     */
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
