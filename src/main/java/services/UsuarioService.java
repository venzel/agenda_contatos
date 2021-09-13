package services;

import java.util.List;

import domain.Usuario;
import repositories.UsuarioRepository;

public class UsuarioService {
	
	private UsuarioRepository usuarioRepository = UsuarioRepository.getInstante();	

	public Usuario executarCadastrarUsuario(String name, String email, String senha) {
		Usuario usuario = Usuario.criar(name, email, senha);
		
		usuarioRepository.criar(usuario);
		
		return usuario;
	}
	
	public void executarEditarUsuario(String nome, String email, String usuarioId) {
		Usuario usuario = usuarioRepository.buscarPeloId(usuarioId);
		
		if (usuario == null) {}
		
		usuario.setNome(nome);
		usuario.setEmail(email);
		
		usuarioRepository.salvar(usuario);
	}
	
	public List<Usuario> executarListarUsuarios() {
		return usuarioRepository.listar();
	}
	
	public Usuario executarPegarUsuarioPorId(String usuarioId) {
		return usuarioRepository.buscarPeloId(usuarioId);
	}
	
	public void executarDeletarUsuario(String usuarioId) {
		usuarioRepository.deletarPeloId(usuarioId);
	}
}
