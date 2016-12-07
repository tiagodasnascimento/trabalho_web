package br.ufc.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="COMUNIDADE")
public class Comunidade {
	
	
	@Id
	@Column(name="COMUNIDADE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long comunidadeId;
	@Column(name="NOME")
	private String nome;
	
	/*MANY_TO_MANY*/
	@ManyToMany
	@JoinTable(name="USUARIO_COMUNIDADE",
			joinColumns=@JoinColumn(name="COMUNIDADE_ID",referencedColumnName="COMUNIDADE_ID"),
			inverseJoinColumns=@JoinColumn(name="USUARIO_ID", referencedColumnName="USUARIO_ID"))
	private List<Usuario> usuarios;
	/*MANY_TO_MANY*/
	
	
	/*ONE_TO_MANY*/
	@OneToMany(mappedBy="comunidade", targetEntity=Forum.class, fetch=FetchType.EAGER)//tipo de busca
	private Collection<Forum> foruns;
	/*ONE_TO_MANY*/
	
	/*MANY_TO_ONE*/
	@ManyToOne(optional=false)
	@JoinColumn(name="CATEGORIA_ID", referencedColumnName="CATEGORIA_ID")//referencia a chave primária
	private Categoria categoria;
	/*MANY_TO_ONE*/
	
	public Long getId() {
		return comunidadeId;
	}
	public void setId(Long id) {
		this.comunidadeId = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
