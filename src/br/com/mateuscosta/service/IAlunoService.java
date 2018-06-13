package br.com.mateuscosta.service;

import java.util.List;

import br.com.mateuscosta.model.Aluno;

public interface IAlunoService {
	
	List<Aluno> getAlunos();

	void salvarAluno(Aluno aluno);

	Aluno getAluno(Long id);

	void apagarAluno(Long id);

	Aluno getAluno(String cpf);

	void apagarAluno(Aluno aluno);
}
