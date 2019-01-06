package lk.ijse.model;

import java.util.Date;

public class OrdersDTO {
    private int OID;
    private int CustID;
    private double total;
    private Date date;

    public OrdersDTO() {
    }

    public OrdersDTO(int OID, int custID, double total, Date date) {
        this.OID = OID;
        CustID = custID;
        this.total = total;
        this.date = date;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public int getCustID() {
        return CustID;
    }

    public void setCustID(int custID) {
        CustID = custID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "OID=" + OID +
                ", CustID=" + CustID +
                ", total=" + total +
                ", date=" + date +
                '}';
    }
}
