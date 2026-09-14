# Biblioteca Digital UNTEC

## Sobre el proyecto

Biblioteca Digital UNTEC es una aplicación web desarrollada en Java para administrar libros y gestionar préstamos y devoluciones dentro de una biblioteca.

El proyecto fue desarrollado utilizando una arquitectura MVC, separando la lógica de negocio, el acceso a datos y la interfaz de usuario.

## ¿Qué se puede hacer?

La aplicación permite:

- Iniciar sesión.
- Ver los libros disponibles.
- Agregar nuevos libros.
- Editar libros.
- Eliminar libros.
- Registrar préstamos.
- Ver los préstamos realizados.
- Registrar la devolución de un libro.

## Tecnologías utilizadas

- Java EE
- JSP y Servlets
- JSTL
- JDBC
- MySQL
- Apache Tomcat 9
- Eclipse
- HTML y CSS

## Arquitectura del proyecto

El proyecto está organizado utilizando el patrón MVC.

Los Servlets actúan como controladores y procesan las solicitudes del usuario.

Las páginas JSP se encargan de mostrar la información en pantalla.

Las clases DAO gestionan la comunicación con la base de datos mediante JDBC.

También se utilizan sesiones HTTP para mantener al usuario autenticado después de iniciar sesión.

## Base de datos

La aplicación utiliza MySQL para almacenar información de libros, usuarios y préstamos.

El repositorio incluye el archivo:

`biblioteca_digital.sql`

Este archivo permite recrear la estructura de la base de datos necesaria para ejecutar el proyecto.

## Configuración de credenciales

Por seguridad, la contraseña de la base de datos no se almacena directamente en el código fuente.

La aplicación obtiene la contraseña desde una variable de entorno:

`BIBLIOTECA_DB_PASSWORD`

## Cómo ejecutar la aplicación

1. Clonar o descargar el repositorio.
2. Abrir el proyecto `BibliotecaDigital` en Eclipse.
3. Importar el archivo `biblioteca_digital.sql` en MySQL.
4. Configurar la variable de entorno `BIBLIOTECA_DB_PASSWORD`.
5. Configurar Apache Tomcat 9.
6. Ejecutar el proyecto en Tomcat.
7. Abrir la aplicación desde el navegador.

## Uso

Al ingresar a la aplicación aparece la pantalla de inicio de sesión.

Después de iniciar sesión se puede acceder al listado de libros, agregar nuevos registros, editar o eliminar libros existentes.

También se pueden registrar préstamos indicando el libro y el usuario. Los préstamos quedan registrados en la base de datos y posteriormente pueden marcarse como devueltos.

## Aprendizajes del proyecto

Durante el desarrollo de este proyecto trabajé principalmente en:

- Implementación del patrón MVC en una aplicación web Java.
- Uso de Servlets para manejar solicitudes HTTP.
- Conexión con MySQL utilizando JDBC.
- Implementación del patrón DAO para separar el acceso a datos.
- Manejo de sesiones de usuario.
- Uso de JSP y JSTL para generar vistas dinámicas.
- Despliegue de aplicaciones web utilizando Apache Tomcat.
- Separación de credenciales sensibles mediante variables de entorno.
