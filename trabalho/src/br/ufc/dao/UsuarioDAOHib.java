package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ufc.model.Usuario;

public class UsuarioDAOHib implements IUsuarioDAO{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Usuario usuario) {
		manager.persist(usuario);
		
	}

	@Override
	public void alterar(Usuario usuario) {
		manager.merge(usuario);
		
	}

	@Override
	public Usuario recuperar(Long id) {
		return manager.find(Usuario.class, id);
	}

	@Override
	public Usuario recuperar(String login) {
		
		
		String hql = "select u from USUARIO as u "
				+ "where u.login = :var_login";
		Query query = manager.createQuery(hql, Usuario.class);
		query.setParameter("var_login", login);
		
		List<Usuario> usuarios = query.getResultList();
		if(usuarios!=null && usuarios.size()>0){
			return usuarios.get(0);
		}
		
		
		return null;
	}

	@Override
	public List<Usuario> listar() {
		String hql = "select u from USUARIO as u";
		return manager.createQuery(hql, Usuario.class).getResultList();
	}

	@Override
	public void apagar(Long id) {
		Usuario u = this.recuperar(id);
		manager.remove(u);
		
	}

}
