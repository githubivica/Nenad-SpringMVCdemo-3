package springmvc.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.model.User;

@Repository
public class RegistracijaDAOImp implements RegistracijaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public boolean daLiPostojiUser(String userName) {
		
		String upit = "FROM User WHERE userName = :userName";
			Query query = sessionFactory.getCurrentSession().createQuery(upit);
			query.setParameter("userName", userName);
		List<User> listaUsera = query.getResultList();
		if(!(listaUsera.isEmpty())) {
			return true;
		}else {
			return false;
		}
		
	}

}
