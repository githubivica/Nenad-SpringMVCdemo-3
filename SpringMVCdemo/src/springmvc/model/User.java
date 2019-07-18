package springmvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUser;
	@NotEmpty(message = "morate popuniti ovo polje!")
	private String userName;
	@NotEmpty(message = "morate popuniti ovo polje!")
	@Size(min = 3, max = 12, message = "password mora sadrzati minimum 3, a maksimalno 12 karaktera")
	private String password;
	@Enumerated
	private Role role;
	private double balance;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Racun> listaRacuna = new ArrayList<Racun>();
	
	public List<Racun> getListaRacuna() {
		return listaRacuna;
	}
	public void setListaRacuna(List<Racun> listaRacuna) {
		this.listaRacuna = listaRacuna;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
