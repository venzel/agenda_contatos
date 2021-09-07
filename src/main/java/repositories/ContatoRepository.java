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
		
		Contato contato_tiago_cintia = Contato.criar("Cintia Venzel", "00070162042", "423816147", tiago);
		Contato contato_tiago_pablo = Contato.criar("Pablo Escobar", "55356232020", "377955863", tiago);
		Contato contato_tiago_marcos = Contato.criar("Marcos Palmeiras", "054.090.220-92", "392107351", tiago);
		
		contatos.add(contato_tiago_cintia);
		contatos.add(contato_tiago_pablo);
		contatos.add(contato_tiago_marcos);
		
		Endereco endereco_rita_a = Endereco.criar("Rua 13 de Maio", "214", "n/a", "Centro", "5831212", "Campina Grande", "PB");
		Endereco endereco_rita_b = Endereco.criar("Rua das Jaboranas", "131", "n/a", "Liberdade", "5831212", "Sao Paulo", "SP");
		Endereco endereco_rita_c = Endereco.criar("Rua Pedro II", "34", "n/a", "Bodocongo", "5831212", "Rio de Janeiro", "RJ");
		
		contato_tiago_cintia.setEnderecos(Arrays.asList(endereco_rita_a, endereco_rita_b, endereco_rita_c));
		
		Endereco endereco_pablo_a = Endereco.criar("Rua Peixe Pequeno", "344", "n/a", "Bela Vista", "5831212", "Serrano", "PE");
		Endereco endereco_pablo_b = Endereco.criar("Rua das Caxirolas", "532", "n/a", "Monte Santo", "5831212", "Campina Grande", "PB");
		Endereco endereco_pablo_c = Endereco.criar("Rua Monte Sa", "34", "n/a", "Prata", "5831212", "Sao Bento", "SP");
		
		contato_tiago_pablo.setEnderecos(Arrays.asList(endereco_pablo_a, endereco_pablo_b, endereco_pablo_c));
		
		Endereco endereco_marcos_a = Endereco.criar("Rua Branco Dias", "6212", "n/a", "Remo", "5831212", "Santa Luzia", "PE");
		Endereco endereco_marcos_b = Endereco.criar("Rua Sebastiao Nonato", "33", "n/a", "Braganca", "5831212", "Sao Paulo", "SP");
		Endereco endereco_marcos_c = Endereco.criar("Rua Francisco Pinto", "891", "n/a", "Sergipe", "5831212", "Natal", "RN");
		
		contato_tiago_marcos.setEnderecos(Arrays.asList(endereco_marcos_a, endereco_marcos_b, endereco_marcos_c));
	}
	
	public static ContatoRepository getInstante() {
		if (instance == null) {
			instance = new ContatoRepository();
		}
		
		return instance;
	}
	
	public List<Contato> pegarPorId(String usuarioId) {
		List<Contato> list = new ArrayList<>();
		
		contatos.forEach(e -> {
			if (e.getUsuario().getId().equals(usuarioId)) {
				list.add(e);
			}
		});
		
		return list;
	}
	
	public Contato pegarContatoPorId(String usuarioId) {
		for (Contato c : contatos) {
			if (c.getId().equals(usuarioId)) {
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
			if (c.getId().equals(contato.getId())) {
				c.setNome(contato.getNome());
				c.setRg(contato.getRg());
				c.setCpf(contato.getCpf());
				
				break;
			}
		}
	}
	
	public void deletarPorContatoId(String contatoId) {
		for (Contato c : contatos) {
			if (c.getId().equals(contatoId)) {
				contatos.remove(c);
				break;
			}
		}
	}
	
	public void deletarEnderecoPorId(String enderecoId) {
		List<Endereco> enderecos = new ArrayList<>();
		
		int i = 0;
		
		boolean f = false;
		
		for (Contato c : contatos) {
			for (Endereco e : c.getEnderecos()) {
				if (e.getId().equals(enderecoId)) {
					f = true;
					break;
				}
			}
			
			if (f) break;
			
			i++;
		}
		
		contatos.get(i).getEnderecos().forEach(e -> {
			if (!e.getId().equals(enderecoId)) {
				enderecos.add(e);
			}
		});
		
		contatos.get(i).setEnderecos(enderecos);
	}
}
