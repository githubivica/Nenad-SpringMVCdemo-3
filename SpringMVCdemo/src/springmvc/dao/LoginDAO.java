package springmvc.dao;

import springmvc.model.User;

public interface LoginDAO {

	boolean daLiPasswordOdgovaraUseru(User user);

	User vratiUseraPoUserName(String userName);

}
