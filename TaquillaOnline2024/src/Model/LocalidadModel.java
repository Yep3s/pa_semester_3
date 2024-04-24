package Model;

import java.io.Serializable;

public class LocalidadModel implements Serializable {

    private int id;
    private String localityCode;
    private String localityName;
    private int localityPrice;
    private int numeroDeEspacios;

    public LocalidadModel() {
    }

    public LocalidadModel(int id, String localityCode, String localityName, int localityPrice, int numeroDeEspacios) {
        this.id = id;
        this.localityCode = localityCode;
        this.localityName = localityName;
        this.localityPrice = localityPrice;
        this.numeroDeEspacios = numeroDeEspacios;
    }

    public LocalidadModel(String localityCode, String localityName, int localityPrice, int numeroDeEspacios) {
        this.localityCode = localityCode;
        this.localityName = localityName;
        this.localityPrice = localityPrice;
        this.numeroDeEspacios = numeroDeEspacios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalityCode() {
        return localityCode;
    }

    public void setLocalityCode(String localityCode) {
        this.localityCode = localityCode;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public int getLocalityPrice() {
        return localityPrice;
    }

    public void setLocalityPrice(int localityPrice) {
        this.localityPrice = localityPrice;
    }

    public int getNumeroDeEspacios() {
        return numeroDeEspacios;
    }

    public void setNumeroDeEspacios(int numeroDeEspacios) {
        this.numeroDeEspacios = numeroDeEspacios;
    }

    @Override
    public String toString() {
        return "Localidad{" + "id=" + id + ", localityCode=" + localityCode + ", localityName=" + localityName + ", localityPrice=" + localityPrice + ", numeroDeEspacios=" + numeroDeEspacios + '}';
    }

}
