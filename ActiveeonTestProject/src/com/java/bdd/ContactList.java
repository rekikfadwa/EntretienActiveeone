package com.java.bdd;

import java.util.List;
import java.util.Set;

import com.java.data.Fiche;

public interface ContactList {
			public void connectToDB();
			public void disconnectFromDB();
			
			//Rechercher une entr�e par nom exact, sous-chaine du nom, ou num�ro de t�l�phone
			public List<Fiche> rechercherFicheParNom(String name);
			
			//Lister l'ensemble des entr�es
			public List<Fiche>  listerFiches() ;
			
			//Ajouter une nouvelle fiche
			public void ajouterFiche(Fiche fiche) ;
			
			//Supprimer une fiche existante
			public void supprimerFiche(Fiche fiche) ;
			
			//Modifier une fiche existante
			public void modifierFiche( Fiche fiche) ;
			
			// vider la table
			public void viderTable();
}
