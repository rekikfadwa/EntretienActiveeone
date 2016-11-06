package com.java.bdd;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.java.data.Fiche;

public class ContactListImpl implements ContactList {
	MysqlConnect mysqlConnect = new MysqlConnect();

	public void connectToDB() {
		// TODO Auto-generated method stub
		mysqlConnect.connect();

	}
	public void disconnectFromDB() {
		// TODO Auto-generated method stub
		mysqlConnect.disconnect();

	}

	// Rechercher une entrée par nom exact, sous-chaine du nom, ou numéro de
	// téléphone
	public List<Fiche> rechercherFicheParNom(String name) {
		List<Fiche> listOfFiche= new ArrayList<Fiche>();
		// if statement is created successfully, execute query and get results
		if (mysqlConnect.getStatement() != null) {
			try {
				
				// the mysql insert statement
			      String query = " select * from fiche where Nom like CONCAT ('%', ?, '%')";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = mysqlConnect.getConnection().prepareStatement(query);
			      preparedStmt.setString (1, name);
			      
			     

			      // execute the preparedstatement
			      preparedStmt.execute();
			      
			   // process the results
			      ResultSet rs = preparedStmt.executeQuery();
			      while ( rs.next() )
			      {
			        Fiche f = new Fiche();
			        f.setId( rs.getInt("id") );
			        f.setNom(rs.getString("Nom") );
			        f.setNumeroDeTelephone(rs.getString("numeroDeTelephone"));
			        f.setAdresse(rs.getString("adresse") );
			        listOfFiche.add(f);
			      }
			      
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("there is no connection to DB");
		}
		return listOfFiche;


	}

	// Lister l'ensemble des entrées
	public List<Fiche> listerFiches() {
		List<Fiche> listOfFiche= new ArrayList<Fiche>();
		// if statement is created successfully, execute query and get results
		if (mysqlConnect.getStatement() != null) {
			try {
				
				// the mysql insert statement
			      String query = " select * from fiche";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = mysqlConnect.getConnection().prepareStatement(query);
			      
			     

			      // execute the preparedstatement
			      preparedStmt.execute();
			      
			   // process the results
			      ResultSet rs = preparedStmt.executeQuery();
			      while ( rs.next() )
			      {
			        Fiche f = new Fiche();
			        f.setId( rs.getInt("id") );
			        f.setNom(rs.getString("Nom") );
			        f.setNumeroDeTelephone(rs.getString("numeroDeTelephone"));
			        f.setAdresse(rs.getString("adresse") );
			        listOfFiche.add(f);
			      }
			      
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("there is no connection to DB");
		}
		return listOfFiche;

	}

	// Ajouter une nouvelle fiche
	public void ajouterFiche(Fiche fiche) {
		ResultSet resultSet = null;
		
		
		// if statement is created successfully, execute query and get results
		if (mysqlConnect.getStatement() != null) {
			try {
				
				// the mysql insert statement
			      String query = " insert into fiche (Nom, numeroDeTelephone, adresse)"
			        + " values (?, ?, ?)";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = mysqlConnect.getConnection().prepareStatement(query);
			      preparedStmt.setString (1, fiche.getNom());
			      preparedStmt.setString (2, fiche.getNumeroDeTelephone());
			      preparedStmt.setString (3, fiche.getAdresse());
			    

			      // execute the preparedstatement
			      preparedStmt.execute();
			      
			      
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("there is no connection to DB");
		}

	}

	// Supprimer une fiche existante
	public void supprimerFiche(Fiche fiche) {
				// if statement is created successfully, execute query and get results
				if (mysqlConnect.getStatement() != null) {
					try {
						
						// the mysql insert statement
					      String query = " delete from fiche where id=?";

					      // create the mysql insert preparedstatement
					      PreparedStatement preparedStmt = mysqlConnect.getConnection().prepareStatement(query);
					      preparedStmt.setInt (1, fiche.getId());
					      
					    

					      // execute the preparedstatement
					      preparedStmt.execute();
					      
					      
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				else {
					System.out.println("there is no connection to DB");
				}

	}
	// vider la table
		public void viderTable() {
					// if statement is created successfully, execute query and get results
					if (mysqlConnect.getStatement() != null) {
						try {
							
							// the mysql insert statement
						      String query = " truncate fiche";

						      // create the mysql insert preparedstatement
						      PreparedStatement preparedStmt = mysqlConnect.getConnection().prepareStatement(query);
						      
						    

						      // execute the preparedstatement
						      preparedStmt.execute();
						      
						      
						} catch (SQLException e) {
							System.out.println(e.getMessage());
						}
					}
					else {
						System.out.println("there is no connection to DB");
					}

		}

	// Modifier une fiche existante
	//le fiche entrée va remplacer la fiche qui a le même id
	public void modifierFiche(Fiche fiche) {
		
		// if statement is created successfully, execute query and get results
				if (mysqlConnect.getStatement() != null) {
					try {
						
						// the mysql insert statement
					      String query = "UPDATE fiche "+
						"SET Nom=?,numeroDeTelephone=?, adresse=?"+
					    " WHERE id=?;";
					     
					     
					      // create the mysql insert preparedstatement
					      PreparedStatement preparedStmt = mysqlConnect.getConnection().prepareStatement(query);
					      preparedStmt.setString (1, fiche.getNom());
					      preparedStmt.setString (2, fiche.getNumeroDeTelephone());
					      preparedStmt.setString (3, fiche.getAdresse());
					      preparedStmt.setInt(4, fiche.getId());
					      
					      
					      // execute the preparedstatement
					      preparedStmt.execute();
					      
					   
					      
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				else {
					System.out.println("there is no connection to DB");
				}

		

	}
}
