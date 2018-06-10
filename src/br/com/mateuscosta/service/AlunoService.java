package br.com.mateuscosta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mateuscosta.dao.IAlunoDAO;
import br.com.mateuscosta.model.Aluno;

@Service
public class AlunoService implements IAlunoService {

	@Autowired
	private IAlunoDAO alunoDAO;
	
	@Override
	@Transactional
	public List<Aluno> getAlunos() {
				
		return alunoDAO.GetAlunos();
	}

	@Override
	@Transactional
	public void salvarAluno(Aluno aluno) {
		
		alunoDAO.salvar(aluno);
		
	}

	@Override
	@Transactional
	public Aluno getAluno(Long id) {
		
		Aluno aluno = alunoDAO.getAluno(id);
		
		return aluno;
	}

	@Override
	@Transactional
	public void apagarAluno(Long id) {
		
		alunoDAO.apagar(id);		
	}

	@Override
	@Transactional
	public Aluno getAluno(String cpf) {
		
		Aluno aluno = alunoDAO.getAluno(cpf);
		
		return aluno;
	}
}
