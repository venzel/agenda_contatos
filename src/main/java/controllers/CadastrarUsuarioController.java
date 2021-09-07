package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.UsuarioService;

@WebServlet("/cadastrarUsuario")
public class CadastrarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService;
           
    public CadastrarUsuarioController() {
		this.usuarioService = new UsuarioService();
	}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String nome = request.getParameter("nome"); 
    	String email = request.getParameter("email");
    	String senha = request.getParameter("senha");
    	
    	if (nome.equals("") || email.equals("") || senha.equals("")) {
    		response.sendRedirect("cadastro.html");
    	} else {
	
	    	usuarioService.criar(nome, email, senha);
	    	
	    	response.sendRedirect("login.html");
    	}
    }
}
