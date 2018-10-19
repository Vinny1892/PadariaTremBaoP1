package dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import controller.ControllerVendedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GestaoVenda;
import model.GestaoEstoque;
import model.Vendedor;
import model.GestaoCliente;

public class DaoVenda extends GenericDao implements CRUDBasico{

    @Override
    public void salvar(Object object) throws SQLException {
        try {
            GestaoVenda venda = (GestaoVenda) object;
            String insert = "INSERT INTO venda (data_venda, forma_pagamento, id_cliente, id_vendedor) VALUES(?,?,?,?) ";
            save(insert, venda.getDataVenda(), venda.getFormaPagamento(), venda.getCliente().getIdCliente(), venda.getVendedor().getIdVendedor());
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("codigo do produto ja existe");
            JOptionPane.showMessageDialog(null, "Código do produto já existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor");
        }

    }

    @Override
    public void atualizar(Object object) throws SQLException {
        GestaoVenda venda = (GestaoVenda) object;
        String update = "UPDATE produto SET data_venda = ?,forma_pagamento = ?, id_cliente = ?,id_vendedor = ? WHERE id_venda =  ? ";
        update(update, venda.getIdVendas(),venda.getDataVenda(), venda.getFormaPagamento(), venda.getCliente().getIdCliente(), venda.getVendedor().getIdVendedor());
        System.out.println("Metodo atualizar DaoVenda realizado");
    }

    @Override
    public void deletar(String idVendaSt) throws SQLException {
        int idVenda = Integer.parseInt(idVendaSt);
        delete("DELETE FROM produto WHERE id_venda = ? ", idVenda);
    }

    @Override
    public Object getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> getAll() throws SQLException {
        ArrayList<Object> vendas = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM venda");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            GestaoVenda venda;
            ControllerVendedor crl;
            Vendedor vendedor;
            vendedor = crl.buscaTudoVendedor(vendedor);
            GestaoCliente cliente = null;
            //venda = new GestaoVenda(rs.getString("data_venda"), rs.getInt("f"), rs.getInt("id_cliente"), rs.getInt("forma_pagamento"), rs.getInt("id_venda"));
            venda = new GestaoVenda(rs.getString("data_venda"),   vendedor,     cliente, rs.getInt("forma_pagamento"), rs.getInt("id_venda"));
            vendas.add(venda);
        }
        rs.close();
        stmt.close();
        return vendas;
    }

    
    
}
