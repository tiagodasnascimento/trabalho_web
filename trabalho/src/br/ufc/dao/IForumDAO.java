package br.ufc.dao;

import java.util.List;

import br.ufc.model.Forum;

public interface IForumDAO {
	public void inserir(Forum forum);
	public void alterar(Forum forum);
	public Forum recuperar(Long id);
	public List<Forum> listar();
	public void apagar(Long id);
}

