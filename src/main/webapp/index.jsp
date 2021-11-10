<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 9 nov. 2021, 18:25:20
    Author     : Jhonny
--%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Seminarios"%>
<%
    List<Seminarios> lista = (List<Seminarios>) request.getAttribute("lista");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de seminario</h1>
        <br><!-- comment -->
        <h3><b>Nombre:</b>Jhonny Huallpa Rodriguez</h3>
        <p>
            <a href="MainController?op=nuevo">Nuevo</a>
        </p>
        <table border="1">

            <tr>
                <th>ID</th>
                <th>Titulo</th>
                <th>Expositor</th>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Cupo</th>
            </tr>
            <c:forEach var="item" items="${lista}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td><!-- comment -->
                    <td>${item.expositor}</td><!-- comment -->
                    <td>${item.fecha}</td><!-- comment -->
                    <td>${item.hora}</td>
                    <td>${item.cupo}</td>
                    <td><a href="MainController?op=editar&id=${item.id}">Editar</a></td>
                    <td><a href="MainController?op=eliminar&id=${item.id}"
                           onclick="return(confirm('Esta seguro ???'))">Eliminar</a></td>
                    <td></td>
                </tr>
            </c:forEach>



        </table>

    </body>
</html>
