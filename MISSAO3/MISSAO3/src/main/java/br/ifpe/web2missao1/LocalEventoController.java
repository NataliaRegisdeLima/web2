package br.ifpe.web2missao1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LocalEventoController {

	@Autowired
	private LocalEventoDAO localEventoRep;
	
	@GetMapping("/localEvento")
	public ModelAndView exibirAddLocalEvento() {
		ModelAndView mv = new ModelAndView("localEvento");
		mv.addObject("localEvento", new LocalEvento());
		return mv;
	}
	
	@GetMapping("cadastrarLocalEvento")
	public ModelAndView cadastrarAddLocal(){
		ModelAndView mv = new ModelAndView("cadastrarLocalEvento");
		mv.addObject("localEvento", new LocalEvento());
		return mv;
		}
	@GetMapping("/listaLocalEvento")//envia para a pagina de local cadastrado
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("listaLocalEvento");//envia para a pag.html
		mv.addObject("lista", localEventoRep.findAll());
		return mv;
	}
	//alterar local cadastrado
	@GetMapping("/alterarLocalEvento")
	public ModelAndView alterar( @RequestParam Integer codigo ) {
		ModelAndView mv = new ModelAndView("/cadastrarLocalEvento");
		mv.addObject("localEvento", localEventoRep.getOne(codigo));
		return mv;
		}
	//deletar local cadastrado
	@GetMapping("/removerLocalEvento")
		public ModelAndView remover(@RequestParam Integer codigo){
		localEventoRep.deleteById(codigo);
		return listar();
		}
	@PostMapping("/addLocalEvento")
	public String addLocalEvento(@ModelAttribute LocalEvento localEvento) {
		System.out.println(localEvento);
		this.localEventoRep.save(localEvento);
		return "redirect:/cadastrarLocalEvento";
		}
}
