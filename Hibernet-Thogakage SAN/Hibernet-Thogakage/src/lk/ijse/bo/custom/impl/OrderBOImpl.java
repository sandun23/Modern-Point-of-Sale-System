package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.OrderBO;
import lk.ijse.dao.custom.OderDAO;
import lk.ijse.dao.custom.impl.OderDAOImpl;
import lk.ijse.entity.Customer;
import lk.ijse.entity.OrderDetail;
import lk.ijse.entity.Orders;
import lk.ijse.model.CommenDTO;
import lk.ijse.model.OrdersDTO;
import lk.ijse.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;

public class OrderBOImpl implements OrderBO {
    private OderDAO oderDAO;

    public OrderBOImpl() {
        oderDAO=new OderDAOImpl();
    }

    @Override
    public boolean addOrder(CommenDTO dto) throws Exception {
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(new Orders(dto.getOrders().getOID(),dto.getOrders().getOrderDate(),dto.getOrders().getTotal(),dto.getOrders().getCustomer()));
            session.save(new OrderDetail(dto.getOrderDetail().getOrderQTY(),dto.getOrderDetail().getTotale(),dto.getOrderDetail().getItem(),dto.getOrderDetail().getOrders()));
            session.getTransaction().commit();
        }
        return true;

    }

    @Override
    public boolean updateOrder(OrdersDTO ordersDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteOrder(OrdersDTO ordersDTO) throws Exception {
        return false;
    }

    @Override
    public OrdersDTO searchOrder(int id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrdersDTO> getAllOrder() throws Exception {
        return null;
    }
}
