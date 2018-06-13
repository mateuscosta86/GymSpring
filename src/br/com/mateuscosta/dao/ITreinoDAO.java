package br.com.mateuscosta.dao;

import br.com.mateuscosta.model.Treino;

public interface ITreinoDAO {

	Treino getTreino(Long treinoId);

	void salvar(Treino treino);

	void apagar(Treino treino);

}
