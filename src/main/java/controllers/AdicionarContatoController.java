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

@WebServlet("/adicionarContato")
public class AdicionarContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService;
           
    public AdicionarContatoController() {
		this.usuarioService = new UsuarioService();
	}

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String usuarioEmail = request.getParameter("usuarioEmail");
    	
    	System.out.println(usuarioEmail);
    	
		Usuario usuario = usuarioService.exibir(usuarioEmail);
		
		request.setAttribute("usuario", usuario);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adicionarContato.jsp");   
		
		requestDispatcher.forward(request, response);
    }
}
