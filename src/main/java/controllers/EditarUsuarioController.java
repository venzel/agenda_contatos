package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Usuario;
import services.UsuarioService;

@WebServlet("/exibirUsuario")
public class EditarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService;
           
    public EditarUsuarioController() {
		this.usuarioService = new UsuarioService();
	}
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String email = request.getParameter("email");
    	
		Usuario usuario = usuarioService.exibir(email);
		
		request.setAttribute("usuario", usuario);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editarUsuario.jsp");   
		
		requestDispatcher.forward(request, response);
    }
}
