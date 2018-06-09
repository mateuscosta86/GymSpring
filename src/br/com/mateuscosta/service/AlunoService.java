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

}
