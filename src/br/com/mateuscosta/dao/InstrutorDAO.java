package br.com.mateuscosta.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mateuscosta.model.Aluno;
import br.com.mateuscosta.model.Instrutor;

@Repository
public class InstrutorDAO implements IInstrutorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Instrutor getInstrutor(String cpf) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Instrutor> query = session.createQuery("from Instrutor where cpf=:instrutorCpf", Instrutor.class);
		query.setParameter("instrutorCpf", cpf);
		
		List<Instrutor> instrutor = query.getResultList();		
		return instrutor.isEmpty() ? null : instrutor.get(0);
	}

	@Override
	public List<Aluno> getAlunos(Long id) {
Session session = sessionFactory.getCurrentSession();
		
		Query<Aluno> query = session.createQuery("from Aluno where instrutor_id = :instrutorId", Aluno.class);
		query.setParameter("instrutorId", id);
		
		List<Aluno> alunos = query.getResultList();
		
		return alunos;
	}

	@Override
	public Instrutor getInstrutor(Long instrutorId) {
		
		Session session = sessionFactory.getCurrentSession();		
		Instrutor instrutor = session.get(Instrutor.class, instrutorId);
		
		return instrutor;
	}

}
