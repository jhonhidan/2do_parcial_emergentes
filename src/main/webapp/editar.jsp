<%@page import="com.emergentes.modelo.Seminarios"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : editar.jsp
    Created on : 9 nov. 2021, 19:31:52
    Author     : Jhonny
--%>
<%
    Seminarios sem = (Seminarios) request.getAttribute("sem");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${sem.id==0}">
                Nuevo
            </c:if>
             <c:if test="${sem.id !=0}">
                 Editar
            </c:if>
        </h1>
           <form action="MainController" method="POST">
            <input type="hidden" name="id" value="${sem.id}" />
            <table >

                <tr>
                    <th></th>
                    <th></th>
                </tr>

                <tr>
                    <td>Titulo</td>
                    <td>
                        <input type="text" name="titulo" value="${sem.titulo}" />
                    </td>

                </tr>
                <tr>
                    <td>Expositor</td>
                    <td>
                        <input type="text" name="expositor" value="${sem.expositor}" />
                    </td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td>
                        <input select type="date" name="fecha" value="${sem.fecha}" />
                    </td>
                </tr>
                <tr>
                    <td>Hora</td>
                    <td>
                        <input select type="text" name="hora" value="${sem.hora}" " />
                    </td>
                </tr>
                <tr>
                    <td>Cupo</td>
                    <td>
                        <input type="number" name="cupo" value="${sem.cupo}" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Enviar" />
                    </td>
                </tr>

            </table>

        </form>
    
    </body>
</html>
