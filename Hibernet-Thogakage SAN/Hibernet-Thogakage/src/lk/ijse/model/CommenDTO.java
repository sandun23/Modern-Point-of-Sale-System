package lk.ijse.model;

import lk.ijse.entity.OrderDetail;
import lk.ijse.entity.Orders;

public class CommenDTO {
    private Orders orders;
    private OrderDetail orderDetail;

    public CommenDTO() {
    }

    public CommenDTO(Orders orders, OrderDetail orderDetail) {
        this.orders = orders;
        this.orderDetail = orderDetail;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "CommenDTO{" +
                "orders=" + orders +
                ", orderDetail=" + orderDetail +
                '}';
    }
}
