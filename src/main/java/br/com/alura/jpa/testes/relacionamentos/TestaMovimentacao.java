package br.com.alura.jpa.testes.relacionamentos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dom4j.rule.Mode;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.testes.modelo.TipoMovimentação;

public class TestaMovimentacao {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia(123);
		conta.setNumero(99999);
		conta.setSaldo(800);
		conta.setTitular("Jose Maria");

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setValor(new BigDecimal(100));
		movimentacao.setTipoMovimentacao(TipoMovimentação.SAIDA);
		movimentacao.setConta(conta);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(conta); // Deve-se persistir (tornar managed) o objeto conta antes de ele ser
										// referenciado no persist(movimentacao).
		entityManager.persist(movimentacao);
		entityManager.getTransaction().commit();
		entityManager.close();

	}
}
