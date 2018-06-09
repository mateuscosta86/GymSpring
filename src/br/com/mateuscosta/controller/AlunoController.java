package br.com.mateuscosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mateuscosta.model.Aluno;
import br.com.mateuscosta.service.IAlunoService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	IAlunoService alunoService;	
	
	@GetMapping("/listar")
	public String ListarAlunos(Model model) {
		
		List<Aluno> alunos = alunoService.getAlunos();
		
		model.addAttribute("alunos", alunos);
		
		return "alunoList";
	}	
	
	@GetMapping("/cadastrarAluno")
	public String CadastrarAluno(Model model) {
		Aluno aluno = new Aluno();
		
		model.addAttribute("aluno",	aluno);
		
		return "alunoForm";
	}
	
	@PostMapping("/salvarAluno")
	public String SalvarAluno(@ModelAttribute("aluno") Aluno aluno) {
		
		alunoService.salvarAluno(aluno);
		
		return "redirect:/aluno/listar"; 
	}
}
