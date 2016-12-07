package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="MENSAGEM")
public class Mensagem {
	
	@Id
	@Column(name="MENSAGEM_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long mensagemId;
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
