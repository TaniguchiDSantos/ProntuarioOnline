package com.mycompany.telasa3;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private String usuario = "root";
    private String senha = "admin123";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "prontuario?useTimezone=true&serverTimezone=UTC";

    public Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd, usuario, senha);
            
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
