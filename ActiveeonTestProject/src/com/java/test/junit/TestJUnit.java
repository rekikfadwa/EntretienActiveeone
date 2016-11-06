package com.java.test.junit;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.java.bdd.ContactList;
import com.java.bdd.ContactListImpl;
import com.java.data.Fiche;

public class TestJUnit {
	ContactList contactList = new ContactListImpl();
	@Test
	public void testLister(){
		contactList.connectToDB();
		contactList.viderTable();
		Fiche ficheFadwa = new Fiche("fadwa", "0781804354", "1 rue pierre kohlmann, ANTONY");
		Fiche ficheMed = new Fiche("med", "0781804354", "1 rue pierre kohlmann, ANTONY");
		
		contactList.ajouterFiche(ficheFadwa);
		contactList.ajouterFiche(ficheMed);
		
		List<Fiche> listFiche=contactList.listerFiches();
		
		
		Assert.assertEquals(listFiche.size(), 2);
		contactList.disconnectFromDB();
	}
	@Test
	public void testAjouter(){
		contactList.connectToDB();
		contactList.viderTable();
		Fiche ficheFadwa = new Fiche("fadwa", "0781804354", "1 rue pierre kohlmann, ANTONY");
		Fiche ficheMed = new Fiche("med", "0781804354", "1 rue pierre kohlmann, ANTONY");
		
		contactList.ajouterFiche(ficheFadwa);
		contactList.ajouterFiche(ficheMed);
		
		List<Fiche> listFiche=contactList.listerFiches();
		
		//Assert.assertEquals(ficheFadwa, listFiche.get(0));
		Assert.assertEquals(ficheFadwa.getNom(), listFiche.get(0).getNom());
		Assert.assertEquals(ficheFadwa.getAdresse(), listFiche.get(0).getAdresse());
		contactList.disconnectFromDB();
	}
	@Test
	public void testRechercheParNom (){	
		contactList.connectToDB();
		contactList.viderTable();
		Fiche ficheFadwa = new Fiche("fadwa", "0781804354", "1 rue pierre kohlmann, ANTONY");
		contactList.ajouterFiche(ficheFadwa);
		ficheFadwa = new Fiche("fadwa REKIK", "0781804354", "1 rue pierre kohlmann, ANTONY");
		contactList.ajouterFiche(ficheFadwa);
		
		List<Fiche> listFiche=contactList.rechercherFicheParNom("ad");
		
		Assert.assertEquals(listFiche.size(), 2);
		
		contactList.disconnectFromDB();
		
		
	}
	@Test
	public void testModifierFiche (){	
		contactList.connectToDB();
		contactList.viderTable();
		Fiche ficheFadwa = new Fiche("fadwa", "0781804354", "1 rue pierre kohlmann, ANTONY");
		contactList.ajouterFiche(ficheFadwa);
		
		List<Fiche> listFiche=contactList.rechercherFicheParNom("fadwa");
		ficheFadwa=listFiche.get(0);
		ficheFadwa.setAdresse("Paris");
		
		
		contactList.modifierFiche(ficheFadwa);
		Assert.assertEquals(contactList.rechercherFicheParNom("fadwa").get(0).getAdresse(), "Paris");
		
		
		contactList.disconnectFromDB();
		
		
	}
	@Test
	public void testSupprimer(){
		contactList.connectToDB();
		contactList.viderTable();
		Fiche fiche = new Fiche("fadwa", "0781804354", "1 rue pierre kohlmann, ANTONY");
		contactList.ajouterFiche(fiche);
		fiche = new Fiche("med", "0781804354", "1 rue pierre kohlmann, ANTONY");
		contactList.ajouterFiche(fiche);
		List<Fiche> listFiche=contactList.rechercherFicheParNom("fadwa");
		Fiche ficheAsupprimer=listFiche.get(0);
		
		contactList.supprimerFiche(ficheAsupprimer);
		
		listFiche=contactList.rechercherFicheParNom("fadwa");
		
		
		Assert.assertEquals(listFiche.size(), 0);
		contactList.disconnectFromDB();
	}

}
