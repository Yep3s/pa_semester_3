package Model;

public class EventoModel {

    private int id;
    private String code;
    private String eventName;
    private String eventDescription;
    private String eventDate;
    private LocalidadModel localidad = null;

    public EventoModel() {
    }

    public EventoModel(int id, String code, String eventName, String eventDescription, String eventDate) {
        this.id = id;
        this.code = code;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
    }

    public EventoModel(String code, String eventName, String eventDescription, String eventDate) {
        this.code = code;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public LocalidadModel getLocalidad() {
        return localidad;
    }

    public void setLocalidad(LocalidadModel localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "EventoModel{" + "id=" + id + ", code=" + code + ", eventName=" + eventName + ", eventDescription=" + eventDescription + ", eventDate=" + eventDate + ", localidad=" + localidad + '}';
    }

    
    
}
