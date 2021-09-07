package services;

import java.util.List;

import domain.Usuario;
import repositories.UsuarioRepository;

public class UsuarioService {
	
	private UsuarioRepository usuarioRepository = UsuarioRepository.getInstante();	

	public void criar(String name, String email, String senha) {
		Usuario usuario = Usuario.criar(name, email, senha);
		
		usuarioRepository.criar(usuario);
	}
	
	public void alterar(String nome, String email, String usuarioId) {
		Usuario usuario = usuarioRepository.buscarPeloId(usuarioId);
		
		if (usuario == null) {}
		
		usuario.setNome(nome);
		usuario.setEmail(email);
		
		usuarioRepository.salvar(usuario);
	}
	
	public List<Usuario> listar() {
		return usuarioRepository.listar();
	}
	
	public Usuario exibir(String usuarioId) {
		return usuarioRepository.buscarPeloId(usuarioId);
	}
	
	public void deletar(String usuarioId) {
		usuarioRepository.deletarPeloId(usuarioId);
	}
}
