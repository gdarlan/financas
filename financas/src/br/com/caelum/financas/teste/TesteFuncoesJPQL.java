package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(2);

		String jqpl = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo"
				+ " order by m.valor desc";

		Query query = em.createQuery(jqpl);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		Double media = (Double) query.getSingleResult();

		System.out.println("A media é: " + media);

		em.getTransaction().commit();
		em.close();
	}
}
