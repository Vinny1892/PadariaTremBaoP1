
package dao;

import java.sql.SQLException;
import java.util.List;

public interface CRUDBasico {
    public void salvar(Object object)throws SQLException ;
    public void atualizar(Object object) throws SQLException ;
    public void deletar(int id) throws SQLException ;
    public Object getById(int id) throws SQLException ;
    public List<Object> getAll()throws SQLException ;
}
