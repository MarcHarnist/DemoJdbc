package fr.eni.demoJdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DemoJdbc {

	public static void main(String[] args) throws SQLException {

		// Déclare les variables pour les try & catch
		Connection uneConnection = null;
		Statement unStml = null;
		
		try {
			// Tous les ids de connexions sont gérés dans JdbcTools.java
			uneConnection = JdbcTools.getConnection();
			
			//Crée le statement
			unStml = uneConnection.createStatement();
			
			//Crée une requête Sql
			String sql = "select noStagiaire, nom, prenom, dateDeNaissance from stagiaires";
			ResultSet rs = unStml.executeQuery(sql);
			
			// Récupère les données dans un String Builder
			StringBuilder sb = null;
			
			//Itère sur résult set
			while(rs.next()) // Tant qu'on a une ligne à afficher, on passe à la suivante
			{
				sb = new StringBuilder();
				sb.append("Numéro de stagiaire: ");
				sb.append(rs.getInt("noStagiaire"));
				sb.append(", prénom: ");
				sb.append(rs.getString("prenom"));
				sb.append(", nom: ");
				sb.append(rs.getString("nom"));// avec getDate(columnInt)
				
				//Crée variable de type Date.sql avec getDate(columnLabel)
				@SuppressWarnings("unused")
				Date date = rs.getDate("dateDeNaissance");
				if(!rs.wasNull()) // if(date != null) autre méthode
				{
					sb.append(", date de naissance");
					sb.append(rs.getDate("dateDeNaissance"));// la date peut être null
				}
				System.out.println(sb);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally // finally s'execute toujours: il faut toujours fermer la connexion 
		{
				// Ferme la connection à la DB
				JdbcTools.closeConnection(uneConnection);

		}
	}
}
