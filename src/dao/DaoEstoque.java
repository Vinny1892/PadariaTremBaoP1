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

    /*
    Metodo utilizado para salvar estoque na tabela/entidade estoque,
    de acordo com objeto GestaoEstoque recebido.
     */
    @Override
    public void salvar(Object object) throws SQLException {
        
        GestaoEstoque estoque = (GestaoEstoque) object;
        System.out.println(estoque.getProduto().getIdproduto());
        String insert = "INSERT INTO estoque (id_produto,data_validade,quantidade) VALUES(?,?,?) ";
        save(insert, estoque.getProduto().getIdproduto(), estoque.getDataValidade(), estoque.getQtdProduto());
        System.out.println("Metodo salvar DaoEstoque realizado");
    }

    /*
    Metodo utilizado para editar a tabela/entidade estoque do banco de dados
    recebe objeto GestaoEstoque a ser editado como parametro
    de acordo com idEstoque e id_estoque
     */
    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoEstoque estoque = (GestaoEstoque) object;
        String update = "UPDATE estoque SET data_validade = ? , quantidade = ? WHERE id_estoque =  ? ";
        update(update, estoque.getIdEstoque(), estoque.getDataValidade(), estoque.getQtdProduto());
        System.out.println("Metodo atualizar DaoEstoque realizado");
    }

    /*
    Metodo utilizado para deletar um estoque da tabela/entidade estoque,
    de acordo com id recebido como parametro.
     */
    @Override
    public void deletar(String idestoqueSt) throws SQLException {
        long idestoque = Long.parseLong(idestoqueSt);
        delete("DELETE FROM estoque WHERE id_estoque = ? ", idestoque);
        System.out.println("Metodo deletar DaoEstoque realizado");
    }

    //retorna array de obejto do tipo GestaoEstoque
    //pode repetir o id_estoque no banco, por isso um array
    // Objeto possui produto, data_validade e quantidade atual
    @Override
    public ArrayList<Object>/* Object */ getById(int id) throws SQLException {
        ArrayList<Object> todoEstoque = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM estoque WHERE id_estoque = " + id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            GestaoProduto produto = (GestaoProduto) new ControllerProduto().selecionaObjeto(rs.getInt("id_produto"));
            GestaoEstoque estoque = new GestaoEstoque(id, rs.getInt("quantidade"), rs.getString("data_validade"), produto);
            todoEstoque.add(estoque);
        }
        rs.close();
        stmt.close();
        System.out.println("Metodo getById() DaoEstoque realizado");
        return /*estoque*/ todoEstoque;
    }

    //retorna tudo da tabela/entidade estoque por meio de ArrayList de Objetos
    @Override
    public List<Object> getAll() throws SQLException {
        ArrayList<Object> todoEstoque = new ArrayList<>();
        //String select = "SELECT e.id_estoque,e.data_validade,e.id_produto,e.quantidade, p.perecivel from estoque e join produto p on e.id_produto = p.id_produto";
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM estoque");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("id_produto"));
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
