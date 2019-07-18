package springmvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.LoginDAO;
import springmvc.dao.RegistracijaDAO;
import springmvc.model.User;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private RegistracijaDAO registracijaDAO;
	@Autowired
	private LoginDAO loginDao;
	
	@Override
	@Transactional
	public void saveUser(User user) {
		registracijaDAO.saveUser(user);
	}

	@Override
	@Transactional
	public boolean daLiPostojiUser(String userName) {	
		return registracijaDAO.daLiPostojiUser(userName);
	}

	@Override
	@Transactional
	public boolean daLiPasswordOdgovaraUseru(User user) {
		return  loginDao.daLiPasswordOdgovaraUseru(user);
		
	}

	@Override
	@Transactional
	public User vratiUseraPoUserName(String userName) {
		return loginDao.vratiUseraPoUserName(userName);
	}

}
