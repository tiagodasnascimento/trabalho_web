package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="MENSAGEM")
public class Mensagem {
	
	@Id
	@Column(name="MENSAGEM_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long mensagemId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuario;
	
	@Column(name="TEXTO")
	private String texto;
	
	
	/*MANY_TO_ONE*/
	@ManyToOne(optional=false)
	@JoinColumn(name="FORUM_ID", referencedColumnName="FORUM_ID")//referencia a chave primária
	private Forum forum;
	/*MANY_TO_ONE*/
	
	public Long getMensagemId() {
		return mensagemId;
	}
	public Usuario getUsuario() {
		return this.usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public void setMensagemId(Long mensagemId) {
		this.mensagemId = mensagemId;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	

	
}
