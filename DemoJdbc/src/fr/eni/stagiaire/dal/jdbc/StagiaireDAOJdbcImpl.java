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

		// D�clare les variables pour les try & catch
		Connection uneConnection = null;
		Statement unStml = null;
		
		try {
			uneConnection = JdbcTools.getConnection();
			
			//Cr�e le statement
			unStml = uneConnection.createStatement();
			
			//Cr�e une requ�te Sql
			
			ResultSet rs = unStml.executeQuery(SQL_SELECT_ALL);
			
			// R�cup�re les donn�es dans un String Builder
			StringBuilder sb = null;
			
			//It�re sur r�sult set
			while(rs.next()) // Tant qu'on a une ligne � afficher, on passe � la suivante
			{
				Stagiaire s = new Stagiaire(rs.getInt("noStagiaire"), rs.getString("prenom"), rs.getString("nom"), rs.getString("motDePasse"));
				listeStagiaires.add(s);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally // finally s'execute toujours: il faut toujours fermer la connexion 
		{
				// Ferme la connection � la DB
				JdbcTools.closeConnection(uneConnection);

		}
		
		return listeStagiaires;
		
	}
}
