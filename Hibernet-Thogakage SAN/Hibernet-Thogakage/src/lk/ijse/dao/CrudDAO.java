/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asitha
 */
public interface CrudDAO<T, ID> extends SuperDAO {

    public boolean save(T entity) throws Exception;

    public boolean update(T entity) throws Exception;

    public boolean delete(T t) throws Exception;

    public T search(ID id) throws Exception;

    public List<T> getAll() throws Exception;
}
