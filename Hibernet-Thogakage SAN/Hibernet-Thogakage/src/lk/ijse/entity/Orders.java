package lk.ijse.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    private int OID;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    private double total;


    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.PERSIST)
    private List<OrderDetail>orderDetails=new ArrayList<>();



    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Orders() {
    }



    public Orders(int OID, Date orderDate, double total, Customer customer) {
        this.OID = OID;
        this.orderDate = orderDate;
        this.total = total;
        this.customer = customer;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "OID=" + OID +
                ", orderDate=" + orderDate +
                ", total=" + total +
                ", customer=" + customer +
                '}';
    }
}
