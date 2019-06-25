package br.ifpe.web2missao1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	//conexao com o banco para eventos
	@Autowired
	private EventoDAO eventoRep;
	
	@GetMapping("/evento")
	public ModelAndView exibirAddEvento() {
		ModelAndView mv = new ModelAndView("evento");
		mv.addObject("evento", new Evento());
		return mv;
	}
	//mostrar a lista dos eventos cadastrados
	@GetMapping("/listarEvento")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/evento");
		mv.addObject("lista", eventoRep.findAll());
		return mv;
		}
	//para alterar o evento ja cadastrado
	@GetMapping("/exibirEvento")
	public ModelAndView exibir( @RequestParam Integer codigo ) {
		ModelAndView mv = new ModelAndView("/cadastrar");
		mv.addObject("evento", eventoRep.getOne(codigo));
		return mv;
		}
	//deletar evento cadastrado
	@GetMapping("/removerEvento")
		public ModelAndView remover(@RequestParam Integer codigo){
		eventoRep.deleteById(codigo);
		return listar();
		}
	//para salvar no bd o que foi cadastrado
	@PostMapping("/addEvento")
	public String addEvento(@ModelAttribute Evento evento) {
		System.out.println(evento);
		this.eventoRep.save(evento);
		return "redirect:/cadastrar";
		}
	//aparece a pagina de fomulário do cadastro
	@GetMapping("cadastrar")
	public ModelAndView cadastrarAddEvento(){
		ModelAndView mv = new ModelAndView("cadastrar");
		mv.addObject("evento", new Evento());
		return mv;
		}
	
	@GetMapping("/ind")
	public String index6() {
		return "index";
	}
	
}
