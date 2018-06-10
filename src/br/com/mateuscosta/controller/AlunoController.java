package br.com.mateuscosta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.mateuscosta.helpers.Helpers;
import br.com.mateuscosta.model.Aluno;
import br.com.mateuscosta.model.Instrutor;
import br.com.mateuscosta.service.IAlunoService;
import br.com.mateuscosta.service.IInstrutorService;
import br.com.mateuscosta.service.InstrutorService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	IAlunoService alunoService;
	
	@Autowired
	IInstrutorService instrutorService;
	
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
	public String SalvarAluno(@ModelAttribute("aluno") Aluno aluno, HttpServletRequest request) {
		
		Long instrutorId = Long.parseLong(request.getSession().getAttribute("usuario").toString());
		Instrutor instrutor = instrutorService.getInstrutor(instrutorId);
		
		aluno.setInstrutor(instrutor);		
		
		alunoService.salvarAluno(aluno);
		
		return "redirect:/instrutor/relacaoAlunos"; 
	}
	
	@GetMapping("/atualizarAluno")
	public String AtualizarAluno(@RequestParam("alunoId") Long id, Model model) {
		
		Aluno aluno = alunoService.getAluno(id);
		
		model.addAttribute("aluno", aluno);
		
		return "alunoForm";
	}
	
	@GetMapping("/apagarAluno")
	public String apagarAluno(@RequestParam("alunoId") Long id) {
		
		alunoService.apagarAluno(id);
		
		return "redirect:/aluno/listar";
	}
	
	@GetMapping("/areaAluno")
	public String AcessoAluno(HttpServletRequest request, Model model) {
		
		if (Helpers.ChecaVarivavelSessao(request, "logadoComo") == false) {
			return "redirect:/";
		}
		
		Long id = Long.parseLong(request.getSession().getAttribute("usuario").toString());
		
		Aluno aluno = alunoService.getAluno(id);
		
		model.addAttribute("aluno", aluno);
		
		return "areaAluno";
	}
}
