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
import br.com.mateuscosta.model.Treino;
import br.com.mateuscosta.service.IAlunoService;
import br.com.mateuscosta.service.IInstrutorService;
import br.com.mateuscosta.service.ITreinoService;


@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	IAlunoService alunoService;
	
	@Autowired
	IInstrutorService instrutorService;
	
	@Autowired
	ITreinoService treinoService;
	
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
		
		Aluno aluno = alunoService.getAluno(id);
		alunoService.apagarAluno(aluno);
		// alunoService.apagarAluno(id);
		
		return "redirect:/instrutor/relacaoAlunos";
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
	
	@GetMapping("/visualizarTreino")
	public String VisualizarTreino(@RequestParam("treinoId") Long treinoId, @RequestParam("alunoId") Long alunoId, Model model) {
		
		Treino treino = treinoService.getTreino(treinoId);
		Aluno aluno = alunoService.getAluno(alunoId);
		model.addAttribute("treino", treino);
		model.addAttribute("aluno", aluno);
		
		return "detalheTreino";
	}
}
