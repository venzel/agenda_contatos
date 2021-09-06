package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Usuario;
import services.LoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService;
	    
    public LoginController() {
		this.loginService = new LoginService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String email = request.getParameter("email");
    	String senha = request.getParameter("senha");
    	
    	Usuario usuario = loginService.executar(email, senha);
    	    	
    	if (usuario != null) {
    		response.sendRedirect("contatos?usuarioEmail="+email);
    	} else {
    		response.sendRedirect("login.html");
    	}
	}
}