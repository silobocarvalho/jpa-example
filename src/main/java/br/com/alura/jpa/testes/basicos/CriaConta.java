package br.com.alura.jpa.testes.basicos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Sid");
		conta.setNumero(123499);
		conta.setAgencia(123);
		
		//Deve-se iniciar e enviar a transaction para que os dados sejam persistidos no banco.
		entityManager.getTransaction().begin();
		
		entityManager.persist(conta);
		
		entityManager.getTransaction().commit();
		
	}

}
