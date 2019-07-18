package springmvc.service;

import springmvc.model.User;

public interface UserService {
	
	void saveUser(User user);

	boolean daLiPostojiUser(String userName);

	boolean daLiPasswordOdgovaraUseru(User user);

	User vratiUseraPoUserName(String userName);
}
