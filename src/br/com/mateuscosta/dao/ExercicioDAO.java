package br.com.mateuscosta.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mateuscosta.model.Exercicio;

@Repository
public class ExercicioDAO implements IExercicioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Exercicio getExercicio(Long exercicioId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Exercicio exercicio = session.get(Exercicio.class, exercicioId);
		
		return exercicio;
	}

	@Override
	public void apagarExercicio(Long exerc) {
		Session session = sessionFactory.getCurrentSession();
		Exercicio exercicio = getExercicio(exerc);
		session.remove(exercicio);
		
	}

}
