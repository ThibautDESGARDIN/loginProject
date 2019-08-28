package fr.formation.inti.login;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.formation.inti.entities.Compte;
import fr.formation.inti.utils.HibernateUtils;

public class App {

	public static void main(String[] args) {
		Compte user1 = new Compte("user4", "pass123");
		Compte user2 = new Compte("user5", "pass456");
		Compte user3 = new Compte("user6", "pass789");
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp2");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
		
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	Session session = factory.getCurrentSession();
    	Transaction tx = session.getTransaction();
		
		tx.begin();
		session.persist(user1);
		session.persist(user2);
		session.persist(user3);
		tx.commit();
		
		session.close();
		factory.close();
	}

}
