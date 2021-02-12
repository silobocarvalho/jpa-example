package br.com.alura.jpa.testes.basicos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoConta {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Conta contaDoBanco = entityManager.find(Conta.class, 1L); // Busca pelo ID 1 do tipo long.
		contaDoBanco.setSaldo(150.0);

		entityManager.getTransaction().begin();

		entityManager.persist(contaDoBanco);
		
		contaDoBanco.setSaldo(10.0);

		entityManager.getTransaction().commit();

	}
}
