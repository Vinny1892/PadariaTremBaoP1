package dao;

import controller.ControllerProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.GestaoEstoque;
import model.GestaoProduto;

public class DaoEstoque extends GenericDao implements CRUDBasico {

    @Override
    public void salvar(Object object) throws SQLException {
        GestaoEstoque estoque = (GestaoEstoque) object;
        String insert = "INSERT INTO estoque (id_produto,data_validade,quantidade) VALUES(?,?,?) ";
        save(insert, estoque.getProduto(), estoque.getQtdProduto(), estoque.getDataValidade());
        System.out.println("Metodo salvar DaoEstoque realizado");
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoEstoque estoque = (GestaoEstoque) object;
        String update = "UPDATE estoque SET data_validade = ? , quantidade = ? WHERE id_estoque =  ? ";
        update(update, estoque.getIdEstoque(), estoque.getDataValidade(), estoque.getQtdProduto());
        System.out.println("Metodo atualizar DaoEstoque realizado");
    }

    @Override
    public void deletar(String idestoqueSt) throws SQLException {
        long idestoque = Long.parseLong(idestoqueSt);
        delete("DELETE FROM estoque WHERE id_estoque = ? ", idestoque);
        System.out.println("Metodo deletar DaoEstoque realizado");
    }

    //retorna o obejto do tipo estoque
    // Objeto possui produto, data_validade e quantidade atual
    @Override
    public /*ArrayList<Object>*/ Object getById(int id) throws SQLException {
        //ArrayList<Object> todoEstoque = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM estoque WHERE id_estoque = " + id);
        ResultSet rs = stmt.executeQuery();
        //while (rs.next()) {
            GestaoProduto produto = (GestaoProduto) new ControllerProduto().selecionaObjeto(rs.getInt("id_produto"));
            GestaoEstoque estoque = new GestaoEstoque(id, rs.getInt("quantidade"), rs.getString("data_validade"), produto);
        //    todoEstoque.add(estoque);
        //}
        rs.close();
        stmt.close();
        System.out.println("Metodo getById() DaoEstoque realizado");
        return estoque/*todoEstoque*/;
    }

    // retorna um objeto do Estoque
    //Por usar o parametro id_estoque e id_venda, sera encontrado somente um objeto de retorno, e nao um vetor
    //Pois cada id_estoque esta relacionado com unico id_produto
    //e se o cliente comprar mais de uma vez o mesmo produto, só muda a quantidade deste em estoque
    public Object getById(int idEstoque, int idVenda) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM estoque WHERE id_estoque = " + idEstoque + " AND id_venda = " + idVenda);
        ResultSet rs = stmt.executeQuery();
        GestaoProduto produto = (GestaoProduto) new ControllerProduto().selecionaObjeto(rs.getInt("id_produto"));
        GestaoEstoque estoque = new GestaoEstoque(idEstoque, rs.getInt("quantidade"), rs.getString("data_validade"), produto);
        rs.close();
        stmt.close();
        System.out.println("Metodo getById() DaoEstoque realizado");
        return estoque;
    }

    //retorna tudo da tabela estoque por meio de ArrayList de Objetos
    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> todoEstoque = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM estoque");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            GestaoProduto produto = (GestaoProduto) new ControllerProduto().selecionaObjeto(rs.getInt("id_produto"));
            GestaoEstoque estoque = new GestaoEstoque(rs.getInt("id_estoque"), rs.getInt("quantidade"), rs.getString("data_validade"), produto);
            todoEstoque.add(estoque);
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getAll() GestaoEstoque realizado");
        return todoEstoque;
    }

}
