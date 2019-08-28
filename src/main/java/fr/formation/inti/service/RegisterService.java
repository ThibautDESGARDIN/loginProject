package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.dao.RegisterDAO;
import fr.formation.inti.entities.Compte;

public class RegisterService {
	
	private static RegisterDAO dao;
	
	public RegisterService() {
		dao = new RegisterDAO();
	}
	public void persist(Compte e) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(e);
        dao.closeCurrentSessionwithTransaction();
    }
	public Integer inscription(Compte e) {
		Integer id;
        dao.openCurrentSessionwithTransaction();
        id = dao.save(e);
        dao.closeCurrentSessionwithTransaction();
        return id;
    }
    public void update(Compte e) {
        dao.openCurrentSessionwithTransaction();
        dao.update(e);
        dao.closeCurrentSessionwithTransaction();
    }
 
    public Compte findById(Integer id) {
        dao.openCurrentSession();
        Compte log = dao.findById(id);
        dao.closeCurrentSession();
        return log;
    }
 
    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Compte log = dao.findById(id);
        dao.delete(log);
        dao.closeCurrentSessionwithTransaction();
    }
    public List<Compte> findAll() {
        dao.openCurrentSession();
        List<Compte> comptes = dao.getAll();
        dao.closeCurrentSession();
        return comptes;
    }
 
    
 
    public RegisterDAO EmployeeDao() {
        return dao;
    }
}
