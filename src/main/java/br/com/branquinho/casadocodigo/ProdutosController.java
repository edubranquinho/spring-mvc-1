package br.com.branquinho.casadocodigo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.branquinho.casadocodigo.model.Produto;

@Controller
public class ProdutosController {

	@RequestMapping("produtos/form")
	public String form() {
		return "produtos/form";
	}

	@RequestMapping(value = "produtos", method = RequestMethod.POST)
	public String grava(Produto produto) {
		System.out.println(produto);
		return "produtos/ok";
	}

}
