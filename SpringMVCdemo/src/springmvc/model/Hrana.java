package springmvc.model;

import javax.persistence.Entity;

@Entity
public class Hrana extends Artikal {
	
	private double masa;

	public double getMasa() {
		return masa;
	}

	public void setMasa(double masa) {
		this.masa = masa;
	}
	
	

}
