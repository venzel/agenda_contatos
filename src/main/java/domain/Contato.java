package domain;

import java.util.ArrayList;
import java.util.List;

public class Contato {
	private String nome;;
	private String cpf;
	private String rg;
	private Usuario usuario;
	private List<Endereco> enderecos = new ArrayList<>();
	
	public Contato(String nome, String cpf, String rg, Usuario usuario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.usuario = usuario;
	}
	
	public static Contato criar(String nome, String cpf, String rg, Usuario usuario) {
		return new Contato(nome, cpf, rg, usuario);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", usuario=" + usuario + ", enderecos="
				+ enderecos + "]";
	}
}
