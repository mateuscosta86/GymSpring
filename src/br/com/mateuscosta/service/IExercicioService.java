package br.com.mateuscosta.service;

import br.com.mateuscosta.model.Exercicio;

public interface IExercicioService {

	Exercicio getExercicio(Long exercicioId);

	void apagarExercicio(Long exerc);

}
