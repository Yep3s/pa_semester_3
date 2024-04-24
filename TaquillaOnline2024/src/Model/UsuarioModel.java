package Model;

import java.io.Serializable;

public class UsuarioModel implements Serializable{
    
    private String name;
    private String cedula;
    private String phone;
    private String email;
    private String password;

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
        return "UsuarioModel{" + "name=" + name + ", cedula=" + cedula + ", phone=" + phone + ", email=" + email + ", password=" + password + '}';
    }
    
    
    
}
