package br.com.alura.jpa.testes.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL2 {
public static void main(String[] args) {
	
	
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();

	Conta conta = new Conta();
	conta.setId(2L);
	
	String queryJPQL = "select m from Movimentacao m where m.conta = :pConta";
	//Query query = em.createQuery(queryJPQL);
	TypedQuery<Movimentacao> query = em.createQuery(queryJPQL, Movimentacao.class);
	query.setParameter("pConta", conta);

	List<Movimentacao> movimentacoes = query.getResultList();
	
	for (Movimentacao movimentacao : movimentacoes) {
		System.out.println("Descricao: " + movimentacao.getDescricao());
		System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
	}
}
}

