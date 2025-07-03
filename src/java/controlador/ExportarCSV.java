package controlador;

import dao.EmpleadoDAO;
import modelo.Empleado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ExportarCSV")
public class ExportarCSV extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"empleados.csv\"");

        PrintWriter out = response.getWriter();
        out.println("ID,Nombre,Apellido,Cargo,Correo,Teléfono");

        EmpleadoDAO dao = new EmpleadoDAO();
        List<Empleado> lista = dao.listar();

        for (Empleado emp : lista) {
            out.printf("%d,%s,%s,%s,%s,%s\n",
                    emp.getId(),
                    emp.getNombre(),
                    emp.getApellido(),
                    emp.getCargo(),
                    emp.getCorreo(),
                    emp.getTelefono());
        }

        out.flush();
        out.close();
    }
}
