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
    	String usuarioEmail = request.getParameter("usuarioEmail");
    	
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

    	contatoService.criar(nome, rg, cpf, rua, numero, complemento, bairro, cep, cidade, estado, usuarioEmail);

    	response.sendRedirect("contatos?usuarioEmail="+usuarioEmail);
    }
}
