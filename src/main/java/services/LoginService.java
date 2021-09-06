package services;

import java.util.List;

import domain.Usuario;
import repositories.UsuarioRepository;

public class LoginService {
	
	private UsuarioRepository usuarioRepository;

	public LoginService() {
		this.usuarioRepository = UsuarioRepository.getInstante();
	}

	private Usuario pegarUsuario(List<Usuario> usuarios, String email, String senha) {
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
				return u;
			}
		}
		
		return null;
	}
	
	public Usuario executar(String email, String senha) {	
		List<Usuario> usuarios = usuarioRepository.listar();
		
		Usuario usuario = pegarUsuario(usuarios, email, senha);
		
		return usuario;
	}
}