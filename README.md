# GSQAApp - Generador de datos (Reto GreenSQA Parte 1)

Este proyecto corresponde a la **Parte 1** del reto técnico de **GreenSQA**, que consiste en el desarrollo de una aplicación web en JSP/Servlets para generar datos ficticios, almacenarlos en una base de datos MySQL, exportarlos en formato `.csv` y permitir su envío por correo electrónico.

---

## 🛠️ Tecnologías utilizadas

- Java 17  
- JSP y Servlets  
- NetBeans IDE  
- Apache Tomcat (integrado en NetBeans)  
- MySQL (via XAMPP)  
- JDBC  
- HTML5 / CSS3  
- Bootstrap (opcional)

---

## 🚀 Funcionalidades principales

- Generación de registros de empleados con datos aleatorios.  
- Almacenamiento de los registros en una base de datos MySQL.  
- Exportación de los datos generados a un archivo `empleados.csv`.  
- Envío opcional del archivo CSV por correo electrónico desde la aplicación.

---

## ⚙️ Requisitos para ejecución

- NetBeans IDE 12+ con Apache Tomcat configurado.  
- XAMPP activo (Apache + MySQL).  
- Java JDK 17 instalado y configurado.  
- Cuenta Gmail con autenticación de dos factores (para envío de correo).  
- Contraseña de aplicación de Gmail (para conexión segura desde la app).

## 🧱 Estructura del proyecto

GSQAApp/
├── src/
│ └── controlador/ → Servlets y lógica de control
│ └── modelo/ → Clases para acceso a datos y lógica de negocio
├── web/
│ └── index.jsp → Interfaz web principal
│ └── WEB-INF/web.xml → Mapeo de servlets
├── empleados.csv → Archivo CSV generado con los datos ficticios

---

## 🧪 Pasos para ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/felipemorales-develop/greensqa-data-generator.git
2. Importar en NetBeans
Abrir NetBeans → Archivo → Abrir Proyecto

Seleccionar la carpeta GSQAApp.

3. Configurar base de datos
Iniciar XAMPP (MySQL y Apache).

Crear base de datos greensqa.

Crear tabla empleados con los campos requeridos (nombre, email, etc.).

Verificar o ajustar la configuración JDBC en modelo.Conexion.java.

4. Ejecutar el proyecto
Ejecutar el proyecto en NetBeans con Tomcat.

Acceder en el navegador a http://localhost:8080/GSQAApp.

5. (Opcional) Configurar correo
En tu cuenta de Gmail, ir a:
Configuración > Seguridad > Contraseñas de aplicación

Generar una contraseña de aplicación para usarla en la clase de envío de correo.

📎 Notas adicionales
Se aplicaron principios de POO para estructurar el código.

El CSV generado puede visualizarse y descargarse directamente.

El envío de correo se hace mediante JavaMail.

El sistema es extensible y preparado para pruebas automáticas en la Parte 2.

👨‍💻 Autor
Felipe Morales
GitHub: felipemorales-develop
