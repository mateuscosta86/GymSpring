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
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Aluno> query = session.createQuery("from Aluno", Aluno.class);
		
		List<Aluno> alunos = query.getResultList();
		
		return alunos;
	}

	@Override
	public void salvar(Aluno aluno) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(aluno);		
	}

	@Override
	public Aluno getAluno(Long id) {
		Session session = sessionFactory.getCurrentSession();
		
		Aluno aluno = session.get(Aluno.class, id);
		
		return aluno;
	}

	@Override
	public void apagar(Long id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Aluno where id=:alunoId");
		query.setParameter("alunoId", id);
		
		query.executeUpdate();		
	}

	@Override
	public Aluno getAluno(String cpf) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Aluno> query = session.createQuery("from Aluno where cpf=:alunoCpf", Aluno.class);
		query.setParameter("alunoCpf", cpf);
		
		Aluno aluno = query.getSingleResult();		
		return aluno;
	}

}
