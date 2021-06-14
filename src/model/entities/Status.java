package model.entities;

import java.io.Serializable;

public class Status implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer idStatus;
	private String descricao;
	
	public Status() {
		
	}

	public Status(Integer idStatus, String descricao) {
		this.idStatus = idStatus;
		this.descricao = descricao;
	}

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idStatus == null) ? 0 : idStatus.hashCode());
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
		Status other = (Status) obj;
		if (idStatus == null) {
			if (other.idStatus != null)
				return false;
		} else if (!idStatus.equals(other.idStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Status [idStatus=" + idStatus + ", descricao=" + descricao + "]";
	}	
}
