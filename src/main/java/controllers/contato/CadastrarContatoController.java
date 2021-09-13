package controllers.contato;

import java.io.IOException;

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

@WebServlet("/cadastrarContato")
public class CadastrarContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService;
	private ContatoService contatoService;
           
    public CadastrarContatoController() {
    	this.usuarioService = new UsuarioService();
		this.contatoService = new ContatoService();
	}
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String usuarioId = request.getParameter("usuarioId");
    	
		Usuario usuario = usuarioService.executarPegarUsuarioPorId(usuarioId);
		
		request.setAttribute("usuario", usuario);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cadastrarContato.jsp");   
		
		requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String usuarioId = request.getParameter("usuarioId");
    	
    	String nome = request.getParameter("nome");
    	String rg = request.getParameter("rg");
    	String cpf = request.getParameter("cpf");
    	
    	String rua = request.getParameter("rua");
    	String numero = request.getParameter("numero");
    	String complemento = request.getParameter("complemento");
    	String bairro = request.getParameter("bairro");
    	String cep = request.getParameter("cep");
    	String cidade = request.getParameter("cidade");
    	String estado = request.getParameter("estado");
    	
		Contato contato = contatoService.executarCadastrarContato(nome, rg, cpf, rua, numero, complemento, bairro, cep, cidade, estado, usuarioId);
		
		if (contato == null) {
			response.sendRedirect("cadastrarContato?usuarioId="+usuarioId);
    	} else {
    		response.sendRedirect("contatos?usuarioId="+usuarioId);
    	}
    }
}
