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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "tbl_alunos")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(nullable = false, unique= true, length = 11)
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
	
	@OneToMany(mappedBy = "aluno",
			   cascade = CascadeType.ALL)
	private List<Pagamento> pagamentos;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					      CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "instrutor_id")
	private Instrutor instrutor;
	
	@OneToMany(mappedBy = "aluno", 
			   fetch=FetchType.EAGER,
			   cascade = CascadeType.ALL)
	private List<Treino> treinos;
	 
	//Constructor	

	public Aluno(String cpf, String senha, String nome, String sobrenome) {
		
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public Aluno() {
	}

	//Getter and Setters

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

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public List<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}
	
	//Misc

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", cpf=" + cpf + ", senha=" + senha + ", nome=" + nome + ", sobrenome=" + sobrenome
				+ ", dataNascimento=" + dataNascimento + "]";
	}
	
	public void addPagamento(Pagamento pagamento) {
		if ( pagamentos == null ) {
			pagamentos = new ArrayList<Pagamento>();
		}
		
		pagamentos.add(pagamento);
	}
	
	public void addTreino(Treino treino) {
		if ( treinos == null ) {
			treinos = new ArrayList<Treino>();
		}
		
		treinos.add(treino);
	}
	
}