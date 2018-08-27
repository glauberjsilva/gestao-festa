package glauber.io.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import glauber.io.festa.model.Convidado;
import glauber.io.festa.repository.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	@Autowired
	private Convidados convidados;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		modelAndView.addObject(new Convidado());
		return modelAndView;
	}
	
	@PostMapping 
	public ModelAndView salvar(Convidado convidado) {
		this.convidados.save(convidado);
		return new ModelAndView("redirect:/convidados");
	}
	
}
