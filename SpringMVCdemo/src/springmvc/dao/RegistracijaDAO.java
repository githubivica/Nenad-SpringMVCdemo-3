package springmvc.dao;

import springmvc.model.User;

public interface RegistracijaDAO {
	
	void saveUser(User user);

	boolean daLiPostojiUser(String userName);

}
