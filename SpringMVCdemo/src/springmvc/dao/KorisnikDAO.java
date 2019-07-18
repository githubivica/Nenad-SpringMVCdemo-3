package springmvc.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.model.Artikal;
import springmvc.model.Racun;
import springmvc.model.User;

@Repository
public class KorisnikDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void snimiRacunUbazu(Racun racun) {
		sessionFactory.getCurrentSession().save(racun);
	}

	public void updateUserBalance(User user, double totalPrice) {
		user.setBalance(user.getBalance() - totalPrice);
		sessionFactory.getCurrentSession().update(user);
	}

	public void urediKolicinu(Racun racun) {
		
		List<Artikal> listaArtikala = racun.getListaArtikala();
		List<Integer> kolicina = racun.getKolicina();
		for (int i = 0; i<listaArtikala.size(); i++) {
			Artikal artikal = listaArtikala.get(i);
			artikal.setStanje(artikal.getStanje() - kolicina.get(i));
			sessionFactory.getCurrentSession().update(artikal);
		}
		
	}

	public List<Racun> vratiListuRacuna(long idUser) {
		
		User user = sessionFactory.getCurrentSession().get(User.class, idUser);
		Hibernate.initialize(user.getListaRacuna());
		return user.getListaRacuna();
	}
	
	
	
		
}
