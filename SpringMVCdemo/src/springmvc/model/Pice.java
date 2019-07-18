package springmvc.model;

import javax.persistence.Entity;

@Entity
public class Pice extends Artikal {
	
	private double zapremina;

	public double getZapremina() {
		return zapremina;
	}

	public void setZapremina(double zapremina) {
		this.zapremina = zapremina;
	}
	
	

}
