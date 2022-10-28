package com.Hibernate.TP1Hibernate.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Ville {

	@Id
	protected int cp;
	protected String nom;
	
	@OneToMany (mappedBy = "ville", cascade = CascadeType.ALL)
	protected List<Aeroport> listeAeroport;
	
	public Ville() {
		super();
	}

	public Ville(int cp, String nom) {
		super();
		this.cp = cp;
		this.nom = nom;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Ville [cp=" + cp + ", nom=" + nom + "]";
	}
	
}
