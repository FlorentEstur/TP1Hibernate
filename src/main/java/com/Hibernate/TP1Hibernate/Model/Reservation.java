package com.Hibernate.TP1Hibernate.Model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Reservation {

	@Id
	protected int numR;
	protected LocalDate dateR;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	protected Client client;
	
	@ManyToOne
	@JoinColumn(name="idPassager")
	protected Passager passager;
	
	@ManyToOne
	@JoinColumn(name="numV")
	protected Vol vol;
	
	public Reservation() {
		super();
	}


	public Reservation( int numR, LocalDate dateR) {
		super();
		this.numR = numR;
		this.dateR = dateR;
	}

	public LocalDate getDateR() {
		return dateR;
	}


	public void setDateR(LocalDate dateR) {
		this.dateR = dateR;
	}


	public int getNumR() {
		return numR;
	}


	public void setNumR(int numR) {
		this.numR = numR;
	}


	@Override
	public String toString() {
		return "Reservation [numR=" + numR + ", dateR=" + dateR + "]";
	}
}
