package com.myproject.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "senha")
public class Senha implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="sq_senha", nullable=false)
	private Long id;
	
	@ManyToOne(optional = false, targetEntity = TipoSenha.class)
	@JoinColumn(name = "sq_tipo_senha", referencedColumnName = "sq_tipo_senha", updatable = true )
	private TipoSenha tipoSenha;
	
	@Column(name="cd_senha", nullable=false)
	private String codigoSenha;
	
	@Column(name="dt_geracao", nullable=false)
	private Date dataGeracao;

	public Senha() {
		super();
	}
	
	public Senha(TipoSenha tipoSenha, String codigoSenha, Date dataGeracao) {
		super();
		this.tipoSenha = tipoSenha;
		this.codigoSenha = codigoSenha;
		this.dataGeracao = dataGeracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoSenha getTipoSenha() {
		return tipoSenha;
	}

	public void setTipoSenha(TipoSenha tipoSenha) {
		this.tipoSenha = tipoSenha;
	}

	public String getCodigoSenha() {
		return codigoSenha;
	}

	public void setCodigoSenha(String codigoSenha) {
		this.codigoSenha = codigoSenha;
	}

	public Date getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(Date dataGeracao) {
		this.dataGeracao = dataGeracao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Senha other = (Senha) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Senha [id=" + id + ", codigoSenha=" + codigoSenha + ", dataGeracao=" + dataGeracao + "]";
	}
	
}
