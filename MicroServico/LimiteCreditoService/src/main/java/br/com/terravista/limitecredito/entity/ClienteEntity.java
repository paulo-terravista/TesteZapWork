package br.com.terravista.limitecredito.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="CLIENTE")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteEntity implements Serializable {

	private static final long serialVersionUID = 2685833776581336854L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private BigDecimal limiteCredito;
	private BigDecimal taxaJuro;
	private String risco;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}
	
	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	public BigDecimal getTaxaJuro() {
		return taxaJuro;
	}
	
	public void setTaxaJuro(BigDecimal taxaJuro) {
		this.taxaJuro = taxaJuro;
	}
	
	public String getRisco() {
		return risco;
	}
	
	public void setRisco(String risco) {
		this.risco = risco;
	}
	

}
