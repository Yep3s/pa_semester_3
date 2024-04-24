package Model;

import java.io.Serializable;

public class BoletasCompradasModel implements Serializable{
    
    private int id;
    private String uuid;
    private String locality;
    private String event;

    public BoletasCompradasModel() {
    }
    
    public BoletasCompradasModel(int id, String uuid, String locality, String event) {
        this.id = id;
        this.uuid = uuid;
        this.locality = locality;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "BoletasCompradasModel{" + "id=" + id + ", uuid=" + uuid + ", locality=" + locality + ", event=" + event + '}';
    }
    
    
    
}
