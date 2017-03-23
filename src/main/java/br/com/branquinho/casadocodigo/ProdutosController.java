package br.com.branquinho.casadocodigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.branquinho.casadocodigo.daos.ProdutoDAO;
import br.com.branquinho.casadocodigo.model.Produto;
import br.com.branquinho.casadocodigo.model.TipoPreco;

@Controller
@RequestMapping("produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;

	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("produtos/form");
		TipoPreco[] tipoPrecos = TipoPreco.values();
		mv.addObject("tipos", tipoPrecos);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes) {
		System.out.println(produto);
		produtoDAO.gravar(produto);
		redirectAttributes.addFlashAttribute("mensagem", "Produto salvo com sucesso");
		return new ModelAndView("redirect:produtos");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("produtos/lista");
		mv.addObject("produtos", produtoDAO.listar());
		return mv;
	}

}
