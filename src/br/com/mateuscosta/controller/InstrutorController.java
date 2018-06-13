package br.com.mateuscosta.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
import br.com.mateuscosta.model.Exercicio;
import br.com.mateuscosta.model.Instrutor;
import br.com.mateuscosta.model.Treino;
import br.com.mateuscosta.service.IAlunoService;
import br.com.mateuscosta.service.IExercicioService;
import br.com.mateuscosta.service.IInstrutorService;
import br.com.mateuscosta.service.ITreinoService;

@Controller
@RequestMapping("/instrutor")
public class InstrutorController {
	
	@Autowired
	IInstrutorService instrutorService;
	
	@Autowired
	IAlunoService alunoService;

	@Autowired
	private ITreinoService treinoService;

	@Autowired
	private IExercicioService exercicioService;
	
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
	
	@GetMapping("/mostrarListaTreinos")
	public String AtualizarTreino(@RequestParam("alunoId") Long id, Model model) {
		
		Aluno aluno = alunoService.getAluno(id);
		
		System.out.println("Treinos:");
		System.out.println(aluno.getTreinos().toString());
		
		model.addAttribute("aluno", aluno);
		
		return "areaTreinos";
	}
	
	@GetMapping("/cadastrarTreino")
	public String CadastrarTreino(@RequestParam("alunoId") Long id, Model model, HttpServletRequest request) {
			
		
		request.getSession().setAttribute("exercicios", new ArrayList<Exercicio>());
		request.getSession().setAttribute("aSeremRemovido", new ArrayList<Integer>());
		request.getSession().setAttribute("alunoId", id);
		Exercicio tempExec = new Exercicio();
		model.addAttribute("exercicio", tempExec);
	 	
		return "treinoForm";
	
	}
	
	@GetMapping("/gerenciarTreino")
	public String GerenciarTreino(@RequestParam("alunoId") Long alunoId, @RequestParam("treinoId") Long treinoId, Model model, HttpServletRequest request) {
		
		Treino treino = treinoService.getTreino(treinoId);
						
		request.getSession().setAttribute("exercicios", treino.getExercicios());
		request.getSession().setAttribute("aSeremRemovidos", new ArrayList<Integer>());
		request.getSession().setAttribute("alunoId", alunoId);
		request.getSession().setAttribute("treinoId", treinoId);
		Exercicio tempExec = new Exercicio();
		model.addAttribute("exercicio", tempExec);
	 	
		return "treinoForm";
	
	}
	
	@PostMapping("/cadastrarTreino")
	public String AdicionarExericio(@ModelAttribute("exercico") Exercicio exercicio, Model model, HttpServletRequest request) {
		
		List<Exercicio> exercicios = (List<Exercicio>) request.getSession().getAttribute("exercicios");
		exercicios.add(exercicio);
		
		Exercicio tempExec = new Exercicio();
		model.addAttribute("exercicio", tempExec);
			 	
		return "treinoForm";
	}
	
	@GetMapping("/apagarExercicio")
	public String ApagarExercicio(@RequestParam("exercicioIndex") int index, Model model, HttpServletRequest request) {
		
		List<Long> aSeremRemovidos = (List<Long>) request.getSession().getAttribute("aSeremRemovidos");
		List<Exercicio> exercicios = (List<Exercicio>) request.getSession().getAttribute("exercicios");
		if( exercicios.get(index).getId() != null ) {

			aSeremRemovidos.add(exercicios.get(index).getId());
		}		
		exercicios.remove(index);
		
		Exercicio tempExec = new Exercicio();
		model.addAttribute("exercicio", tempExec);
				
		return "treinoForm";
	}
	
	@GetMapping("/salvarTreino")
	public String SalvarTreino(@RequestParam("alunoId") Long id, @RequestParam("treinoId") Long treinoId, Model model, HttpServletRequest request) {
		
		Aluno aluno = alunoService.getAluno(id);
		Treino treino = new Treino();
		
		if(treinoId == null) {			
			treino.setDataCriacao(new Date());			
			treino.setAluno(aluno);
			aluno.addTreino(treino);
			alunoService.salvarAluno(aluno);
		}		
		else {
			treino = treinoService.getTreino(treinoId);
		}	
		
		if(treino.getExercicios() != null) {
			
			List<Long> aSeremDeletados = (List<Long>) request.getSession().getAttribute("aSeremRemovidos");
					
			for( Long exerc : aSeremDeletados) {
				Exercicio exercicio = exercicioService.getExercicio(exerc);			
				int index = 0;
				for( Exercicio ex : treino.getExercicios()) {
					if (ex.getId() != exercicio.getId()) {
						index++;
					}	
					else {
						break;
					}
				}
				treino.getExercicios().remove(index);
			}
		}		
		
		List<Exercicio> exercicios = (List<Exercicio>) request.getSession().getAttribute("exercicios");
		
		for( Exercicio exerc : exercicios) {
			if ( exerc.getId() == null ) {
				treino.addExericio(exerc);
			}			
		}		
		
		treinoService.salvar(treino);
		
		request.getSession().setAttribute("aSeremRemovidos", null);
		request.getSession().setAttribute("exericios", null);
		request.getSession().setAttribute("alunoId", null);
		request.getSession().setAttribute("treinoId", null);
				
		return "redirect:/instrutor/mostrarListaTreinos?alunoId=" + id;
	}

	@GetMapping("apagarTreino")
	public String ApagarTreino(@RequestParam("alunoId") Long id, @RequestParam("treinoId") Long treinoId) {
		
		Treino treino = treinoService.getTreino(treinoId);
		
		treinoService.apagar(treino);
		
		return "redirect:/instrutor/mostrarListaTreinos?alunoId=" + id;
	}
}
