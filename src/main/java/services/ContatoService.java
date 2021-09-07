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
	
	public void criar(String name, String rg, String cpf, String rua, String numero, String complemento, String bairro, String cep, String cidade, String estado, String usuarioId) {
		Usuario usuario = usuarioRepository.buscarPeloId(usuarioId);
		
		Contato contato = Contato.criar(name, rg, cpf, usuario);

		Endereco endereco = Endereco.criar(rua, numero, complemento, bairro, cep, cidade, estado);
		
		contato.setEnderecos(Arrays.asList(endereco));
		
		contatoRepository.criar(contato);
	}
	
	public Contato exibir(String contatoId) {
		return contatoRepository.pegarContatoPorId(contatoId);
	}
	
	public void alterar(String nome, String rg, String cpf, String contatoId, String usuarioId) {
		Contato contato = contatoRepository.pegarContatoPorId(contatoId);
		
		if (contato != null && contato.getUsuario().getId().equals(usuarioId)) {
			contato.setNome(nome);
			contato.setRg(rg);
			contato.setCpf(cpf);

			contatoRepository.salvar(contato);
		}
	}
	
	public Contato adicionarEndereco(String rua, String numero, String complemento, String bairro,
			String cep, String cidade, String estado, String contatoId, String usuarioId) {
		List<Endereco> enderecos = new ArrayList<>();
		
		Contato contato = contatoRepository.pegarContatoPorId(contatoId);
		
		contato.getEnderecos().forEach(e -> enderecos.add(e));
		
		if (contato != null && contato.getUsuario().getId().equals(usuarioId)) {
			Endereco endereco = Endereco.criar(rua, numero, complemento, bairro, cep, cidade, estado);
			
			enderecos.add(endereco);
			
			contato.setEnderecos(enderecos);
		}
		
		return contato;
	}
	
	public void deletarEndereco(String enderecoId) {
		contatoRepository.deletarEnderecoPorId(enderecoId);
	}
	
	public List<Contato> listar(String usuarioId) {
		return contatoRepository.pegarPorId(usuarioId);
	}
	
	public void deletar(String contatoId, String usuarioId) {
		Contato contato = contatoRepository.pegarContatoPorId(contatoId);
		
		if (contato != null && contato.getUsuario().getId().equals(usuarioId)) {
			contatoRepository.deletarPorContatoId(contatoId);
		}
	}
}
