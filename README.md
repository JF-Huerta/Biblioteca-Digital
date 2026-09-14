# Biblioteca Digital UNTEC

## Sobre el proyecto

Este proyecto consiste en una biblioteca digital desarrollada en Java, donde se pueden administrar libros y registrar sus préstamos y devoluciones.

La idea fue aplicar lo aprendido durante el módulo 5, trabajando con JSP, Servlets, bases de datos y el patrón MVC.

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

Para desarrollar el proyecto utilicé:

- Java EE
- JSP y Servlets
- JSTL
- JDBC
- MySQL
- Apache Tomcat 9
- Eclipse
- HTML y CSS

## Organización del proyecto

El proyecto está organizado utilizando el patrón MVC.

Los Servlets se encargan de recibir y procesar las solicitudes, los JSP muestran la información en pantalla y las clases DAO se encargan de comunicarse con la base de datos.

También se utiliza una sesión para mantener al usuario conectado después de iniciar sesión.

## Cómo ejecutar la aplicación

1. Abrir el proyecto `BibliotecaDigital` en Eclipse.
2. Tener MySQL funcionando y la base de datos configurada.
3. Configurar Apache Tomcat 9.
4. Ejecutar el proyecto en Tomcat.
5. Abrir la aplicación desde el navegador.

También se puede utilizar el archivo `BibliotecaDigital.war` para desplegar el proyecto directamente en Tomcat.

## Uso

Al entrar a la aplicación aparece el inicio de sesión.

Después de ingresar, se puede acceder al listado de libros, agregar nuevos libros, editar o eliminar los existentes.

También se pueden registrar préstamos indicando el libro y el usuario. Los préstamos quedan registrados y posteriormente se puede marcar la devolución del libro.