package br.com.mateuscosta.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mateuscosta.helpers.Helpers;
import br.com.mateuscosta.model.Aluno;
import br.com.mateuscosta.model.Instrutor;
import br.com.mateuscosta.model.viewModel.LoginData;
import br.com.mateuscosta.service.IAlunoService;
import br.com.mateuscosta.service.IInstrutorService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	IAlunoService alunoService;
	
	@Autowired
	IInstrutorService instrutorService;
	
	@GetMapping("/")
	public String MostrarPaginaLogin(Model model, HttpServletRequest request) {
				
		if (Helpers.ChecaVarivavelSessao(request, "logadoComo")) {
			
			String logado = request.getSession().getAttribute("logadoComo").toString();
			
			if(logado.equals("aluno") ) {
				return "redirect:/aluno/areaAluno";
			}
			else if (logado.equals("professor") ) {
				return "redirect:/instrutor/relacaoAlunos";
			}
			else {

				LoginData dadosLogin = new LoginData();
				
				model.addAttribute("dadosLogin", dadosLogin);
				
				return "login";
			}
		}
		else {
			LoginData dadosLogin = new LoginData();
			
			model.addAttribute("dadosLogin", dadosLogin);
			
			return "login";
		}				
	}
	
	@PostMapping("/efetuarLogin")
	public String EfetuarLogin(@ModelAttribute("dadosLogin") LoginData dadosLogin, Model model, HttpServletRequest request ) {
				
		if (dadosLogin.getPapel() == null) {
			model.addAttribute("papelNaoSelecionado", true);
			return "login";
		}
		
		if (dadosLogin.getCpf().equals("") || dadosLogin.getSenha().equals("")) {
			model.addAttribute("camposNaoPreenchidos", true);
			return "login";
		}
		
		if (dadosLogin.getPapel().equals("aluno")) {
			
			Aluno aluno = alunoService.getAluno(dadosLogin.getCpf());
			
			if( aluno != null ) {
				if(dadosLogin.getSenha().equals(aluno.getSenha())) {
					request.getSession().setAttribute("usuario", aluno.getId());
					request.getSession().setAttribute("logadoComo", dadosLogin.getPapel());
					
					return "redirect:/aluno/areaAluno";
				}
				else {
					model.addAttribute("loginFailed", true);
					return "login";
				}
								
			}
			else {
				model.addAttribute("loginFailed", true);
				return "login";
			}
			
			
		}
		else if ( dadosLogin.getPapel().equals("professor") ) {
			
			Instrutor instrutor = instrutorService.getInstrutor(dadosLogin.getCpf());
			
			if( instrutor != null ) {
				if(dadosLogin.getSenha().equals(instrutor.getSenha())) {

					request.getSession().setAttribute("usuario", instrutor.getId());
					request.getSession().setAttribute("logadoComo", dadosLogin.getPapel());
					
					return "redirect:/instrutor/relacaoAlunos";
				}
				else {
					model.addAttribute("loginFailed", true);
					return "login";
				}								
			}
			else {
				model.addAttribute("loginFailed", true);
				return "login";
			}
			
		}
		else {
			return "login";
		}
	}
	
	@GetMapping("/checarLogin")
	public String ChecarLogin(Model model) {
					
		return "checarLogin";
	}
	
	@GetMapping("/fazerLogout")
	public String Logout(HttpServletRequest request) {
		
		request.getSession().removeAttribute("aSeremRemovidos");
		request.getSession().removeAttribute("logadoComo");
		request.getSession().removeAttribute("usurario");
		request.getSession().removeAttribute("exericios");
		request.getSession().removeAttribute("alunoId");
		request.getSession().removeAttribute("treinoId");
		
		return "redirect:/";
	}
}
