package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Usuario;
import services.UsuarioService;

@WebServlet("/adicionarUsuario")
public class AdicionarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService;
           
    public AdicionarUsuarioController() {
		this.usuarioService = new UsuarioService();
	}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String nome = request.getParameter("nome"); 
    	String email = request.getParameter("email");
    	String senha = request.getParameter("senha");

    	Usuario usuario = usuarioService.criar(nome, email, senha);
    	
    	String redirecionar = usuario.getAdmin() ? "usuarios" : "login.html";
    	
    	response.sendRedirect(redirecionar);
    }
}
