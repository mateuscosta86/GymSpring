package br.com.mateuscosta.dao;

import java.util.List;

import br.com.mateuscosta.model.Aluno;

public interface IAlunoDAO {
	
	public List<Aluno> GetAlunos();

	public void salvar(Aluno aluno);

}
