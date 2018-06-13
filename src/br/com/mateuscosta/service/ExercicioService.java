package br.com.mateuscosta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mateuscosta.dao.IExercicioDAO;
import br.com.mateuscosta.model.Exercicio;

@Service
public class ExercicioService implements IExercicioService {

	@Autowired
	private IExercicioDAO exercicioDAO;

	@Override
	@Transactional
	public Exercicio getExercicio(Long exercicioId) {
		
		Exercicio exercicio = exercicioDAO.getExercicio(exercicioId);
		
		return exercicio;
	}

	@Override
	@Transactional
	public void apagarExercicio(Long exerc) {
		exercicioDAO.apagarExercicio(exerc);
		
	}


}
