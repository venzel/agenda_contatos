package services;

import domain.Usuario;
import repositories.UsuarioRepository;

public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;	
	
	public UsuarioService() {
		this.usuarioRepository = new UsuarioRepository();
	}

	public Usuario criar(String name, Integer idade) {
		Usuario usuario = new Usuario();
		usuarioRepository.salvar(usuario);
		return usuario;
	}
	
	public Usuario atualizar() {
		return null;
	}
	
	public Usuario salvar() {
		return null;
	}
	
	public Usuario exibir() {
		return null;
	}
	
	public Usuario deletar() {
		return null;
	}
}
