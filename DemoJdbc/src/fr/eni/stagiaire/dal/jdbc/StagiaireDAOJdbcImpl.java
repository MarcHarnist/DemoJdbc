package fr.eni.stagiaire.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import fr.eni.stagiaire.bo.Stagiaire;

public class StagiaireDAOJdbcImpl {

	private static final String SQL_SELECT_ALL = "select noStagiaire, nom, prenom, motDePasse from stagiaires";

	public List<Stagiaire> selectAll() throws SQLException {
		
		
		List<Stagiaire> listeStagiaires = new ArrayList<Stagiaire>();

		// Déclare les variables pour les try & catch
		Connection uneConnection = null;
		Statement unStml = null;
		
		try {
			uneConnection = JdbcTools.getConnection();
			
			//Crée le statement
			unStml = uneConnection.createStatement();
			
			//Crée une requête Sql
			
			ResultSet rs = unStml.executeQuery(SQL_SELECT_ALL);
			
			// Récupère les données dans un String Builder
			StringBuilder sb = null;
			
			//Itère sur résult set
			while(rs.next()) // Tant qu'on a une ligne à afficher, on passe à la suivante
			{
				Stagiaire s = new Stagiaire(rs.getInt("noStagiaire"), rs.getString("prenom"), rs.getString("nom"), rs.getString("motDePasse"));
				listeStagiaires.add(s);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally // finally s'execute toujours: il faut toujours fermer la connexion 
		{
				// Ferme la connection à la DB
				JdbcTools.closeConnection(uneConnection);

		}
		
		return listeStagiaires;
		
	}
}
