package br.com.alura.jpa.testes.basicos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManagerFactory.close();
		
	}
}
