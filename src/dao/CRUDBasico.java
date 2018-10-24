package dao;

import java.sql.SQLException;
import java.util.List;

public interface CRUDBasico {

    public void salvar(Object object) throws SQLException;

    public void atualizar(Object object) throws SQLException;

    public void deletar(String algumaCoisa) throws SQLException;

    public Object getById(int id) throws SQLException;//retorna ArrayList<Object>  

    //public Object getAllById(int id) throws SQLException;//retorna Object
    //public Object getById(int id, int id) throws SQLException ;
    public List<Object> getAll() throws SQLException;// pega tudo de uma tabela
}
