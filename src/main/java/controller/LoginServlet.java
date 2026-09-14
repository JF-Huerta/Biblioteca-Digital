package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    // Redirige al usuario a la página de inicio
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }

    // Recibe y procesa los datos enviados desde el formulario de login
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Valida las credenciales utilizando UsuarioDAO
        boolean valido = usuarioDAO.validarUsuario(usuario, password);

        if (valido) {

            // Crea una sesión y guarda el nombre del usuario
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            response.sendRedirect("LibroServlet");

        } else {

            // Envía un mensaje de error si las credenciales son incorrectas
            request.setAttribute(
                "error",
                "Usuario o contraseña incorrectos"
            );

            request.getRequestDispatcher("index.jsp")
                   .forward(request, response);
        }
    }
}