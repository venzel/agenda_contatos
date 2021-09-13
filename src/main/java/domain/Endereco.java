package domain;

import java.util.Objects;

import utils.GeradorId;

public class Endereco {
	private String id;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	
	public Endereco(String rua, String numero, String complemento, String bairro, String cep, String cidade, String estado) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.id = GeradorId.id();
	}
	
	public static Endereco criar(String rua, String numero, String complemento, String bairro, String cep, String cidade, String estado) {
		if (!valido(rua, numero, complemento, bairro, cep, cidade, estado)) {
			return null;
		}
		
		return new Endereco(rua, numero, complemento, bairro, cep, cidade, estado);
	}
	
	public static boolean valido(String rua, String numero, String complemento, String bairro, String cep, String cidade, String estado) {
		if (rua.equals("")) return false;
		if (numero.equals("")) return false;
		if (complemento.equals("")) return false;
		if (bairro.equals("")) return false;
		if (cep.equals("")) return false;
		if (cidade.equals("")) return false;
		if (estado.equals("")) return false;
		
		return true;
	}

	public String getId() {
		return id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
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
		return "Endereco [id=" + id + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado + "]";
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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
}
