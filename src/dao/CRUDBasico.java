/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Enoque
 */
public interface CRUDBasico {
     public void salvar(Object object)throws SQLException ;
    public void atualizar(Object object) throws SQLException ;
    public void deletar(int id) throws SQLException ;
    public Object getById(int id) throws SQLException ;
    public List<Object> getAll()throws SQLException ;
}
