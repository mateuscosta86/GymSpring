package br.com.mateuscosta.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mateuscosta.model.Aluno;

@Repository
public class AlunoDAO implements IAlunoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Aluno> GetAlunos() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Aluno> query = currentSession.createQuery("from Aluno", Aluno.class);
		
		List<Aluno> alunos = query.getResultList();
		
		return alunos;
	}

	@Override
	public void salvar(Aluno aluno) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(aluno);		
	}

}
