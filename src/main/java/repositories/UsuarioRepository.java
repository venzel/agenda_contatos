package repositories;

import java.util.ArrayList;
import java.util.List;

import domain.Usuario;

public class UsuarioRepository {
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	public void criar(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public void salvar(Usuario usuario) {}
	
	public Usuario pegarPeloId() {
		return null;
	}
	
	public void deletarPeloId(Integer id) {}
	
	public List<Usuario> pegarTodosUsuarios() {
		return usuarios;
	}
}
