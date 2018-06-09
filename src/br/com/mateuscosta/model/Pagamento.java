package br.com.mateuscosta.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_pagamentos")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date dataLancamento;
	
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;
	
	private double valor;
	
	private boolean isPago;	
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					      CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	public Pagamento() {
	}

	public Pagamento(Date dataLancamento, Date dataPagamento, double valor, boolean isPago, Aluno aluno) {
		
		this.dataLancamento = dataLancamento;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.isPago = isPago;
		this.aluno = aluno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isPago() {
		return isPago;
	}

	public void setPago(boolean isPago) {
		this.isPago = isPago;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", dataLancamento=" + dataLancamento + ", dataPagamento=" + dataPagamento
				+ ", valor=" + valor + ", isPago=" + isPago + ", aluno=" + aluno + "]";
	}
			
}