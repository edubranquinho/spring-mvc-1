package br.com.branquinho.casadocodigo.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.branquinho.casadocodigo.model.Produto;

@Repository
@Transactional
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void gravar(Produto produto) {
		entityManager.persist(produto);
	}

}
