package br.com.alura.jpa.testes.relacionamentos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.testes.modelo.TipoMovimentação;

public class TestaRelacionamentosMovimentacaoCategoria {
public static void main(String[] args) {
	Categoria categoria1 = new Categoria();
	categoria1.setNome("Viagem");
	
	Categoria categoria2 = new Categoria();
	categoria2.setNome("Negocios");
	
	Conta conta = new Conta();
	conta.setId(4L);
	
	Movimentacao movimentacao1 = new Movimentacao();
	movimentacao1.setDescricao("Viagem a Fortaleza");
	movimentacao1.setTipoMovimentacao(TipoMovimentação.SAIDA);
	movimentacao1.setData(LocalDateTime.now());
	movimentacao1.setValor(new BigDecimal(150));
	movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));
	movimentacao1.setConta(conta);
	
	Movimentacao movimentacao2 = new Movimentacao();
	movimentacao2.setDescricao("Viagem a Quixada");
	movimentacao2.setTipoMovimentacao(TipoMovimentação.SAIDA);
	movimentacao2.setData(LocalDateTime.now());
	movimentacao2.setValor(new BigDecimal(220));
	movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));
	movimentacao2.setConta(conta);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	em.persist(categoria1); //Precisa transformar os objetos de Transient (nao possuem id no banco) para Managed
	em.persist(categoria2);
	em.persist(movimentacao1);
	em.persist(movimentacao2);
	em.getTransaction().commit();
	em.close();
	
}
}
