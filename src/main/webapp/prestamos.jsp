<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Préstamos - Biblioteca Digital</title>
</head>

<body>

    <h1>Préstamos registrados</h1>

    <table border="1">

        <tr>
            <th>ID</th>
            <th>ID Libro</th>
            <th>Usuario</th>
            <th>Fecha préstamo</th>
            <th>Fecha devolución</th>
            <th>Estado</th>
            <th>Acción</th>
        </tr>

        <c:forEach var="prestamo" items="${prestamos}">

            <tr>
                <td><c:out value="${prestamo.id}" /></td>

                <td><c:out value="${prestamo.libroId}" /></td>

                <td><c:out value="${prestamo.usuario}" /></td>

                <td><c:out value="${prestamo.fechaPrestamo}" /></td>

                <td>
                    <c:out value="${prestamo.fechaDevolucion}" />
                </td>

                <td>
                    <c:choose>
                        <c:when test="${prestamo.devuelto}">
                            Devuelto
                        </c:when>

                        <c:otherwise>
                            Prestado
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    <c:if test="${not prestamo.devuelto}">

                        <form action="PrestamoServlet" method="post">

                            <input type="hidden"
                                   name="accion"
                                   value="devolver">

                            <input type="hidden"
                                   name="prestamoId"
                                   value="${prestamo.id}">

                            <button type="submit">
                                Devolver
                            </button>

                        </form>

                    </c:if>
                </td>

            </tr>

        </c:forEach>

    </table>

    <br>

    <a href="LibroServlet">Volver a libros</a>

</body>
</html>