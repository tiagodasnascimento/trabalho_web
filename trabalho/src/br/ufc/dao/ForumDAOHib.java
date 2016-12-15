package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufc.model.Forum;

public class ForumDAOHib implements IForumDAO{
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Forum forum) {
		manager.persist(forum);
		
	}

	@Override
	public void alterar(Forum forum) {
		manager.merge(forum);
		
	}

	@Override
	public Forum recuperar(Long id) {
		return manager.find(Forum.class, id);
	}


	@Override
	public List<Forum> listar() {
		String hql = "select f from FORUM as f";
		return manager.createQuery(hql, Forum.class).getResultList();
	}

	@Override
	public void apagar(Long id) {
		Forum c = this.recuperar(id);
		manager.remove(c);
	}
}
