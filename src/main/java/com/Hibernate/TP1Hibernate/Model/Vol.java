package com.Hibernate.TP1Hibernate.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Vol {

	@Id
	protected int numV;
	protected LocalDate dateDepart;
	protected LocalDateTime heureDepart;
	protected LocalDate dateArrivee;
	protected LocalDateTime heureArrivee;
	
	@OneToMany(mappedBy = "vol")
	protected List<Reservation> listeReservation;
	
	@ManyToMany
	@JoinTable(name="Compagnie_Vol",
				joinColumns=@JoinColumn(name="idCompagnie"),
					inverseJoinColumns = @JoinColumn(name="numV"))
	protected List<CompagnieAerienne> listeCompagnieAerienne;
	
	@ManyToOne
	@JoinColumn(name="depart")
	protected Aeroport aeroportD;
	
	@ManyToOne
	@JoinColumn(name="arrivee")
	protected Aeroport aeroportA;
	
	@ManyToMany
	@JoinTable(name="InfosEscale",
				joinColumns = @JoinColumn(name="heureDepart"),
					inverseJoinColumns = @JoinColumn(name="heureArrivee"))
	protected List<Aeroport> listeAeroport;
	
	public Vol() {
		super();
	}

	public Vol(int numV, LocalDate dateDepart, LocalDateTime heureDepart, LocalDate dateArrivee,
			LocalDateTime heureArrivee) {
		super();
		this.numV = numV;
		this.dateDepart = dateDepart;
		this.heureDepart = heureDepart;
		this.dateArrivee = dateArrivee;
		this.heureArrivee = heureArrivee;
	}

	public int getNumV() {
		return numV;
	}

	public void setNumV(int numV) {
		this.numV = numV;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public LocalDateTime getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(LocalDateTime heureDepart) {
		this.heureDepart = heureDepart;
	}

	public LocalDate getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public LocalDateTime getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(LocalDateTime heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public List<Reservation> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(List<Reservation> listeReservation) {
		this.listeReservation = listeReservation;
	}

	@Override
	public String toString() {
		return "Vol [numV=" + numV + ", dateDepart=" + dateDepart + ", heureDepart=" + heureDepart + ", dateArrivee="
				+ dateArrivee + ", heureArrivee=" + heureArrivee + "]";
	}
	
}
