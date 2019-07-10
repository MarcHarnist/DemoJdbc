package fr.eni.stagiaire.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.stagiaire.bo.Stagiaire;
import fr.eni.stagiaire.dal.StagiaireDAO;

public class StagiaireDAOJdbcImpl implements StagiaireDAO{

	private static final String SQL_SELECT_ALL = "select noStagiaire, nom, prenom, motDePasse from stagiaires";

	public List<Stagiaire> selectAll() throws SQLException {
		
		
		List<Stagiaire> listeStagiaires = new ArrayList<Stagiaire>();

		// Déclare les variables pour les try & catch
		Connection uneConnection = null;
		Statement unStml = null;
		
		try {
			//Valorise la connexion
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

	@Override
	public void insert(Stagiaire s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Stagiaire s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Stagiaire s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Stagiaire selectById(int noStagiaire) {
		// TODO Auto-generated method stub
		return null;
	}
}
