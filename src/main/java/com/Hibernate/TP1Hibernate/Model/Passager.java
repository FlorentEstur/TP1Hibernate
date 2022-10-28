package com.Hibernate.TP1Hibernate.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Passager {

	@Id
	protected int idPassage;
	protected String nom, prenom;
	
	@OneToMany(mappedBy = "passager")
	protected List<Reservation> listeReservation;
	
	public Passager() {
		super();
	}

	public Passager(int idPassage, String nom, String prenom) {
		super();
		this.idPassage = idPassage;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getIdPassage() {
		return idPassage;
	}

	public void setIdPassage(int idPassage) {
		this.idPassage = idPassage;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Passager [idPassage=" + idPassage + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
}
