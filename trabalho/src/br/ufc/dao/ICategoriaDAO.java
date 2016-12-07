package br.ufc.dao;

import java.util.List;

import br.ufc.model.Categoria;
import br.ufc.model.Comunidade;

public interface ICategoriaDAO {

	public void inserir(Categoria categoria);
	public void alterar(Categoria categoria);
	public Categoria recuperar(Long id);
	public List<Categoria> listar();
	public void apagar(Long id);
}
