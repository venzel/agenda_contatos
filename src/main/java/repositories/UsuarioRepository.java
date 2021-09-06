package repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Usuario;

public class UsuarioRepository {
	
	private static UsuarioRepository instance;
	
	private List<Usuario> usuarios = new ArrayList<Usuario>(
		Arrays.asList(
				Usuario.criar("tiago", "tiago@gmail.com", "tiago", true),
				Usuario.criar("rita", "rita@gmail.com", "rita", false),
				Usuario.criar("valdir", "valdir@gmail.com", "valdir", false),
				Usuario.criar("sandro", "sandro@gmail.com", "sandro", false),
				Usuario.criar("valdo", "valdo@gmail.com", "valdo", false)));
	
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
	
	public void deletarPeloEmail(String email) {
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email)) {
				usuarios.remove(u);
				break;
			}
		}
	}
}
