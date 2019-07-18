package springmvc.dao;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.model.User;

@Repository
public class LoginDAOImp implements LoginDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean daLiPasswordOdgovaraUseru(User user) {
		
		String upit = "FROM User WHERE userName = :userName";
		Query query = sessionFactory.getCurrentSession().createQuery(upit);
			query.setParameter("userName", user.getUserName());
			User userFromDb = (User)query.getResultList().get(0);
				if(userFromDb.getPassword().equals(user.getPassword())) {
					return true;
				}else {
					return false;
				}
	}

	@Override
	public User vratiUseraPoUserName(String userName) {
		
		User userFromDb = null;
		String upit = "FROM User WHERE userName = :userName";
		Query query = sessionFactory.getCurrentSession().createQuery(upit);
			query.setParameter("userName", userName);
			userFromDb = (User)query.getResultList().get(0);	
		return userFromDb;
	}
	
	
	
	
	

}
