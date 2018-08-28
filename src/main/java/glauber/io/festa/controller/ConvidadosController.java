package glauber.io.festa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import glauber.io.festa.model.Convidado;
import glauber.io.festa.repository.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	@Autowired
	private Convidados convidados;
	
	@GetMapping
	public ModelAndView listar(Convidado convidado) {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		modelAndView.addObject(convidado);
		return modelAndView;
	}
	
	@PostMapping() 
	public ModelAndView salvar(@Valid Convidado convidado, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return listar(convidado);
		}
		
		this.convidados.save(convidado);
		redirectAttributes.addFlashAttribute("mensagem", "Convidado salvo com sucesso");
		return new ModelAndView("redirect:/convidados");
	}
}
