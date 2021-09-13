package controllers.endereco;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ContatoService;

@WebServlet("/deletarEndereco")
public class DeletarEnderecoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContatoService contatoService;
           
    public DeletarEnderecoController() {
		this.contatoService = new ContatoService();
	}
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String enderecoId = request.getParameter("enderecoId");
    	String contatoId = request.getParameter("contatoId");
    	String usuarioId = request.getParameter("usuarioId");
    	
    	contatoService.executarDeletarEndereco(enderecoId);
    	
    	response.sendRedirect("exibirContato?contatoId="+contatoId+"&usuarioId="+usuarioId);
    }
}
