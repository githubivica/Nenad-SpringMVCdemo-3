package springmvc.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.model.Hrana;
import springmvc.model.Pice;

@Repository
public class HranaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Hrana> vratiSvuHranu() {
		Query q = sessionFactory.getCurrentSession().createQuery("FROM Hrana");
		return q.getResultList();
	}

	public void dodajHranuUBazu(Hrana hrana) {
		sessionFactory.getCurrentSession().save(hrana);
	}

	public Hrana vratiHranuPoId(String idHrana) {
		return (Hrana)sessionFactory.getCurrentSession().get(Hrana.class, Long.parseLong(idHrana));
	}

	public void updateHrana(Hrana hrana) {
		sessionFactory.getCurrentSession().update(hrana);
	}
	
	public void deleteHrana(Hrana hrana) {
		sessionFactory.getCurrentSession().delete(hrana);
	}
	
	
}
