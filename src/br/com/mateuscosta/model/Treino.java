package br.com.mateuscosta.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_treinos")
public class Treino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataCriacao;
	
	@OneToMany(mappedBy = "treino",
			   cascade = CascadeType.ALL,
			   orphanRemoval = true,
			   fetch = FetchType.EAGER)
	private List<Exercicio> exercicios;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					      CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	public Treino() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
		
	@Override
	public String toString() {
		return "Treino [id=" + id + ", exercicios=" + exercicios + ", aluno=" + aluno + "]";
	}

	public void addExericio(Exercicio exercicio) {
		if ( exercicios == null ) {
			exercicios = new ArrayList<Exercicio>();
		}
		exercicio.setTreino(this);
		exercicios.add(exercicio);
	}	
}
