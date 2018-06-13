package br.com.mateuscosta.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import br.com.mateuscosta.model.Treino;

@Repository
public class TreinoDAO implements ITreinoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Treino getTreino(Long treinoId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Treino> query = session.createQuery("from Treino where id=:treinoId", Treino.class);
		query.setParameter("treinoId", treinoId);
		
		Treino treino = query.getSingleResult();
		
		return treino;
	}

	@Override
	public void salvar(Treino treino) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(treino);
	}

	@Override
	public void apagar(Treino treino) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.remove(treino);
	}

}
