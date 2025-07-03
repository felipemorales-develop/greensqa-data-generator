package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection con;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Usamos el nuevo driver con .cj
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gsqa_prueba", // URL de la base de datos
                "root", // Usuario
                ""      // Contraseña (vacía por defecto en XAMPP)
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
