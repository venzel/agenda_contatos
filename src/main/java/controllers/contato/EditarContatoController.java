package controllers.contato;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Contato;
import services.ContatoService;

@WebServlet("/editarContato")
public class EditarContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContatoService contatoService;
           
    public EditarContatoController() {
		this.contatoService = new ContatoService();
	}
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String contatoId = request.getParameter("contatoId");
    	
		Contato contato = contatoService.executarExibirContato(contatoId);
		
		request.setAttribute("contato", contato);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editarContato.jsp");   
		
		requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String contatoId = request.getParameter("contatoId");
    	String usuarioId = request.getParameter("usuarioId");
    	
    	String nome = request.getParameter("nome");
    	String rg = request.getParameter("rg");
    	String cpf = request.getParameter("cpf");

    	contatoService.executarEditarContato(nome, rg, cpf, contatoId, usuarioId);
    	
    	response.sendRedirect("contatos?usuarioId="+usuarioId);
    }
}
