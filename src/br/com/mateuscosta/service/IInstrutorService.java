package br.com.mateuscosta.service;

import java.util.List;

import br.com.mateuscosta.model.Aluno;
import br.com.mateuscosta.model.Instrutor;

public interface IInstrutorService {

	Instrutor getInstrutor(String cpf);

	List<Aluno> getAlunos(Long id);

	Instrutor getInstrutor(Long instrutorId);
	
	
}
