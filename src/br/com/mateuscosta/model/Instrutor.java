package br.com.mateuscosta.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "tbl_instrutores")
public class Instrutor{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(nullable = false, unique= true, length = 50)
	private String cpf;
	
	@Column(nullable = false, length = 10)
	private String senha;
	
	@Column(nullable = false, length = 50)
	private String nome;
	
	@Column(nullable = false, length = 50)
	private String sobrenome;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Embedded
	private Endereco endereco;
	
	@OneToMany(mappedBy = "instrutor", 
			   fetch=FetchType.EAGER,
			   cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					      CascadeType.DETACH, CascadeType.REFRESH})
	private List<Aluno> alunos;
	
	//Constructor		
	
	public Instrutor(String cpf, String senha, String nome, String sobrenome) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public Instrutor() {
	}

	//Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	//Misc
	
	public void addAluno(Aluno aluno) {
		
		if ( alunos == null ) {
			alunos = new ArrayList<Aluno>();
		}
		
		alunos.add(aluno);
		
		aluno.setInstrutor(this);
	}

	@Override
	public String toString() {
		return "Instrutor [id=" + id + ", cpf=" + cpf + ", senha=" + senha + ", nome=" + nome + ", sobrenome="
				+ sobrenome + ", endereco=" + endereco + "]";
	}	
}