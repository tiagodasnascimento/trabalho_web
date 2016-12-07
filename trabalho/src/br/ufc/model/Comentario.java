package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="COMENTARIOS")
public class Comentario {

	@Id
	@Column(name="COMENTARIO_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long comentarioId;
	
	/*MANY_TO_ONE*/
	@ManyToOne(optional=false)
	@JoinColumn(name="FOTO_ID", referencedColumnName="FOTO_ID")//referencia a chave primária
	private Foto foto;
	/*MANY_TO_ONE*/
}
