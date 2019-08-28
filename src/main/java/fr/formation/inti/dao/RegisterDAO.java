package fr.formation.inti.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import fr.formation.inti.entities.Compte;
import fr.formation.inti.utils.HibernateUtils;

public class RegisterDAO {

	private Session currentSession;
	private Transaction currentTransaction;
	
	public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

	
	public List<Compte> getAll() {
		Query q = getCurrentSession().createQuery("FROM " + Compte.class.getName());		
		List<Compte> comptes = q.list();
		return comptes;
	}


	public void persist(Compte e) {
		getCurrentSession().persist(e);
	}

	public Integer save(Compte e) {
		
		return (Integer) getCurrentSession().save(e);
	}


	public void update(Compte e) {
		getCurrentSession().update(e);
	}

	
	public void delete(Compte e) {
		getCurrentSession().delete(e);
	}

	
	public Compte findById(Integer id) {
		Compte log = (Compte) getCurrentSession().get(Compte.class, id);
		return log;
	}

	
	public void deleteByID(Integer id) {
		try {
			Compte e = findById(id);
			delete(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void close() {
		HibernateUtils.shutdown();
	}

}
