package br.com.mateuscosta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mateuscosta.model.Aluno;
import br.com.mateuscosta.service.IInstrutorService;

@Controller
@RequestMapping("/instrutor")
public class InstrutorController {
	
	@Autowired
	IInstrutorService instrutorService;
	
	@GetMapping("/relacaoAlunos")
	public String ListarAlunos(HttpServletRequest request, Model model) {
		
		if ( request.getSession().getAttribute("logadoComo").equals("professor")) {
			Long id = Long.parseLong(request.getSession().getAttribute("usuario").toString());
			List<Aluno> alunos = instrutorService.getAlunos(id);
			
			model.addAttribute("alunos", alunos);
			
			return "areaInstrutor";
		}
		else {
			return "redirect:/";
		}
		
		
	}

}
