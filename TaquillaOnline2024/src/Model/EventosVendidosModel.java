package Model;

import java.io.Serializable;

public class EventosVendidosModel implements Serializable {

    private String event;
    private String locality;
    private int quantity;
    private int total;

    public EventosVendidosModel() {
    }

    public EventosVendidosModel(String event, String locality, int quantity, int total) {
        this.event = event;
        this.locality = locality;
        this.quantity = quantity;
        this.total = total;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "EventosVendidosModel{" + "event=" + event + ", locality=" + locality + ", quantity=" + quantity + ", total=" + total + '}';
    }

}
