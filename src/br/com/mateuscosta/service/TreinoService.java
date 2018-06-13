package br.com.mateuscosta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mateuscosta.dao.ITreinoDAO;
import br.com.mateuscosta.model.Treino;

@Service
public class TreinoService implements ITreinoService {

	@Autowired
	ITreinoDAO treinoDAO;
	
	@Override
	@Transactional
	public Treino getTreino(Long treinoId) {

		Treino treino = treinoDAO.getTreino(treinoId);
		
		return treino;
	}

	@Override
	@Transactional
	public void salvar(Treino treino) {
		
		treinoDAO.salvar(treino);
	}

	@Override
	@Transactional
	public void apagar(Treino treino) {
		
		treinoDAO.apagar(treino);
	}

}
