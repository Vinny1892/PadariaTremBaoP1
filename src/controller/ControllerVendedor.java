package controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import model.Vendedor;
import dao.DaoVendedor;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerVendedor {

    /*
    Metodo utilizado para calcular a gratificacao do vendedor,
    rebecendo como parametro o metaVenda e o objeto vendedor,
    retornando o valor da gratificacao
    */
    public float gratificacao(float metaVenda, Vendedor vendedor) {
        float gratificao = 0f;
        if (metaVenda <= vendedor.getMontanteVenda()) {
            gratificao = vendedor.getSalarioBaseMensal() * 0.10f;
        }
        return gratificao;
    }

    /*
    Metodo usado para chamar o metodo salvar() da classe DaoVendedor,
    passando como parametro o objeto Vendedor a ser salvo.
     */
    public void salvar(double montanteVenda, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco) throws SQLException {
        try {
            Vendedor vendedor = new Vendedor(montanteVenda, salarioBaseMensal, cpf, telefone, nome, endereco);
            new DaoVendedor().salvar(vendedor);
            System.out.println("Metodo salvar ControllerVendedor realizado");
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("cpf Ja existe");
            JOptionPane.showMessageDialog(null, "CPF ja existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir vendedor");
        }
    }

    /*
    Metodo utilizado para chamar o metodo atualizar() da classe DaoVendedor,
    passando como parametro o objeto Vendedor a ser editado,
    de acordo com idVendedor deste objeto.
     */
    public void editar(double montanteVenda, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco) throws SQLException {
        Vendedor vendedor = new Vendedor(montanteVenda, salarioBaseMensal, cpf, telefone, nome, endereco);
        new DaoVendedor().atualizar(vendedor);
        System.out.println("Metodo editar ControllerVendedor realizado");
    }

    /*
    Metodo utilizado para chamar o metodo deletar() da classe DaoVendedor,
    passando como parametro o idVendedor, para saber qual vendedor sera deletado.
     */
    public void deletar(String cpf) throws SQLException {
        new DaoVendedor().deletar(cpf);
        System.out.println("Metodo deletar ControllerVendedor realizado");
    }

    /*
    Metodo utilizado para chamar o metodo getById() da classe DaoVendedor,
    passando como parametro o idVendedor a pegar,
    retornando o objeto Vendedor encontrado.
     */
    public Object selecionaObjeto(int id) throws SQLException {
        Vendedor vendedor = (Vendedor) new DaoVendedor().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerVendedor realizado");
        return vendedor;
    }

    /*
    Metodo utilizado para chamar o metodo getAll() da classe DaoVendedor,
    retornando um ArrayList de objetos do tipo Vendedor.
     */
    public ArrayList<Vendedor> getAll() throws SQLException {
        ArrayList<Vendedor> vendedores = (ArrayList<Vendedor>) (ArrayList<?>) new DaoVendedor().getAll();
        System.out.println("Metodo getAll ControllerVendedor realizado");
        return vendedores;
    }

}
