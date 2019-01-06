package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.model.CommenDTO;
import lk.ijse.model.OrdersDTO;

import java.util.ArrayList;

public interface OrderBO extends SuperBO {
    public boolean addOrder(CommenDTO ordersDTO)throws Exception;
    public boolean updateOrder(OrdersDTO ordersDTO)throws Exception;
    public boolean deleteOrder(OrdersDTO ordersDTO)throws Exception;
    public OrdersDTO searchOrder(int id)throws Exception;
    public ArrayList<OrdersDTO> getAllOrder()throws Exception;

}
