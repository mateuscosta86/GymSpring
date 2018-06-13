package br.com.mateuscosta.dao;

import java.util.List;

import br.com.mateuscosta.model.Aluno;

public interface IAlunoDAO {
	
	public List<Aluno> GetAlunos();

	public void salvar(Aluno aluno);

	public Aluno getAluno(Long id);

	public void apagar(Long id);

	public Aluno getAluno(String cpf);

	public void apagar(Aluno aluno);

}
