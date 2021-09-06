package services;

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
	
	public void criar(String name, String rg, String cpf, String rua, String numero, String complemento, String bairro, String cep, String cidade, String estado, String usuarioEmail) {
		Usuario usuario = usuarioRepository.buscarPeloEmail(usuarioEmail);
		
		Contato contato = Contato.criar(name, rg, cpf, usuario);

		Endereco endereco = Endereco.criar(rua, numero, complemento, bairro, cep, cidade, estado);
		
		contato.setEnderecos(Arrays.asList(endereco));
		
		contatoRepository.criar(contato);
	}
	
	public Contato exibir(String rg) {
		return contatoRepository.pegarPorRg(rg);
	}
	
	public void alterar(String nome, String rg, String cpf, String contatoRG, String usuarioEmail) {
		Contato contato = contatoRepository.pegarPorRg(contatoRG);
		
		if (contato != null && contato.getUsuario().getEmail().equals(usuarioEmail)) {
			contato.setNome(nome);
			contato.setRg(rg);
			contato.setCpf(cpf);

			contatoRepository.salvar(contato);
		}
	}
	
	public List<Contato> listar(String usuarioEmail) {
		return contatoRepository.pegarPorEmail(usuarioEmail);
	}
	
	public void deletar(String rg, String usuarioEmail) {
		Contato contato = contatoRepository.pegarPorRg(rg);
		
		if (contato != null && contato.getUsuario().getEmail().equals(usuarioEmail)) {
			contatoRepository.deletarPeloRG(rg);
		}
	}
}
