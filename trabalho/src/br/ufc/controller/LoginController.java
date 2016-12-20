package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.dao.IUsuarioDAO;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class LoginController {

	@Autowired
	@Qualifier(value="usuarioDAOHib")
	private IUsuarioDAO usuarioDAO;
	
	@RequestMapping(value="/loginFormulario", method={RequestMethod.GET})
	public String loginFormulario(HttpSession session){
		if(session.getAttribute("usuario_logado") != null){
			return "redirect:menu";
		}
		return "login_formulario";
	}
	
	@RequestMapping(value="/loginFormulario", method={RequestMethod.POST})
	public String loginFormulario(){
		return "login_formulario";
	}
	
	@RequestMapping("/login")
	public String login(Usuario usuario, HttpSession session){
		Usuario u = usuarioDAO.recuperar(usuario.getLogin());
		if(u!=null){
			if(u.getSenha().equals(usuario.getSenha())){
				session.setAttribute("usuario_logado", u);
				return "menu";
			}
		}
		
		return "redirect:loginFormulario";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginFormulario";
	}
}
