package br.com.mateuscosta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mateuscosta.dao.IInstrutorDAO;
import br.com.mateuscosta.model.Aluno;
import br.com.mateuscosta.model.Instrutor;


@Service
public class InstrutorService implements IInstrutorService {

	@Autowired
	IInstrutorDAO instrutorDAO;
	
	@Override
	@Transactional
	public Instrutor getInstrutor(String cpf) {
		
		Instrutor instrutor = instrutorDAO.getInstrutor(cpf);
		
		return instrutor;
	}

	@Override
	@Transactional
	public List<Aluno> getAlunos(Long id) {
		
		List<Aluno> alunos = instrutorDAO.getAlunos(id); 
		return alunos;
	}

	@Override
	@Transactional
	public Instrutor getInstrutor(Long instrutorId) {

		Instrutor instrutor = instrutorDAO.getInstrutor(instrutorId);
		
		return instrutor;
	}

}
