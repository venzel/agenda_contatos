package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ContatoService;

@WebServlet("/cadastrarEndereco")
public class CadastrarEnderecoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContatoService contatoService;
           
    public CadastrarEnderecoController() {
		this.contatoService = new ContatoService();
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
    	
    	if (rua.equals("") || numero.equals("") || complemento.equals("") || bairro.equals("") ||
    			cep.equals("") || cidade.equals("") || estado.equals("")) {
    		response.sendRedirect("adicionarEndereco?contatoId="+contatoId+"&usuarioId="+usuarioId);
    	} else {    		
    		contatoService.adicionarEndereco(rua, numero, complemento, bairro, cep, cidade, estado, contatoId, usuarioId);

    		response.sendRedirect("exibirContato?contatoId="+contatoId+"&usuarioId="+usuarioId);
    	}
    }
}
