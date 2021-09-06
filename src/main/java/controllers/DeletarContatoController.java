package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ContatoService;

@WebServlet("/deletarContato")
public class DeletarContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContatoService contatoService;
           
    public DeletarContatoController() {
		this.contatoService = new ContatoService();
	}
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String usuarioEmail = request.getParameter("usuarioEmail");
    	
    	String rg = request.getParameter("rg");
    	
    	contatoService.deletar(rg, usuarioEmail);
    	
    	response.sendRedirect("contatos?usuarioEmail="+usuarioEmail);
    }
}