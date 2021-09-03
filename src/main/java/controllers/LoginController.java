package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.UsuarioRepository;
import services.LoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService;
	    
    public LoginController(LoginService loginService) {
		this.loginService = new LoginService(new UsuarioRepository());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String email = "tiago@gmail.com";
    	String password = "212312";
	}
}