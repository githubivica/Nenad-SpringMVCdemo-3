package springmvc.bussinesService;

import java.util.List;

import org.springframework.stereotype.Component;
import springmvc.model.Artikal;
import springmvc.model.Racun;

@Component
public class KorisnikBussinesLogic {
	
	public void obrisiArtikalSaListe(String idArtikla, Racun racun) {
		
		List<Artikal> listaArtikala = racun.getListaArtikala();
		List<Integer> kolicina = racun.getKolicina();
		
		for (int i = 0; i<listaArtikala.size(); i++) {
			if(listaArtikala.get(i).getIdArtikla() == Long.parseLong(idArtikla)) {
				listaArtikala.remove(i);
				kolicina.remove(i);
			}else {
				continue;
			}
		}
	}

	public double izracunajTotalRacun(Racun racun) {
		
			List<Artikal> listaArtikala = racun.getListaArtikala();
			List<Integer> kolicina = racun.getKolicina();
			double suma = 0;
			for (int i = 0; i<listaArtikala.size(); i++) {
				suma += listaArtikala.get(i).getCena() * kolicina.get(i) * (100 - listaArtikala.get(i).getPopust())/100;
			}
			return suma;
	}

	public void ponistiRacun(Racun racun) {
		List<Artikal> listaArtikala = racun.getListaArtikala();
		for(int i =0 ; i<listaArtikala.size();i++) {
			listaArtikala.remove(i);
		}
	}
	
	

}
