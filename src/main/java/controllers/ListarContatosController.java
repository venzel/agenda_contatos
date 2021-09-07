package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Contato;
import domain.Usuario;
import services.ContatoService;
import services.UsuarioService;

@WebServlet("/contatos")
public class ListarContatosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContatoService contatoService;
	private UsuarioService usuarioService;
    
    public ListarContatosController() {
		this.contatoService = new ContatoService();
		this.usuarioService = new UsuarioService();
	}
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String usuarioEmail = request.getParameter("usuarioEmail");
    	
    	Usuario usuario = usuarioService.exibir(usuarioEmail);
    	
		List<Contato> contatos = contatoService.listar(usuarioEmail);
			
		request.setAttribute("usuario", usuario);
		request.setAttribute("contatos", contatos);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listarContatos.jsp");   
		
		requestDispatcher.forward(request, response);
    }
}
