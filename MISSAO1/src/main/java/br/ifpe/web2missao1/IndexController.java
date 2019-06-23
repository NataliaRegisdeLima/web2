package br.ifpe.web2missao1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("cadastrar")
	public String index(Model model) {
		model.addAttribute("mensagem","CADASTRAR USUÁRIO");
		return "cadastrar";
	}
	
	@GetMapping("alterar")
	public String index2(Model model) {
		model.addAttribute("mensagem","ALTERAR USUÁRIO");
		return "alterar";	
	}
	
	@GetMapping("deletar")
	public String index3(Model model) {
		model.addAttribute("mensagem","DELETAR USUÁRIO");
		return "deletar";
	}
	
	@GetMapping("salvar")
	public String index4(Model model) {
		model.addAttribute("mensagem","SALVAR USUÁRIO");
		return "salvar";
	}
	
	@GetMapping("validar")
	public String index5(Model model) {
		model.addAttribute("mensagem","VALIDAR SENHA");
		return "validar";
	}
	@GetMapping("/ind")
	public String index6() {

		return "index";
	}
}
