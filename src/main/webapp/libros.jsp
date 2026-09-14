<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Libros disponibles</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

    <h1>Libros disponibles</h1>

    <ul>
        <c:forEach var="libro" items="${libros}">
            <li>

                <strong>ID:</strong>
                <c:out value="${libro.id}" />

                -
                <c:out value="${libro.titulo}" />

                -
                <c:out value="${libro.autor}" />

                <!-- Formulario para editar -->
                <form action="LibroServlet"
                      method="post"
                      style="display:inline;">

                    <input type="hidden"
                           name="accion"
                           value="editar">

                    <input type="hidden"
                           name="id"
                           value="${libro.id}">

                    <input type="text"
                           name="titulo"
                           value="${libro.titulo}"
                           required>

                    <input type="text"
                           name="autor"
                           value="${libro.autor}"
                           required>

                    <button type="submit">
                        Editar
                    </button>

                </form>

                <!-- Formulario para eliminar -->
                <form action="LibroServlet"
                      method="post"
                      style="display:inline;">

                    <input type="hidden"
                           name="accion"
                           value="eliminar">

                    <input type="hidden"
                           name="id"
                           value="${libro.id}">

                    <button type="submit">
                        Eliminar
                    </button>

                </form>

            </li>
        </c:forEach>
    </ul>


    <h2>Agregar libro</h2>

    <form action="LibroServlet" method="post">

        <label for="titulo">Título:</label>

        <input type="text"
               id="titulo"
               name="titulo"
               required>

        <br><br>

        <label for="autor">Autor:</label>

        <input type="text"
               id="autor"
               name="autor"
               required>

        <br><br>

        <button type="submit">
            Agregar libro
        </button>

    </form>


    <h2>Registrar préstamo</h2>

    <form action="PrestamoServlet" method="post">

        <label for="libroId">ID del libro:</label>

        <input type="number"
               id="libroId"
               name="libroId"
               required>

        <br><br>

        <label for="usuario">Usuario:</label>

        <input type="text"
               id="usuario"
               name="usuario"
               required>

        <br><br>

        <button type="submit">
            Prestar libro
        </button>

    </form>


    <br>

    <a href="PrestamoServlet">
        Ver préstamos registrados
    </a>

</body>

</html>