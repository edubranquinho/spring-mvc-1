package br.com.branquinho.casadocodigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.branquinho.casadocodigo.daos.ProdutoDAO;
import br.com.branquinho.casadocodigo.model.Produto;

@Controller
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;

	@RequestMapping("produtos/form")
	public String form() {
		return "produtos/form";
	}

	@RequestMapping(value = "produtos", method = RequestMethod.POST)
	public String gravar(Produto produto) {
		System.out.println(produto);
		produtoDAO.gravar(produto);
		return "produtos/ok";
	}

}
