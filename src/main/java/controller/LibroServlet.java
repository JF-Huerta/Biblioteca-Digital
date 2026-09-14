package controller;

import java.io.IOException;
import java.util.List;

import dao.LibroDAO;
import model.Libro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LibroServlet")
public class LibroServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LibroServlet() {
        super();
    }

    // Muestra el listado de libros disponibles
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verifica que exista una sesión activa
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        // Obtiene los libros desde la base de datos
        LibroDAO libroDAO = new LibroDAO();
        List<Libro> libros = libroDAO.obtenerLibros();

        // Envía la lista de libros a la vista JSP
        request.setAttribute("libros", libros);

        request.getRequestDispatcher("libros.jsp")
               .forward(request, response);
    }

    // Procesa las acciones de agregar, editar o eliminar libros
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verifica que exista una sesión activa
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String accion = request.getParameter("accion");

        LibroDAO libroDAO = new LibroDAO();

        // Elimina un libro
        if ("eliminar".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));

            libroDAO.eliminarLibro(id);

        // Edita un libro existente
        } else if ("editar".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));
            String titulo = request.getParameter("titulo");
            String autor = request.getParameter("autor");

            libroDAO.actualizarLibro(id, titulo, autor);

        // Si no viene una acción específica, agrega un nuevo libro
        } else {

            String titulo = request.getParameter("titulo");
            String autor = request.getParameter("autor");

            libroDAO.agregarLibro(titulo, autor);
        }

        // Recarga el listado actualizado
        response.sendRedirect("LibroServlet");
    }
}