package repositories;

import java.util.ArrayList;
import java.util.List;

import domain.Usuario;

public class UsuarioRepository {
	
	private static UsuarioRepository instance;
	
	private List<Usuario> usuarios = new ArrayList<>();

	private UsuarioRepository() {}
		
	{
		Usuario tiago = Usuario.criar("tiago", "tiago@gmail.com", "tiago");
		Usuario rita = Usuario.criar("rita", "rita@gmail.com", "rita");
		Usuario valdir = Usuario.criar("valdir", "valdir@gmail.com", "valdir");
		Usuario sandro = Usuario.criar("sandro", "sandro@gmail.com", "sandro");
		Usuario valdo = Usuario.criar("valdo", "valdo@gmail.com", "valdo");
		
//		Endereco endereco_rita = Endereco.criar("Rua 13 de maio", "214", "n/a", "Centro", "5831212", "Campina Grande", "pb");
//		Endereco endereco_valdir = Endereco.criar("Rua das jaboranas", "131", "n/a", "Liberdade", "5831212", "Campina Grande", "pb");
//		Endereco endereco_sandro = Endereco.criar("Rua Pedro II", "34", "n/a", "Bodocongo", "5831212", "Campina Grande", "pb");
//		Endereco endereco_valdo = Endereco.criar("Av. Floriano peixoto", "41", "n/a", "Malvinas", "5831212", "Campina Grande", "pb");
//		
//		rita.setEnderecos(Arrays.asList(endereco_rita));
//		valdir.setEnderecos(Arrays.asList(endereco_valdir));
//		sandro.setEnderecos(Arrays.asList(endereco_sandro));
//		valdo.setEnderecos(Arrays.asList(endereco_valdo));
		
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
