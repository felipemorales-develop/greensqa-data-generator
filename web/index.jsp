<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>GSQA - Generador de Empleados</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <h1>Generador de Datos Ficticios</h1>

    <form action="GenerarDatos" method="get">
        <input type="submit" value="Generar 10 empleados aleatorios">
    </form>
    
    <form action="ExportarCSV" method="get">
    <input type="submit" value="Exportar a CSV">
</form>

    <form action="EnviarCorreoCSV" method="get">
    <input type="submit" value="Enviar CSV por Correo">
</form>

    <p style="color: green;">
        <%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %>
    </p>
</body>
</html>
