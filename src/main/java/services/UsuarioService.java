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
	
	public void alterar(String email, String nome) {
		Usuario usuario = usuarioRepository.buscarPeloEmail(email);
		
		if (usuario == null) {}
		
		usuario.setNome(nome);
		
		usuarioRepository.salvar(usuario);
	}
	
	public List<Usuario> listar() {
		return usuarioRepository.listar();
	}
	
	public Usuario exibir(String email) {
		return usuarioRepository.buscarPeloEmail(email);
	}
	
	public void deletar(String email) {
		usuarioRepository.deletarPeloEmail(email);
	}
}
