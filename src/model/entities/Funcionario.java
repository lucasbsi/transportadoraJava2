package model.entities;

import java.io.Serializable;

public class Funcionario extends Usuario implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer idFuncionario;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private Integer idCargo;
	private Integer matriculaFuncionario;
	
	public Funcionario(){
				
	}

	public Funcionario(Integer idFuncionario, String nome, String telefone, String email, String endereco,
			Integer idCargo, Integer matriculaFuncionario) {
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.idCargo = idCargo;
		this.matriculaFuncionario = matriculaFuncionario;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
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

	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public Integer getMatriculaFuncionario() {
		return matriculaFuncionario;
	}

	public void setMatriculaFuncionario(Integer matriculaFuncionario) {
		this.matriculaFuncionario = matriculaFuncionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFuncionario == null) ? 0 : idFuncionario.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (idFuncionario == null) {
			if (other.idFuncionario != null)
				return false;
		} else if (!idFuncionario.equals(other.idFuncionario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", telefone=" + telefone + ", email="
				+ email + ", endereco=" + endereco + ", idCargo=" + idCargo + ", matriculaFuncionario="
				+ matriculaFuncionario + "]";
	}
	
	
}
