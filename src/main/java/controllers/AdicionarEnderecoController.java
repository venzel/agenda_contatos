package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Contato;
import services.ContatoService;

@WebServlet("/adicionarEndereco")
public class AdicionarEnderecoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContatoService contatoService;
           
    public AdicionarEnderecoController() {
		this.contatoService = new ContatoService();
	}
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String contatoId = request.getParameter("contatoId");
    	
		Contato contato = contatoService.exibir(contatoId);
		
		request.setAttribute("contato", contato);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adicionarEndereco.jsp");   
		
		requestDispatcher.forward(request, response);
    }
}
