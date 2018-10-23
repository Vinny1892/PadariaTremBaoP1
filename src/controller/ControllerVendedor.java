package controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import model.Vendedor;
import dao.DaoVendedor;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerVendedor {
    
    
    public void salvar(double montanteVenda, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco) throws SQLException{
        try{
            Vendedor vendedor = new Vendedor(montanteVenda, salarioBaseMensal, cpf, telefone, nome, endereco);
            new DaoVendedor().salvar(vendedor);
            System.out.println("Metodo salvar ControllerVendedor realizado");
        }catch(MySQLIntegrityConstraintViolationException e){
            System.out.println("cpf Ja existe");
            JOptionPane.showMessageDialog(null, "CPF ja existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir vendedor");
        } 
    }
    
    public void editar(double montanteVenda, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco) throws SQLException{
        Vendedor vendedor = new Vendedor(montanteVenda, salarioBaseMensal, cpf, telefone, nome, endereco);
        new DaoVendedor().atualizar(vendedor);
        System.out.println("Metodo editar ControllerVendedor realizado");
    }
    
    public void deletar(String cpf) throws SQLException{
        new DaoVendedor().deletar(cpf);
        System.out.println("Metodo deletar ControllerVendedor realizado");
    }
    
    public Object selecionaObjeto(int id) throws SQLException{
        Vendedor vendedor = (Vendedor) new DaoVendedor().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerVendedor realizado");
        return vendedor;
    }
    
    public ArrayList <Vendedor> getAll() throws SQLException {
        ArrayList <Vendedor> vendedores = (ArrayList<Vendedor>) (ArrayList<?>) new DaoVendedor().getAll();
        System.out.println("Metodo getAll ControllerVendedor realizado");
        return vendedores;
    }
    
    /*
    public static void main(String[] args) throws SQLException{
        ControllerVendedor cv = new ControllerVendedor();
        //cv.salvar(10000, 1000.00f, "33445566778", "12123434", "augusto vendedor", "rua do augusto");
        
        //cv.editar(9000, 1500.00f, "85555555555", "11112222", "josé feitosa", "Rua jose feitosa");
        
        //cv.deletar("55555555556");
    }*/
}
