package Model;

import java.io.Serializable;

public class EventoLocalidadesModel implements Serializable{
    
    private int id;
    private int eventId;
    private int localityId;

    public EventoLocalidadesModel(int eventId, int localityId) {
        this.eventId = eventId;
        this.localityId = localityId;
    }

    public EventoLocalidadesModel(int id, int eventId, int localityId) {
        this.id = id;
        this.eventId = eventId;
        this.localityId = localityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getLocalityId() {
        return localityId;
    }

    public void setLocalityId(int localityId) {
        this.localityId = localityId;
    }

    @Override
    public String toString() {
        return "EventoLocalidadesModel{" + "id=" + id + ", eventId=" + eventId + ", localityId=" + localityId + '}';
    }
    
    
    
    
    
    
}
