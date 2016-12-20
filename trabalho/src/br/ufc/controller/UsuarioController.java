package br.ufc.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.IAmizadeDAO;
import br.ufc.dao.IComunidadeDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.form.AmizadeCheckboxForm;
import br.ufc.model.Amizade;
import br.ufc.model.Comunidade;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.form.AmizadeCheckboxForm;
import br.ufc.model.Amizade;
import br.ufc.model.Usuario;
import br.ufc.util.AulaFileUtil;


@Controller
@Transactional
public class UsuarioController {
	
	@Autowired
	@Qualifier(value="usuarioDAOHib")
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	@Qualifier(value="amizadeDAOHib")//nome que tá no spring
	private IAmizadeDAO amizadeDAO;

	
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/perfil/{idUsuario}")
	public String perfil(Model model, @PathVariable(value="idUsuario") Long idUsuario){
		Usuario usuario = usuarioDAO.recuperar(idUsuario);
		model.addAttribute("usuario", usuario);
		return "usuarios/perfil";
	}
	
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(){//link para o formulário
		return "usuarios/inserir_usuario_formulario";
	}
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(Usuario usuario, 
			@RequestParam(value="image", required=false)MultipartFile image){

		if(image!=null){
			String path = context.getRealPath("/");
			String relativePath = "resources/images/"+usuario.getLogin()+".png";
 			path+= relativePath;
			AulaFileUtil.saveFile(path, image);
			usuario.setFotoPerfil(relativePath);
		}

		usuarioDAO.inserir(usuario);
		return "usuarios/inserir_ok";
	}
	
	//LISTAR
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model){
		List<Usuario> usuarios = usuarioDAO.listar();
		model.addAttribute("usuarios", usuarios);
		return "usuarios/listar_usuario";
	}

	@RequestMapping("/menu")
	public String Menu(Model model, HttpSession session){//link para o formulário
		return "menu";
	}
	
	@RequestMapping("/listarAmigos")
	public String listarAmigos(Model model, HttpSession session){
		Usuario usuario = (Usuario)session.getAttribute("usuario_logado");
		List<Amizade> amigos =  amizadeDAO.listarAmizadesDeId(usuario.getId());
		model.addAttribute("amigos", amigos);
		return "usuarios/listar_amigos";
	}
	
	public String Menu(){//link para o formulário
		return "menu";
	}
	
	@RequestMapping("/inserirAmizadeFormulario")
	public String inserirAmizadeFormulario(HttpSession session, Model model){
		Usuario usuario = (Usuario)session.getAttribute("usuario_logado");
		List<Usuario> potenciaisAmigos = usuarioDAO.listar();
		potenciaisAmigos.remove(usuario);
		AmizadeCheckboxForm acf = new AmizadeCheckboxForm();
		List<Amizade> minhasAmizades = this.amizadeDAO.listarAmizadesDeId(usuario.getId());
		for(Amizade amizade: minhasAmizades){
			potenciaisAmigos.remove(amizade.getUsuarioAlvo());
		}
		model.addAttribute("usuario", usuario);
		model.addAttribute("potenciais_amigos", potenciaisAmigos);
		model.addAttribute("amizade", acf);
		
		return "usuarios/inserir_amizade_formulario";
	}
	
	@RequestMapping("/inserirAmizade")
	public String inserirAmizade(HttpSession session, AmizadeCheckboxForm amizades){
		
		Usuario amigoFonte = (Usuario)session.getAttribute("usuario_logado");
		
		for(Long id:amizades.getAmigos()){
			Usuario amigoAlvo = usuarioDAO.recuperar(id);
			Amizade amizade = new Amizade();
			amizade.setUsuarioFonte(amigoFonte);
			amizade.setUsuarioAlvo(amigoAlvo);
			amizadeDAO.inserir(amizade);
			
		}
		
		return "redirect:inserirAmizadeFormulario";
				
	}
	

	//ALTERAR
	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long id, Model model){
		Usuario u = usuarioDAO.recuperar(id);
		model.addAttribute("usuario", u);
		return "usuarios/alterar_usuario_formulario";
	}
	
	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario usuario, @RequestParam(value="image", required=false) MultipartFile image){
		if(image!=null){
			String path = context.getRealPath("/");
			String relativePath = "resources/images/"+usuario.getLogin()+".png";
 			path+= relativePath;
			AulaFileUtil.saveFile(path, image);
			usuario.setFotoPerfil(relativePath);
		}
		usuarioDAO.alterar(usuario);
		return "redirect:menu";
	}
}
