package br.com.mateuscosta.service;

import br.com.mateuscosta.model.Treino;

public interface ITreinoService {

	Treino getTreino(Long treinoId);

	void salvar(Treino treino);

	void apagar(Treino treino);

}
