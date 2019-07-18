package springmvc.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.Artikal;
import springmvc.model.Hrana;
import springmvc.model.Pice;
import springmvc.model.Racun;
import springmvc.model.User;
import springmvc.service.KorisnikService;

@Controller
@RequestMapping("/korisnik")
public class KorisnikController {
	
	@Autowired
	private KorisnikService korisnikService;
	
	@RequestMapping("/korisnikPage")
	public String korisnikPage(Model model) {
		model.addAttribute("korisnik", new User());
		return "korisnik";
	}
	
	@RequestMapping("/naruciArtikal")
	public String naruciPice(Model modelPice, Model modelHrana) {
		List<Pice> listaPica = korisnikService.vratiSvoPice();
		List<Hrana> listaHrane = korisnikService.vratiSvuHranu();
		modelPice.addAttribute("listaPica", listaPica);
		modelHrana.addAttribute("listaHrane", listaHrane);
		return "naruci-pice-hranu";
	}
	
	@RequestMapping("/pregledajPice")
	public String pregledajPice(@RequestParam("idPice") String idPice, Model model) {
		Pice pice = korisnikService.vratiPicePoId(idPice);
		model.addAttribute("piceZaNarucivanje",pice);
		return "prikazi-pice";
	}
	
	@RequestMapping("/pregledajHranu")
	public String pregledajHranu(@RequestParam("idHrana") String idHrana, Model model) {
		Hrana hrana = korisnikService.vratiHranuPoId(idHrana);
		model.addAttribute("hranaZaNarucivanje",hrana);
		return "prikazi-hranu";
	}
	
	@PostMapping("/dodajPiceNaRacun")
	public String dodajPiceNaRacun(@ModelAttribute("piceZaNarucivanje") Pice pice, HttpSession session, @RequestParam("kolicina") String kolicina) {
		Racun racun = (Racun)session.getAttribute("racun");
		if(racun ==null) {
			racun = new Racun();
		}	
		List<Artikal> listaArtikala = racun.getListaArtikala();
			listaArtikala.add(pice);	
			racun.getKolicina().add(Integer.parseInt(kolicina));
			session.setAttribute("racun", racun);
		return "redirect: naruciArtikal";
	}
	
	@PostMapping("/dodajHranuNaRacun")
	public String dodajHranuNaRacun(@ModelAttribute("hranaZaNarucivanje") Hrana hrana, HttpSession session, @RequestParam("kolicina") String kolicina) {
		Racun racun = (Racun)session.getAttribute("racun");
		if(racun ==null) {
			racun = new Racun();
		}	
		List<Artikal> listaArtikala = racun.getListaArtikala();
			listaArtikala.add(hrana);	
			racun.getKolicina().add(Integer.parseInt(kolicina));
			session.setAttribute("racun", racun);
		return "redirect: naruciArtikal";
	}
	
	@RequestMapping("/pogledajRacun")
	public String pogledajRacun(Model model, HttpSession session) {
		Racun racun = (Racun)session.getAttribute("racun");
		if(racun == null) {
			return "nemate-artikal-na-racunu";
		}else {
			double totalPrice = korisnikService.izracunajTotalRacun(racun);
			racun.setTotalPrice(totalPrice);
			model.addAttribute("racunKolicina", racun);
			return "racun";
		}
	}
	
	@RequestMapping("/obrisiArtikalSaListe")
	public String obrisiArtikalSaListe(@RequestParam("idArtikla") String idArtikla, HttpSession session) {
		Racun racun = (Racun)session.getAttribute("racun");
		korisnikService.obrisiArtikalSaListe(idArtikla,racun);
		return "redirect: pogledajRacun";
		
	}
	
	@PostMapping("/platiRacun")
	public String platiRacun(HttpSession session) {
		
		User user = (User)session.getAttribute("userIzBaze");
		Racun racun = (Racun)session.getAttribute("racun");
		
		if(racun.getTotalPrice()==0) {
			
			return "redirect: pogledajRacun";
			
		}else 
			
		if(user.getBalance()>=racun.getTotalPrice()) {
	
			racun.setUser(user);
			Date date = new Date();
			racun.setDate(date);
				
			List<Racun>listaRacuna = korisnikService.vratiListuRacuna(user.getIdUser());
			listaRacuna.add(racun);
			user.setListaRacuna(listaRacuna);
			
		
			korisnikService.urediKolicinu(racun);
			korisnikService.updateUserBalance(user,racun.getTotalPrice());
			korisnikService.snimiRacunUbazu(racun);
			
			session.removeAttribute("racun");
			
			return "redirect: uspesnoObavljenaTransakcija";
			
		}else {
			return "redirect: racunError";
		}	
	}
	
	@RequestMapping("/racunError")
	public String errorRacun() {
		return "nema-dovoljno-racun";
	}
	
	@RequestMapping("/uspesnoObavljenaTransakcija")
	public String uspesnoObavljenaTransakcija() {
		return "uspesno-obavljena-transakcija";
	}
	
	@RequestMapping("/ponistiRacun")
	public String ponistiRacun(HttpSession session) {
		
		Racun racun = (Racun)session.getAttribute("racun");
		korisnikService.ponistiRacun(racun);
		return "redirect: naruciArtikal";
		
	}

	
	
	

}
