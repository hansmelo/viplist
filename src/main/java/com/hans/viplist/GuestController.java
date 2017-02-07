package com.hans.viplist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping("listavip")
	public String listaConvidados(Model model) {
		Iterable<Convidado> guests = repository.findAll();
		model.addAttribute("guests", guests);

		return "listaconvidados";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {

		Convidado newGuest = new Convidado(nome, email, telefone);
		repository.save(newGuest);

		Iterable<Convidado> guests = repository.findAll();
		model.addAttribute("guests", guests);
		return "listaconvidados";
	}
}
