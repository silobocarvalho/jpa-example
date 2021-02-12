package br.com.alura.jpa.testes.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {
public static void main(String[] args) {
	
	String queryJPQL = "select m from Movimentacao m where m.conta.id = 2";
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();
	
	Query query = em.createQuery(queryJPQL);
	List<Movimentacao> movimentacoes = query.getResultList();
	
	for (Movimentacao movimentacao : movimentacoes) {
		System.out.println("Descricao: " + movimentacao.getDescricao());
		System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
	}
}
}

