package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufc.model.Categoria;
import br.ufc.model.Usuario;

public class CategoriaDAOHib implements ICategoriaDAO{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Categoria categoria) {
		manager.persist(categoria);
		
	}

	@Override
	public void alterar(Categoria categoria) {
		manager.merge(categoria);
		
	}

	@Override
	public Categoria recuperar(Long id) {
		return manager.find(Categoria.class, id);
	}

	@Override
	public List<Categoria> listar() {
		String hql = "select c from CATEGORIA as c";
		return manager.createQuery(hql, Categoria.class).getResultList();
	}

	@Override
	public void apagar(Long id) {
		Categoria c = this.recuperar(id);
		manager.remove(c);
		
	}
	
	

}
