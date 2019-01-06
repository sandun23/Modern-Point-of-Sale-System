package lk.ijse.model;

public class OrderDetailDTO {
    private int orderQTY;
    private double totale;
    private int itemCode;
    private int OID;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderQTY, double totale, int itemCode, int OID) {
        this.orderQTY = orderQTY;
        this.totale = totale;
        this.itemCode = itemCode;
        this.OID = OID;
    }

    public int getOrderQTY() {
        return orderQTY;
    }

    public void setOrderQTY(int orderQTY) {
        this.orderQTY = orderQTY;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "orderQTY=" + orderQTY +
                ", totale=" + totale +
                ", itemCode=" + itemCode +
                ", OID=" + OID +
                '}';
    }
}
