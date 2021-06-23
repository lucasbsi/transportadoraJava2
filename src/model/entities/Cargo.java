package model.entities;

import java.io.Serializable;

public class Cargo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer idCargo;
	private String descricao;
	private float salario;
	//private Date dataInicio;
	//private Date dataFim;
	
	public Cargo() {
	}



	public Cargo(Integer idCargo, String descricao, float salario) {
		super();
		this.idCargo = idCargo;
		this.descricao = descricao;
		this.salario = salario;
	}



	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

//	public Date getDataInicio() {
//		return dataInicio;
//	}
//
//	public void setDataInicio(Date dataInicio) {
//		this.dataInicio = dataInicio;
//	}
//
//	public Date getDataFim() {
//		return dataFim;
//	}
//
//	public void setDataFim(Date dataFim) {
//		this.dataFim = dataFim;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCargo == null) ? 0 : idCargo.hashCode());
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
		Cargo other = (Cargo) obj;
		if (idCargo == null) {
			if (other.idCargo != null)
				return false;
		} else if (!idCargo.equals(other.idCargo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cargo [idCargo=" + idCargo + ", descricao=" + descricao + ", salario=" + salario + "]";
		
	//	", dataInicio="
	//	+ dataInicio + ", dataFim=" + dataFim + 
	}
	
	
	
}
