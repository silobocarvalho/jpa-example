package br.com.alura.jpa.testes.basicos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TesteDeEstados {
public static void main(String[] args) {
	//Verificar se a sincronização é feita de forma automática somente ao usar o persist().
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	Conta conta = new Conta();
	conta.setTitular("Fantasma");
	conta.setNumero(1234977);
	conta.setAgencia(123);
	
	entityManager.getTransaction().begin();
	
	entityManager.persist(conta);
	
	conta.setSaldo(700.0); // O dado não foi persistido.
	

	//E se colocar dentro da transaction e depois alterar?

	
	entityManager.getTransaction().commit(); // Foi persistido o valor de 700 que foi iniciado na transação anterior.
	
	conta.setSaldo(500.0); // O dado não foi persistido.
	
}
}
