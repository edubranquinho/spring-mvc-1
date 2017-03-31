package br.com.branquinho.casadocodigo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.branquinho.casadocodigo.daos.ProdutoDAO;
import br.com.branquinho.casadocodigo.model.Produto;
import br.com.branquinho.casadocodigo.model.TipoPreco;
import br.com.branquinho.casadocodigo.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;

	@InitBinder
	public void initBinders(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());
	}

	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {
		ModelAndView mv = new ModelAndView("produtos/form");
		TipoPreco[] tipoPrecos = TipoPreco.values();
		mv.addObject("tipos", tipoPrecos);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView gravar(@Valid Produto produto, BindingResult results, RedirectAttributes redirectAttributes) {
		if (results.hasErrors()) {
			return form(produto);
		}
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
