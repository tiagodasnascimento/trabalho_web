package br.ufc.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	@Column(name="IMAGEM")
	private String imagem;
	
	@Enumerated(EnumType.STRING)
	private CategoriaEnum categoria;
	
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
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Long getComunidadeId() {
		return comunidadeId;
	}
	public void setComunidadeId(Long comunidadeId) {
		this.comunidadeId = comunidadeId;
	}
	public CategoriaEnum getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaEnum categoria) {
		this.categoria = categoria;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Collection<Forum> getForuns() {
		return foruns;
	}
	public void setForuns(Collection<Forum> foruns) {
		this.foruns = foruns;
	}
	
	
}
