package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrestamoDAO;
import model.Prestamo;

@WebServlet("/PrestamoServlet")
public class PrestamoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public PrestamoServlet() {
        super();
    }

    // Obtiene y muestra todos los préstamos registrados
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrestamoDAO prestamoDAO = new PrestamoDAO();

        // Obtiene los préstamos desde la base de datos
        List<Prestamo> prestamos = prestamoDAO.obtenerPrestamos();

        // Envía la lista de préstamos a la vista JSP
        request.setAttribute("prestamos", prestamos);

        request.getRequestDispatcher("prestamos.jsp")
               .forward(request, response);
    }

    // Procesa el registro de préstamos y sus devoluciones
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        PrestamoDAO prestamoDAO = new PrestamoDAO();

        // Registra la devolución de un préstamo
        if ("devolver".equals(accion)) {

            int prestamoId = Integer.parseInt(
                    request.getParameter("prestamoId")
            );

            prestamoDAO.devolverPrestamo(prestamoId);

        } else {

            // Registra un nuevo préstamo
            int libroId = Integer.parseInt(
                    request.getParameter("libroId")
            );

            String usuario = request.getParameter("usuario");

            prestamoDAO.agregarPrestamo(libroId, usuario);
        }

        // Recarga la lista con los cambios realizados
        response.sendRedirect("PrestamoServlet");
    }
}