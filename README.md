# 🌱 GSQAApp - Generador de datos (Reto GreenSQA Parte 1)

Este proyecto corresponde a la Parte 1 del reto técnico de GreenSQA, que consiste en el desarrollo de una aplicación web en JSP/Servlets para generar datos ficticios, almacenarlos en una base de datos MySQL, exportarlos en formato `.csv` y permitir su envío por correo electrónico.

---

## 🛠️ Tecnologías utilizadas

- Java 17
- JSP y Servlets
- NetBeans IDE
- Apache Tomcat (integrado en NetBeans o externo)
- MySQL (via XAMPP)
- JDBC
- HTML5 / CSS3

---

## 🚀 Funcionalidades principales

- Generación de registros de empleados con datos aleatorios.
- Almacenamiento en una base de datos MySQL.
- Exportación de los datos generados a un archivo `empleados.csv`.
- Envío opcional del archivo CSV por correo electrónico desde la aplicación.

---

## ⚙️ Requisitos para ejecución

- NetBeans IDE 12+ con Apache Tomcat configurado.
- XAMPP activo (Apache + MySQL).
- Java JDK 17 instalado y configurado.
- Cuenta Gmail con autenticación de dos factores.
- Contraseña de aplicación de Gmail (para conexión desde JavaMail).

---

## 🧱 Estructura del proyecto

GSQAApp/
├── src/
│ └── controlador/ # Servlets y lógica de control
│ └── modelo/ # Acceso a datos y lógica de negocio
├── web/
│ └── index.jsp # Interfaz web principal
│ └── WEB-INF/web.xml # Mapeo de servlets
├── empleados.csv # Archivo generado


---

## 🧪 Pasos para ejecución en NetBeans

### 1. Clonar el repositorio

```bash
git clone https://github.com/felipemorales-develop/greensqa-data-generator.git

2. Importar en NetBeans

    Abrir NetBeans → Archivo → Abrir Proyecto

    Seleccionar la carpeta GSQAApp

3. Configurar base de datos

    Iniciar XAMPP (MySQL y Apache)

    Crear base de datos greensqa

    Crear tabla empleados con los campos requeridos (nombre, email, etc.), se deja script SQA.sql

    Verificar o ajustar conexión en modelo.Conexion.java

4. Ejecutar el proyecto

    Ejecutar desde NetBeans (Run)

    Acceder desde el navegador:
    👉 http://localhost:8080/GSQAApp/

5. (Opcional) Configurar envío de correo

    Ir a tu cuenta de Gmail → Seguridad → Contraseñas de aplicación

    Generar una contraseña de aplicación

    Ingresar esta contraseña en la clase de envío de correo (EnviarCorreoCSV.java)

Despliegue del archivo .war
🗂 1. Ubicación del archivo

El archivo .war generado (GSQAApp.war) se encuentra en:

GSQAApp/dist/GSQAApp.war

Cómo desplegarlo
Opción A: Desde NetBeans

    NetBeans compila y despliega automáticamente en Tomcat si está configurado.

Opción B: Manualmente en Tomcat

    Copia GSQAApp.war a la carpeta:

C:\xampp\tomcat\webapps\

    Inicia Tomcat desde el panel de XAMPP.

    Accede a:

http://localhost:8080/GSQAApp/

    ✅ Requiere que el JDK 17 esté instalado y JAVA_HOME correctamente configurado.

📎 Notas adicionales

    Se aplicaron principios de POO para estructurar el código.

    El sistema es extensible para pruebas automáticas en la Parte 2.

    El envío de correo se hace con JavaMail (SMTP de Gmail).

    El CSV puede ser descargado o enviado por correo.

👨‍💻 Autor

Felipe Morales
🔗 GitHub: @felipemorales-develop
