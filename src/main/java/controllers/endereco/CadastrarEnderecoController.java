package controllers.endereco;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Contato;
import services.ContatoService;

@WebServlet("/cadastrarEndereco")
public class CadastrarEnderecoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContatoService contatoService;
           
    public CadastrarEnderecoController() {
		this.contatoService = new ContatoService();
	}
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String contatoId = request.getParameter("contatoId");
    	
		Contato contato = contatoService.executarExibirContato(contatoId);
		
		request.setAttribute("contato", contato);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cadastrarEndereco.jsp");   
		
		requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String contatoId = request.getParameter("contatoId");
    	String usuarioId = request.getParameter("usuarioId");
    
    	String rua = request.getParameter("rua");
    	String numero = request.getParameter("numero");
    	String complemento = request.getParameter("complemento");
    	String bairro = request.getParameter("bairro");
    	String cep = request.getParameter("cep");
    	String cidade = request.getParameter("cidade");
    	String estado = request.getParameter("estado");
    	
		contatoService.executarCadastrarEndereco(rua, numero, complemento, bairro, cep, cidade, estado, contatoId, usuarioId);

		response.sendRedirect("exibirContato?contatoId="+contatoId+"&usuarioId="+usuarioId);
    }
}
