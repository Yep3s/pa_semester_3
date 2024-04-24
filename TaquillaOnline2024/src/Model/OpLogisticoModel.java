package Model;

import java.io.Serializable;

public class OpLogisticoModel implements Serializable {

    private int id;
    private String name;
    private String cedula;
    private String phone;
    private String email;
    private String password;

    public OpLogisticoModel() {
    }

    public OpLogisticoModel(int id, String name, String cedula, String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.cedula = cedula;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public OpLogisticoModel(String name, String cedula, String phone, String email, String password) {
        this.name = name;
        this.cedula = cedula;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "OpLogisticoModel{" + "id=" + id + ", name=" + name + ", cedula=" + cedula + ", phone=" + phone + ", email=" + email + ", password=" + password + '}';
    }

}
