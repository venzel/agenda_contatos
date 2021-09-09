package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import utils.GeradorId;

public class Usuario {
	private String id;
	private String nome;
	private String email;
	private String senha;
	private List<Contato> contatos;

	public Usuario() {
		super();
		this.id = GeradorId.id();
	}

	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.id = GeradorId.id();
		this.contatos = new ArrayList<>();
	}

	public static Usuario criar(String nome, String email, String senha) {
		return new Usuario(nome, email, senha);
	}
	
	public String getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email);
	}
}