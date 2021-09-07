package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import utils.GeradorId;

public class Contato {
	private String id;
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
		this.id = GeradorId.id();
	}
	
	public static Contato criar(String nome, String cpf, String rg, Usuario usuario) {
		return new Contato(nome, cpf, rg, usuario);
	}
	
	public String getId() {
		return id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(id, other.id);
	}
}
