package com.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brewer.model.Cerveja;

@Controller
public class CervejasController {
	
	@RequestMapping("/cervejas/novo")
	public String novo(Cerveja cerveja){
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes atributes){
		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Erro no formulario");
			return novo(cerveja);
		}
			
		System.out.println("Cadastrar SKU : " + cerveja.getSku() + " Nome " +cerveja.getNome() + " Descricao: " + cerveja.getDescricao()  );
		atributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		return "redirect:/cervejas/novo";
		
		/* sem redirecionar
		 	System.out.println("Cadastrar SKU : " + cerveja.getSku() + " Nome " +cerveja.getNome() );
		model.addAttribute("mensagem", "Cerveja salva com sucesso!");
		//return "redirect:/cervejas/novo";
		return "cerveja/CadastroCerveja";
		 */
		
	}
	
	@RequestMapping("/cervejas/cadastro")
	public String cadastro() {
		return "cerveja/cadastro-produto";
	}
	

}
