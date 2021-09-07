package repositories;

import java.util.ArrayList;
import java.util.List;

import domain.Usuario;

public class UsuarioRepository {
	
	private static UsuarioRepository instance;
	
	private List<Usuario> usuarios = new ArrayList<>();

	private UsuarioRepository() {}
		
	{
		Usuario tiago = Usuario.criar("Tiago Rizzo", "tiago@gmail.com", "tiago");
		Usuario rita = Usuario.criar("Rita de Cassia", "rita@gmail.com", "rita");
		Usuario valdir = Usuario.criar("Valdir Pires", "valdir@gmail.com", "valdir");
		Usuario sandro = Usuario.criar("Sandro Dias", "sandro@gmail.com", "sandro");
		Usuario valdo = Usuario.criar("Valdo Costa", "valdo@gmail.com", "valdo");
		
		usuarios.add(tiago);
		usuarios.add(rita);
		usuarios.add(valdir);
		usuarios.add(sandro);
		usuarios.add(valdo);
	}
	
	public static UsuarioRepository getInstante() {
		if (instance == null) {
			instance = new UsuarioRepository();
		}
		
		return instance;
	}
	
	public int total() {
		return usuarios.size();
	}
	
	public Usuario buscarPeloEmail(String email) {
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}
		
		return null;
	}
	
	public Usuario buscarPeloId(String usuarioId) {
		for (Usuario u : usuarios) {
			if (u.getId().equals(usuarioId)) {
				return u;
			}
		}
		
		return null;
	}
	
	public void criar(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public void salvar(Usuario usuario) {
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(usuario.getEmail())) {
				u.setNome(usuario.getNome());
				
				break;
			}
		}
	}
	
	public List<Usuario> listar() {
		return usuarios;
	}
	
	public void deletarPeloId(String usuarioId) {
		for (Usuario u : usuarios) {
			if (u.getId().equals(usuarioId)) {
				usuarios.remove(u);
				break;
			}
		}
	}
}
