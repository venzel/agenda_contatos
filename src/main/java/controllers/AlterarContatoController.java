package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ContatoService;

@WebServlet("/alterarContato")
public class AlterarContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContatoService contatoService;
           
    public AlterarContatoController() {
		this.contatoService = new ContatoService();
	}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String contatoRG = request.getParameter("contatoRG");
    	String usuarioEmail = request.getParameter("usuarioEmail");
    	
    	String nome = request.getParameter("nome");
    	String rg = request.getParameter("rg");
    	String cpf = request.getParameter("cpf");

    	contatoService.alterar(nome, rg, cpf, contatoRG, usuarioEmail);
    	
    	response.sendRedirect("contatos?usuarioEmail="+usuarioEmail);
    }
}