package model.entities;

import java.io.Serializable;

public class Frete implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idFrete;
	private String descricao;
	private Double valor;
	private String nfe;
	private String endereco;
	private Integer numero;
	private Cliente cliente;
	private Funcionario funcionario;
	private Status status;
	
	public Frete() {
		
	}

	public Frete(Integer idFrete, String descricao, Double valor, String nfe, String endereco, Integer numero,
			Cliente cliente, Funcionario funcionario, Status status) {
		this.idFrete = idFrete;
		this.descricao = descricao;
		this.valor = valor;
		this.nfe = nfe;
		this.endereco = endereco;
		this.numero = numero;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.status = status;
	}

	

	public Integer getIdFrete() {
		return idFrete;
	}

	public void setIdFrete(Integer idFrete) {
		this.idFrete = idFrete;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNfe() {
		return nfe;
	}

	public void setNfe(String nfe) {
		this.nfe = nfe;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFrete == null) ? 0 : idFrete.hashCode());
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
		Frete other = (Frete) obj;
		if (idFrete == null) {
			if (other.idFrete != null)
				return false;
		} else if (!idFrete.equals(other.idFrete))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Frete [idFrete=" + idFrete + ", descricao=" + descricao + ", valor=" + valor + ", nfe=" + nfe
				+ ", endereco=" + endereco + ", numero=" + numero + ", cliente=" + cliente + ", funcionario="
				+ funcionario + ", status=" + status + "]";
	}
	
	

}
