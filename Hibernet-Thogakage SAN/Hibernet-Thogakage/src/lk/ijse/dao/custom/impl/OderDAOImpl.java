package lk.ijse.dao.custom.impl;

import com.sun.xml.internal.ws.handler.HandlerException;
import lk.ijse.dao.custom.OderDAO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.OrderDetail;
import lk.ijse.entity.Orders;
import lk.ijse.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class OderDAOImpl implements OderDAO {
    private SessionFactory sessionFactory;
    public OderDAOImpl() {
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean save(Orders entity) throws Exception {
     return false;
    }

    @Override
    public boolean update(Orders entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Orders orders) throws Exception {
        return false;
    }

    @Override
    public Orders search(Integer integer) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Orders> getAll() throws Exception {
        return null;
    }
}
