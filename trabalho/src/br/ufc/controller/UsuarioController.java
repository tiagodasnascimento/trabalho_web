package br.ufc.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.IAmizadeDAO;
import br.ufc.dao.IComunidadeDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.form.AmizadeCheckboxForm;
import br.ufc.model.Amizade;
import br.ufc.model.Comunidade;
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
	
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(){//link para o formulário
		return "usuarios/inserir_usuario_formulario";
	}
	
	
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(Usuario usuario, 
			@RequestParam(value="image", required=false)MultipartFile image){

		if(image!=null){
			String path = context.getRealPath("/");
			path+="resources/images/"+usuario.getLogin()+".png";
			AulaFileUtil.saveFile(path, image);
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
	public String Menu(){//link para o formulário
		return "menu";
	}
	
	@RequestMapping("/inserirAmizadeFormulario")
	public String inserirAmizadeFormulario(HttpSession session, Model model){
		Usuario usuario = (Usuario)session.getAttribute("usuario_logado");
		List<Usuario> potenciaisAmigos = usuarioDAO.listar();
		potenciaisAmigos.remove(usuario);
		System.out.println(usuario.toString());
		
		AmizadeCheckboxForm acf = new AmizadeCheckboxForm();
		List<Amizade> minhasAmizades = this.amizadeDAO.listarAmizadesDeId(usuario.getId());
		if(minhasAmizades!=null && minhasAmizades.size()>0){
			//Long[] vetorIds = new Long[minhasAmizades.size()];
			//int i = 0;
			for(Amizade amizade:minhasAmizades){
				Long amigoId = amizade.getUsuarioAlvo().getId();
				Usuario amigoTemp = new Usuario();
				amigoTemp.setId(amigoId);
				potenciaisAmigos.remove(amizade.getUsuarioAlvo());
				
				
				//vetorIds[i] = amigoId;
				//i++;
			}
			
			//acf.setAmigos(vetorIds);
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

}
