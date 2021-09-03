package domain;

public class Usuario {
	private String idcon;
	private String email;
	private Integer senha;
	private String nome;
	private Integer cpf;
	private Integer rg;
	private String rua;
	private Integer nr;
	private Integer complemento;
	private String bairro;
	private Integer cep;
	private String cidade;
	private String estado;
	private Boolean isAdmin;

	public Usuario() {
		super();
	}

	public Usuario(String email, Integer senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public Usuario(String nome, Integer cpf, Integer rg, String rua, Integer nr, Integer complemento, String bairro,
			Integer cep, String cidade, String estado) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.rua = rua;
		this.nr = nr;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getIdcon() {
		return idcon;
	}
	
	public void setIsAdmin() {
		this.isAdmin = true;
	}

	public Boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
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

	public Integer getNr() {
		return nr;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
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

}
