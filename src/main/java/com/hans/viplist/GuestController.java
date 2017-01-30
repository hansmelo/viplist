package com.hans.viplist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hans.viplist.model.Convidado;
import com.hans.viplist.repository.ConvidadoRepository;

@Controller
public class GuestController {

	@Autowired
	private ConvidadoRepository repository;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		Iterable<Convidado> guests = repository.findAll();
		model.addAttribute("guests", guests);
		
		return "listaconvidados";
	}
}
