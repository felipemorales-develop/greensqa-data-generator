package controlador;

import dao.EmpleadoDAO;
import modelo.Empleado;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.activation.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/EnviarCorreoCSV")
public class EnviarCorreoCSV extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Ruta temporal para guardar el archivo
        String ruta = getServletContext().getRealPath("/") + "empleados.csv";

        // Generar archivo CSV temporal
        FileWriter writer = new FileWriter(ruta);
        writer.write("ID,Nombre,Apellido,Cargo,Correo,Teléfono\n");

        EmpleadoDAO dao = new EmpleadoDAO();
        for (Empleado emp : dao.listar()) {
            writer.write(String.format("%d,%s,%s,%s,%s,%s\n",
                    emp.getId(),
                    emp.getNombre(),
                    emp.getApellido(),
                    emp.getCargo(),
                    emp.getCorreo(),
                    emp.getTelefono()));
        }
        writer.close();

        // Parámetros del correo
        final String remitente = "pruebasgreenapp@gmail.com";
        final String clave = "hquk artl hmrn ptyw"; // tu contraseña de aplicación
        final String destinatario = "destinatario@correo.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Usa STARTTLS, no SSL
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Puerto STARTTLS correcto


        Session sesion = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, clave);
            }
        });

        try {
            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(remitente));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject("Archivo de empleados CSV");

            // Cuerpo del mensaje
            BodyPart texto = new MimeBodyPart();
            texto.setText("Adjunto el archivo de empleados generado desde la aplicación web.");

            // Archivo adjunto
            MimeBodyPart adjunto = new MimeBodyPart();
            DataSource source = new FileDataSource(ruta);
            adjunto.setDataHandler(new DataHandler(source));
            adjunto.setFileName("empleados.csv");

            Multipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            mensaje.setContent(multiParte);

            Transport.send(mensaje);
            response.getWriter().println("Correo enviado correctamente.");

        } catch (MessagingException e) {
            e.printStackTrace();
            response.getWriter().println("Error al enviar el correo: " + e.getMessage());
        }
    }
}
