package com.Hibernate.TP1Hibernate.Model;

import java.util.List;

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
public class Aeroport {

	@Id
	protected int idAeroport;
	protected String nom;
	
	@ManyToOne
	@JoinColumn(name="cp")
	protected Ville ville;
	
	@OneToMany (mappedBy = "aeroportD")
	protected List<Vol> listeVolArrivance;
	
	@OneToMany (mappedBy = "aeroportA")
	protected List<Vol> lsiteVolPartance;
	
	@ManyToMany
	@JoinTable(name="InfosEscale",
				joinColumns = @JoinColumn(name="heureArrivee"),
					inverseJoinColumns = @JoinColumn(name="heureDepart"))
	protected List<Vol> listeVol;
	
	public Aeroport() {
		super();
	}

	public Aeroport(int idAeroport, String nom) {
		super();
		this.idAeroport = idAeroport;
		this.nom = nom;
	}

	public int getIdAeroport() {
		return idAeroport;
	}

	public void setIdAeroport(int idAeroport) {
		this.idAeroport = idAeroport;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Aeroport [idAeroport=" + idAeroport + ", nom=" + nom + "]";
	}
	
}
