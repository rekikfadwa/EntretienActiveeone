package com.java.data;

import java.util.List;
import java.util.Set;


public class Fiche {
	
	private Integer id;
	private String nom;
	private String numeroDeTelephone;
	private String adresse;
	

	public Fiche(String nom, String numeroDeTelephone, String adresse) {
		
		this.nom=nom;
		this.numeroDeTelephone= numeroDeTelephone;
		this.adresse=adresse;
		
	}
	public Fiche() {
		// TODO Auto-generated constructor stub
	}
	public String getNom() {
		return nom;
	}
	// Override .equals method.

	public boolean equals(Fiche fiche) {
	    if (this.nom.equals(fiche.nom) && this.adresse.equals(fiche.adresse) && this.numeroDeTelephone.equals(fiche.numeroDeTelephone)) {
	        return true;
	    } else {
	        return false;
	    }
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
