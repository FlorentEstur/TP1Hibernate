package com.Hibernate.TP1Hibernate.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class CompagnieAerienne {
	
	@Id
	protected int idCompagnie;
	protected String nom;
	
	@ManyToMany
	@JoinTable(name="Compagnie_Vol",
				joinColumns = @JoinColumn(name="numv"),
					inverseJoinColumns = @JoinColumn(name="idCompagnie"))
	protected List<Vol> listeVol;
	
	public CompagnieAerienne() {
		super();
	}

	public CompagnieAerienne(int idCompagnie, String nom) {
		super();
		this.idCompagnie = idCompagnie;
		this.nom = nom;
	}

	public int getIdCompagnie() {
		return idCompagnie;
	}

	public void setIdCompagnie(int idCompagnie) {
		this.idCompagnie = idCompagnie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "CompagnieAerienne [idCompagnie=" + idCompagnie + ", nom=" + nom + "]";
	}

}
