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

@Entity(name="FOTOS")
public class Foto {

	@Id
	@Column(name="FOTO_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long fotoId;

	public Long getFotoId() {
		return fotoId;
	}

	public void setFotoId(Long fotoId) {
		this.fotoId = fotoId;
	}
	
	/*MANY_TO_ONE*/
	@ManyToOne(optional=false)
	@JoinColumn(name="USUARIO_ID", referencedColumnName="USUARIO_ID")//referencia a chave primária
	private Usuario usuario;
	/*MANY_TO_ONE*/
	
	/*ONE_TO_MANY*/
	@OneToMany(mappedBy="foto", targetEntity=Comentario.class, fetch=FetchType.EAGER)//tipo de busca
	private Collection<Comentario> comentarios;
	/*ONE_TO_MANY*/
}
