<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">

    <title>Biblioteca Digital UNTEC</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

    <h1>Biblioteca Digital UNTEC</h1>

    <p>
        <c:out value="Bienvenida a la biblioteca digital" />
    </p>

    <c:if test="${not empty error}">
        <p>
            <c:out value="${error}" />
        </p>
    </c:if>

    <form action="LoginServlet" method="post">

        <label for="usuario">
            Usuario:
        </label>

        <input type="text"
               id="usuario"
               name="usuario"
               required>

        <br><br>

        <label for="password">
            Contraseña:
        </label>

        <input type="password"
               id="password"
               name="password"
               required>

        <br><br>

        <button type="submit">
            Ingresar
        </button>

    </form>

</body>

</html>