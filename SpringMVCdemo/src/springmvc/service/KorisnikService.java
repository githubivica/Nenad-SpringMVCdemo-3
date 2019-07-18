package springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.bussinesService.KorisnikBussinesLogic;
import springmvc.dao.HranaDAO;
import springmvc.dao.KorisnikDAO;
import springmvc.dao.PiceDAO;
import springmvc.model.Hrana;
import springmvc.model.Pice;
import springmvc.model.Racun;
import springmvc.model.User;

@Service
public class KorisnikService {
	
	@Autowired
	private KorisnikDAO korisnikDAO;
	
	@Autowired
	private PiceDAO piceDAO;
	
	@Autowired
	private HranaDAO hranaDAO;
		
	@Autowired
	private KorisnikBussinesLogic korisnikBussinesLogic;
	
	
	@Transactional
	public List<Pice> vratiSvoPice() {
		return piceDAO.vratiSvoPice();
	}
	
	@Transactional
	public List<Hrana> vratiSvuHranu() {
		return hranaDAO.vratiSvuHranu();
	}
	
	@Transactional
	public Pice vratiPicePoId(String idPice) {
		return piceDAO.vratiPicePoId(idPice);
	}
	
	
	public void obrisiArtikalSaListe(String idArtikla, Racun racun) {
		korisnikBussinesLogic.obrisiArtikalSaListe(idArtikla,racun);
	}

	public double izracunajTotalRacun(Racun racun) {
		return korisnikBussinesLogic.izracunajTotalRacun(racun);
	}
	
	@Transactional
	public void snimiRacunUbazu(Racun racun) {
		korisnikDAO.snimiRacunUbazu(racun);
		
	}
	
	@Transactional
	public void updateUserBalance(User user, double totalPrice) {
		korisnikDAO.updateUserBalance(user,totalPrice);
	}
	
	@Transactional
	public void urediKolicinu(Racun racun) {
		korisnikDAO.urediKolicinu(racun);
	}
	
	@Transactional
	public List<Racun> vratiListuRacuna(long idUser) {
		return korisnikDAO.vratiListuRacuna(idUser);
	}
	
	@Transactional
	public Hrana vratiHranuPoId(String idHrana) {
		return hranaDAO.vratiHranuPoId(idHrana);
	}

	public void ponistiRacun(Racun racun) {
		korisnikBussinesLogic.ponistiRacun(racun);
		
	}
	
	
}
