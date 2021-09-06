package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.UsuarioService;

@WebServlet("/alterarUsuario")
public class AlterarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService;
           
    public AlterarUsuarioController() {
		this.usuarioService = new UsuarioService();
	}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String email = request.getParameter("email");
    	String nome = request.getParameter("nome");

    	usuarioService.alterar(email, nome);
    	
    	response.sendRedirect("usuarios");
    }
}