package br.ufc.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="FORUM")
public class Forum {

	@Id
	@Column(name="FORUM_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long forumId;
	
	@Column(name="TITULO")
	private String titulo;

	@Column(name="DESCRICAO")
	private String descricao;
	
	/*MANY_TO_ONE*/
	@ManyToOne(optional=false)
	@JoinColumn(name="COMUNIDADE_ID", referencedColumnName="COMUNIDADE_ID")//referencia a chave primária
	private Comunidade comunidade;
	/*MANY_TO_ONE*/
	
	/*ONE_TO_MANY*/
	@OneToMany(mappedBy="forum", targetEntity=Mensagem.class, fetch=FetchType.EAGER)//tipo de busca
	private Collection<Mensagem> mensagens;
	/*ONE_TO_MANY*/
	
	
	
	public Long getForumId() {
		return forumId;
	}
	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Comunidade getComunidade() {
		return comunidade;
	}
	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}
	public Collection<Mensagem> getMensagens() {
		return mensagens;
	}
	public void setMensagens(Collection<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
}
