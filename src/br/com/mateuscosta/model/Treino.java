package br.com.mateuscosta.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_treinos")
public class Treino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "treino")
	private List<Exercicio> exercicios;
	
	@ManyToOne
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

	public List<Exercicio> getTrabalhos() {
		return exercicios;
	}

	public void setTrabalhos(List<Exercicio> trabalhos) {
		this.exercicios = trabalhos;
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

	public void addExericios(Exercicio exercicio) {
		if ( exercicios == null ) {
			exercicios = new ArrayList<Exercicio>();
		}
		
		exercicios.add(exercicio);
	}	
}
