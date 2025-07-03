package dao;

import modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class EmpleadoDAO {

    public boolean insertar(Empleado emp) {
        boolean resultado = false;
        String sql = "INSERT INTO empleados(nombre, apellido, cargo, correo, telefono) VALUES (?, ?, ?, ?, ?)";

        try {
            Conexion cn = new Conexion();
            Connection con = cn.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellido());
            ps.setString(3, emp.getCargo());
            ps.setString(4, emp.getCorreo());
            ps.setString(5, emp.getTelefono());

            resultado = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    
    public List<Empleado> listar() {
    List<Empleado> lista = new ArrayList<>();
    String sql = "SELECT * FROM empleados";

    try {
        Conexion cn = new Conexion();
        Connection con = cn.getConexion();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Empleado emp = new Empleado();
            emp.setId(rs.getInt("id"));
            emp.setNombre(rs.getString("nombre"));
            emp.setApellido(rs.getString("apellido"));
            emp.setCargo(rs.getString("cargo"));
            emp.setCorreo(rs.getString("correo"));
            emp.setTelefono(rs.getString("telefono"));

            lista.add(emp);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}
}
