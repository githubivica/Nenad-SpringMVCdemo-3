package springmvc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Racun {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRacun;
	private Date date;
	@ManyToOne
	private User user;
	@OneToMany
	@JoinColumn(insertable = false, updatable = false)
	private List<Artikal> listaArtikala = new ArrayList<Artikal>();
	@ElementCollection
	private List<Integer> kolicina = new ArrayList<Integer>();
	
	private double totalPrice;
	
	public long getIdRacun() {
		return idRacun;
	}
	public void setIdRacun(long idRacun) {
		this.idRacun = idRacun;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Artikal> getListaArtikala() {
		return listaArtikala;
	}
	public void setListaArtikala(List<Artikal> listaArtikala) {
		this.listaArtikala = listaArtikala;
	}
	public List<Integer> getKolicina() {
		return kolicina;
	}
	public void setKolicina(List<Integer> kolicina) {
		this.kolicina = kolicina;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	

}
