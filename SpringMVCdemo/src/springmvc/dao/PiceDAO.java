package springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.model.Pice;

@Repository
public class PiceDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Pice> vratiSvoPice() {
		List<Pice> listaPica = new ArrayList<Pice>();
		String upit = "FROM Pice";
		Query query = sessionFactory.getCurrentSession().createQuery(upit);
		listaPica = (List<Pice>)query.getResultList();
		return listaPica;
	}

	public void dodajPiceUBazu(Pice pice) {
		sessionFactory.getCurrentSession().save(pice);
	}

	public Pice editPice(String idPice) {
		Long id = Long.parseLong(idPice);
		return sessionFactory.getCurrentSession().get(Pice.class, id);
	}

	public void updatePice(Pice pice) {
		sessionFactory.getCurrentSession().update(pice);
	}
	
	public void deletePice(Pice pice) {
		sessionFactory.getCurrentSession().delete(pice);
	}
	
	public Pice vratiPicePoId(String idPice) {
		return (Pice)sessionFactory.getCurrentSession().get(Pice.class, Long.parseLong(idPice));
	}
	
	
	
}
