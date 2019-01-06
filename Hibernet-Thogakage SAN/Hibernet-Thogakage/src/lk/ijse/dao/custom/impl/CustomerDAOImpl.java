package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.entity.Customer;
import lk.ijse.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    private SessionFactory sessionFactory;
    public CustomerDAOImpl() {
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean save(Customer entity) throws Exception {
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Customer customer) throws Exception {
        return false;
    }

    @Override
    public Customer search(Integer integer) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        return null;
    }
}
