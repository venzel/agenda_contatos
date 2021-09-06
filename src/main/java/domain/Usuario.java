package domain;

import java.util.Objects;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private Boolean ehAdmin;
	private Integer cpf;
	private Integer rg;
	private String rua;
	private Integer numero;
	private Integer complemento;
	private String bairro;
	private Integer cep;
	private String cidade;
	private String estado;

	public Usuario() {
		super();
	}

	public Usuario(String nome, String email, String senha, Boolean ehAdmin) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ehAdmin = ehAdmin;
	}

	public Usuario(String nome, String email, Integer cpf, Integer rg, String rua, Integer numero, Integer complemento, String bairro,
			Integer cep, String cidade, String estado) {
		super();
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public static Usuario criar(String nome, String email, String senha, Boolean ehAdmin) {
		return new Usuario(nome, email, senha, ehAdmin);
	}
	
	public void setAdmin() {
		this.ehAdmin = true;
	}

	public Boolean getAdmin() {
		return this.ehAdmin;
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

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getnumero() {
		return numero;
	}

	public void setnumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getComplemento() {
		return complemento;
	}

	public void setComplemento(Integer complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", senha=" + senha + ", nome=" + nome + ", cpf=" + cpf
				+ ", rg=" + rg + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro
				+ ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado + ", ehAdmin=" + ehAdmin + "]";
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