package br.ufc.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.IComunidadeDAO;
import br.ufc.model.CategoriaEnum;
import br.ufc.model.Comunidade;
import br.ufc.util.AulaFileUtil;

@Controller
@Transactional
public class ComunidadeController {

	@Autowired
	private IComunidadeDAO comunidadeDAO;
	
	@Autowired
	private ServletContext context;
		
	@RequestMapping(value="/inserirComunidadeFormulario", method={RequestMethod.GET})
	public String inserirComunidadeFormulario(Model model){//link para o formulário
		model.addAttribute("categorias", Arrays.asList(CategoriaEnum.values()));
		return "comunidades/inserir_comunidade_formulario";
	}
	
	@RequestMapping(value="/inserirComunidade", method={RequestMethod.POST})
	public String inserirComunidade(Comunidade comunidade, 
			@RequestParam(value="image", required=false)MultipartFile image){

		if(image!=null){
			String path = context.getRealPath("/");
			String relativePath = "resources/images/"+comunidade.getNome()+".png";
 			path+= relativePath;
			AulaFileUtil.saveFile(path, image);
			comunidade.setImagem(relativePath);
		}
		comunidadeDAO.inserir(comunidade);
		return "comunidades/inserir_ok";
	}
	
	//LISTAR
		@RequestMapping("/listarComunidade")
		public String listarComunidade(Model model){
			List<Comunidade> comunidades = comunidadeDAO.listar();
			model.addAttribute("comunidades", comunidades);
			return "comunidades/listar_comunidade";
		}	
}
