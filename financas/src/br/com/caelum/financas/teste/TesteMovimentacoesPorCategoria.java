package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Categoria categoria = new Categoria();
		categoria.setId(1);

		String jqpl = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		Query query = em.createQuery(jqpl);
		query.setParameter("pCategoria", categoria);
		
		
		List<Movimentacao> resultado = query.getResultList();

		for (Movimentacao movimentacao : resultado) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getConta().getId());
		}

		em.getTransaction().commit();
		em.close();
	}
}
