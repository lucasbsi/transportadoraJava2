package model.entities;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idCliente;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private Integer matriculaCliente;
	
	public Cliente() {
		
	}

	public Cliente(Integer idCliente, String nome, String telefone, String email, String endereco,
			Integer matriculaCliente) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.matriculaCliente = matriculaCliente;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getMatriculaCliente() {
		return matriculaCliente;
	}

	public void setMatriculaCliente(Integer matriculaCliente) {
		this.matriculaCliente = matriculaCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", endereco=" + endereco + ", matriculaCliente=" + matriculaCliente + "]";
	}
	
	
    
}
