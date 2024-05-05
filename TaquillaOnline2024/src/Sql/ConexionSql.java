package Sql;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConexionSql {
    

    private Connection connection;
    private String user = "";
    private String password = "";
    private String url = "";
    private String driver = "";
    private static ConexionSql instancia;

    public static ConexionSql getInstance() {
        if (instancia == null) {
            instancia = new ConexionSql();
        }
        return instancia;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public static void setInstancia(ConexionSql instancia) {
        ConexionSql.instancia = instancia;
    }

    public void conectar() throws Exception {
        Class.forName(driver).newInstance();
        connection = DriverManager.getConnection(url, user, password);
    }

}
