package services;

import java.util.List;

import domain.Usuario;
import repositories.UsuarioRepository;

public class LoginService {
	
	private UsuarioRepository usuarioRepository;

	public LoginService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	private Boolean validar() {
		return true;
	}
	
	public void executar() {
		
		Boolean ehValido = validar();
		
		List<Usuario> usuarios = usuarioRepository.pegarTodosUsuarios();
	}
}