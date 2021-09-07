package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ContatoService;

@WebServlet("/cadastrarContato")
public class CadastrarContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContatoService contatoService;
           
    public CadastrarContatoController() {
		this.contatoService = new ContatoService();
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
    	
    	if (nome.equals("") || rg.equals("") || cpf.equals("") || rua.equals("") ||
    			numero.equals("") || complemento.equals("") || bairro.equals("") ||
    				cep.equals("") || cidade.equals("") || estado.equals("")) {
    		response.sendRedirect("adicionarContato?usuarioId="+usuarioId);
    	} else {

    		contatoService.criar(nome, rg, cpf, rua, numero, complemento, bairro, cep, cidade, estado, usuarioId);

    		response.sendRedirect("contatos?usuarioId="+usuarioId);
    	}
    }
}
