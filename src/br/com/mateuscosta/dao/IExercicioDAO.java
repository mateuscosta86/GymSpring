package br.com.mateuscosta.dao;

import br.com.mateuscosta.model.Exercicio;

public interface IExercicioDAO {

	Exercicio getExercicio(Long exercicioId);

	void apagarExercicio(Long exerc);

}
