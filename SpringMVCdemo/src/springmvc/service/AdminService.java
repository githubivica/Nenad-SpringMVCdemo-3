package springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.dao.AdminDAO;
import springmvc.dao.HranaDAO;
import springmvc.dao.PiceDAO;
import springmvc.model.Hrana;
import springmvc.model.Pice;
import springmvc.model.User;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO adminDao;
	
	@Autowired
	private PiceDAO piceDao;
	
	@Autowired
	private HranaDAO hranaDao;
	

	
	@Transactional
	public List<User> vratiSveUsere(){
		return adminDao.vratiSveUsere();
	}
	
	@Transactional
	public User vratiUseraPoId(long idUser) {
		return adminDao.vratiUseraPoId(idUser);
	}
	
	@Transactional
	public void updateUser(User user) {
		adminDao.updateUser(user);
	}
	
	@Transactional
	public void deleteUser(User user) {
		adminDao.deleteUser(user);
	}
	
	@Transactional
	public List<Pice> vratiSvoPice() {
		return piceDao.vratiSvoPice();
	}
	
	@Transactional
	public void dodajPiceUBazu(Pice pice) {
		piceDao.dodajPiceUBazu(pice);
		
	}

	@Transactional
	public Pice editPice(String idPice) {
		return piceDao.editPice(idPice);
	}
	
	@Transactional
	public void updatePice(Pice pice) {
		piceDao.updatePice(pice);
	}
	
	@Transactional
	public List<Hrana> vratiSvuHranu() {
		return hranaDao.vratiSvuHranu();
	}
	
	@Transactional
	public void dodajHranuUBazu(Hrana hrana) {
		hranaDao.dodajHranuUBazu(hrana);
	}
	
	@Transactional
	public Hrana vratiHranuPoId(String idHrana) {
		return hranaDao.vratiHranuPoId(idHrana);
	}

	@Transactional
	public void updateHrana(Hrana hrana) {
		hranaDao.updateHrana(hrana);
	}
	
	@Transactional
	public void deletePice(Pice pice) {
		piceDao.deletePice(pice);
	}
	
	@Transactional
	public void deleteHrana(Hrana hrana) {
		hranaDao.deleteHrana(hrana);
	}
	
	@Transactional
	public void addBalance(User user, String balanceAdd) {
		adminDao.addBalance(user,balanceAdd);
	}

}
