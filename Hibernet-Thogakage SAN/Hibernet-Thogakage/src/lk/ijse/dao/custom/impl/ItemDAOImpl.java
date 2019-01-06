package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.entity.Item;
import lk.ijse.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    private SessionFactory sessionFactory;

    public ItemDAOImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean save(Item entity) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(entity);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Item entity) throws Exception {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();

            session.update(entity);
            session.getTransaction().commit();
        }catch (HibernateException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Item item) throws Exception {
        try(Session session=sessionFactory.openSession()) {
            session.beginTransaction();

            session.remove(item);

            session.getTransaction().commit();
        }catch (HibernateException e){
            return false;
        }
        return true;
    }

    @Override
    public Item search(Integer integer) throws Exception {
        Item  item;
        try(Session session=sessionFactory.openSession()) {
            session.beginTransaction();
             item = session.get(Item.class, integer);
            session.getTransaction().commit();
        }
        return item;
    }

    @Override
    public List<Item> getAll() throws Exception {
        List list;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            list = session.createQuery("FROM Item").list();

            session.getTransaction().commit();
        } catch (HibernateException e) {
            return null;
        }
        return list;
    }

}
