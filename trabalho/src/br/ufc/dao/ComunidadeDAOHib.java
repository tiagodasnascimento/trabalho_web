package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufc.model.Comunidade;
import br.ufc.model.Usuario;

public class ComunidadeDAOHib implements IComunidadeDAO{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Comunidade comunidade) {
		manager.persist(comunidade);
		
	}

	@Override
	public void alterar(Comunidade comunidade) {
		manager.merge(comunidade);
		
	}

	@Override
	public Comunidade recuperar(Long id) {
		return manager.find(Comunidade.class, id);
	}


	@Override
	public List<Comunidade> listar() {
		String hql = "select c from COMUNIDADE as c";
		return manager.createQuery(hql, Comunidade.class).getResultList();
	}

	@Override
	public void apagar(Long id) {
		Comunidade c = this.recuperar(id);
		manager.remove(c);
		
	}

}
