package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Usuario;
import services.UsuarioService;

@WebServlet("/usuarios")
public class ListarUsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService;
           
    public ListarUsuariosController() {
		this.usuarioService = new UsuarioService();
	}

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Usuario> usuarios = usuarioService.listar();
    	
		request.setAttribute("usuarios", usuarios);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listarUsuarios.jsp");    		
		
		requestDispatcher.forward(request, response);
    }
}