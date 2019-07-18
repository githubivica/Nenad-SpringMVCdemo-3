package springmvc.dao;


import java.util.List;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.model.User;

@Repository
public class AdminDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<User> vratiSveUsere(){
		List<User> listaUsera = null;
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User");
			listaUsera = query.getResultList();
		return listaUsera;
	}
	
	public User vratiUseraPoId(long idUser) {
		
		return sessionFactory.getCurrentSession().get(User.class, idUser);
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	
	public void addBalance(User user, String balanceAdd) {
		user.setBalance(user.getBalance() + Double.parseDouble(balanceAdd));
		sessionFactory.getCurrentSession().update(user);
	}

}
