package dao;

import java.sql.SQLException;
import java.util.List;
import controller.ControllerVendedor;

public class DaoVendedor {
    public void salvar(ControllerVendedor vendedor) throws SQLException {
        String insert = "INSERT INTO CADASTROS "
        + " (nome, cpf, email) VALUES(?,?,?)";
        save(insert, cadastro.getNome(), cadastro.getCpf(), cadastro.getEmail());
    }
    

    public List<Cadastro> findCadastros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluir(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void findByName(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void alterar(Cadastro cadastro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
