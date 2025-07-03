package controlador;

import dao.EmpleadoDAO;
import modelo.Empleado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Random;

@WebServlet("/GenerarDatos")
public class GenerarDatos extends HttpServlet {

    private static final String[] NOMBRES = {"Ana", "Carlos", "Laura", "Juan", "Sofía"};
    private static final String[] APELLIDOS = {"Pérez", "Gómez", "Rodríguez", "López", "Martínez"};
    private static final String[] CARGOS = {"Tester", "Analista", "Desarrollador", "Scrum Master"};

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmpleadoDAO dao = new EmpleadoDAO();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            Empleado emp = new Empleado();
            emp.setNombre(NOMBRES[rand.nextInt(NOMBRES.length)]);
            emp.setApellido(APELLIDOS[rand.nextInt(APELLIDOS.length)]);
            emp.setCargo(CARGOS[rand.nextInt(CARGOS.length)]);
            emp.setCorreo("empleado" + i + "@empresa.com");
            emp.setTelefono("300" + (1000000 + rand.nextInt(9000000)));

            dao.insertar(emp);
        }

        request.setAttribute("mensaje", "Se generaron 10 empleados ficticios.");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
