package br.ufc.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="CATEGORIA")
public class Categoria {

	@Id
	@Column(name="CATEGORIA_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoriaId;
	@Column(name="NOME")
	private String nome;
	
	/*ONE_TO_MANY*/
	@OneToMany(mappedBy="categoria", targetEntity=Comunidade.class, fetch=FetchType.EAGER)//tipo de busca
	private Collection<Comunidade> comunidades;
	/*ONE_TO_MANY*/
	
	public Long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
