package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Contato;
import domain.Endereco;
import domain.Usuario;
import repositories.ContatoRepository;
import repositories.UsuarioRepository;

public class ContatoService {

	private ContatoRepository contatoRepository = ContatoRepository.getInstante();
	
	private UsuarioRepository usuarioRepository = UsuarioRepository.getInstante();
	
	public Contato executarCadastrarContato(String name, String rg, String cpf, String rua, String numero, String complemento, String bairro, String cep, String cidade, String estado, String usuarioId) {
		Usuario usuario = usuarioRepository.buscarPeloId(usuarioId);
		
		Contato contato = Contato.criar(name, rg, cpf, usuario);

		Endereco endereco = Endereco.criar(rua, numero, complemento, bairro, cep, cidade, estado);
		
		contato.setEnderecos(Arrays.asList(endereco));
		
		contatoRepository.criar(contato);
		
		return contato;
	}
	
	public Contato executarExibirContato(String contatoId) {
		return contatoRepository.pegarContatoPorId(contatoId);
	}
	
	public void executarEditarContato(String nome, String rg, String cpf, String contatoId, String usuarioId) {
		Contato contato = contatoRepository.pegarContatoPorId(contatoId);
		
		if (contato != null && contato.getUsuario().getId().equals(usuarioId)) {
			contato.setNome(nome);
			contato.setRg(rg);
			contato.setCpf(cpf);

			contatoRepository.salvar(contato);
		}
	}
	
	public Endereco executarCadastrarEndereco(String rua, String numero, String complemento, String bairro,
			String cep, String cidade, String estado, String contatoId, String usuarioId) {
		List<Endereco> enderecos = new ArrayList<>();
		
		Contato contato = contatoRepository.pegarContatoPorId(contatoId);
		
		contato.getEnderecos().forEach(e -> enderecos.add(e));
		
		Endereco endereco = Endereco.criar(rua, numero, complemento, bairro, cep, cidade, estado);
		
		if (endereco != null) {
			enderecos.add(endereco);
			contato.setEnderecos(enderecos);
		}
		
		return endereco;
	}
	
	public void executarDeletarEndereco(String enderecoId) {
		contatoRepository.deletarEnderecoPorId(enderecoId);
	}
	
	public List<Contato> executarListarContatos(String usuarioId) {
		return contatoRepository.pegarPorId(usuarioId);
	}
	
	public void executarDeletarContato(String contatoId, String usuarioId) {
		Contato contato = contatoRepository.pegarContatoPorId(contatoId);
		
		if (contato != null && contato.getUsuario().getId().equals(usuarioId)) {
			contatoRepository.deletarPorContatoId(contatoId);
		}
	}
}
