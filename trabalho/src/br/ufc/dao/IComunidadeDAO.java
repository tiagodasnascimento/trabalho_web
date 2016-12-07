package br.ufc.dao;

import java.util.List;

import br.ufc.model.Comunidade;

public interface IComunidadeDAO {
	
	public void inserir(Comunidade comunidade);
	public void alterar(Comunidade comunidade);
	public Comunidade recuperar(Long id);
	public List<Comunidade> listar();
	public void apagar(Long id);


}
