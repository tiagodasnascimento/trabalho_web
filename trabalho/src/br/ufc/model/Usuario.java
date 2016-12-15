package br.ufc.model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="USUARIO")
public class Usuario {
	
	@Id
	@Column(name="USUARIO_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="NOME")
	private String nome;
	@Column(name="SOBRENOME")
	private String sobrenome;
	@Column(name="IDADE")
	private Integer idade;
	@Column(name="EMAIL")
	private String email;
	@Column(name="LOGIN")
	private String login;
	@Column(name="SENHA")
	private String senha;
	@Column(name="FOTO_PERFIL")
	private String fotoPerfil;
	
	/*MANY-TO-MANY*/
	@ManyToMany(mappedBy="usuarios", fetch=FetchType.LAZY)	
	private List<Comunidade> comunidades;
	/*MANY-TO-MANY*/
	
	/*ONE_TO_MANY*/
	@OneToMany(mappedBy="usuario", targetEntity=Foto.class, fetch=FetchType.EAGER)//tipo de busca
	private Collection<Foto> fotos;
	/*ONE_TO_MANY*/
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public Collection<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(Collection<Foto> fotos) {
		this.fotos = fotos;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		System.out.println(senha);
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(senha.getBytes(StandardCharsets.UTF_8));
		this.senha = String.format("%064x", new BigInteger(1, md.digest()));
		System.out.println(this.senha);
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public List<Comunidade> getComunidades() {
		return comunidades;
	}
	
	public void setComunidades(List<Comunidade> comunidades) {
		this.comunidades = comunidades;
	}
	public String getFotoPerfil() {
		return fotoPerfil;
	}
	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

}
