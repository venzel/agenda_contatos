package repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Contato;
import domain.Endereco;
import domain.Usuario;
	
public class ContatoRepository {
	private static ContatoRepository instance;
	
	private UsuarioRepository usuarioRepository = UsuarioRepository.getInstante();
	
	private List<Contato> contatos = new ArrayList<>();
	
	private ContatoRepository() {}
	
	{
		Usuario tiago = usuarioRepository.buscarPeloEmail("tiago@gmail.com");
		
		Contato contato_tiago_cintia = Contato.criar("Cintia", "00070162042", "423816147", tiago);
		Contato contato_tiago_pablo = Contato.criar("Pablo", "55356232020", "377955863", tiago);
		Contato contato_tiago_marcos = Contato.criar("Marcos", "054.090.220-92", "392107351", tiago);
		
		contatos.add(contato_tiago_cintia);
		contatos.add(contato_tiago_pablo);
		contatos.add(contato_tiago_marcos);
		
		Endereco endereco_rita_a = Endereco.criar("Rua 13 de Maio", "214", "n/a", "Centro", "5831212", "Campina Grande", "pb");
		Endereco endereco_rita_b = Endereco.criar("Rua das Jaboranas", "131", "n/a", "Liberdade", "5831212", "Campina Grande", "pb");
		Endereco endereco_rita_c = Endereco.criar("Rua Pedro II", "34", "n/a", "Bodocongo", "5831212", "Campina Grande", "pb");
		
		contato_tiago_cintia.setEnderecos(Arrays.asList(endereco_rita_a, endereco_rita_b, endereco_rita_c));
		
		Endereco endereco_pablo_a = Endereco.criar("Rua 13 de Maio", "214", "n/a", "Centro", "5831212", "Campina Grande", "pb");
		Endereco endereco_pablo_b = Endereco.criar("Rua das Jaboranas", "131", "n/a", "Liberdade", "5831212", "Campina Grande", "pb");
		Endereco endereco_pablo_c = Endereco.criar("Rua Pedro II", "34", "n/a", "Bodocongo", "5831212", "Campina Grande", "pb");
		
		contato_tiago_pablo.setEnderecos(Arrays.asList(endereco_pablo_a, endereco_pablo_b, endereco_pablo_c));
		
		Endereco endereco_marcos_a = Endereco.criar("Rua 13 de Maio", "214", "n/a", "Centro", "5831212", "Campina Grande", "pb");
		Endereco endereco_marcos_b = Endereco.criar("Rua das Jaboranas", "131", "n/a", "Liberdade", "5831212", "Campina Grande", "pb");
		Endereco endereco_marcos_c = Endereco.criar("Rua Pedro II", "34", "n/a", "Bodocongo", "5831212", "Campina Grande", "pb");
		
		contato_tiago_marcos.setEnderecos(Arrays.asList(endereco_marcos_a, endereco_marcos_b, endereco_marcos_c));
	}
	
	public static ContatoRepository getInstante() {
		if (instance == null) {
			instance = new ContatoRepository();
		}
		
		return instance;
	}
	
	public List<Contato> pegarPorEmail(String email) {
		List<Contato> list = new ArrayList<>();
		
		contatos.forEach(e -> {
			if (e.getUsuario().getEmail().equals(email)) {
				list.add(e);
			}
		});
		
		return list;
	}
	
	public Contato pegarPorRg(String rg) {
		for (Contato c : contatos) {
			if (c.getRg().equals(rg)) {
				return c;
			}
		}
		
		return null;
	}

	public void criar(Contato Contato) {
		contatos.add(Contato);
	}
	
	public void salvar(Contato contato) {
		for (Contato c : contatos) {
			if (c.getRg().equals(contato.getRg())) {
				c.setNome(contato.getNome());
				c.setRg(contato.getRg());
				c.setCpf(contato.getCpf());
				
				break;
			}
		}
	}
	
	public void deletarPeloRG(String rg) {
		for (Contato c : contatos) {
			if (c.getRg().equals(rg)) {
				contatos.remove(c);
				break;
			}
		}
	}
}
