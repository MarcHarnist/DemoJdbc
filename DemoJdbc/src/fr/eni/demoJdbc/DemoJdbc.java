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

		// D�clare les variables pour les try & catch
		Connection uneConnection = null;
		Statement unStml = null;
		
		try {
			// Tous les ids de connexions sont g�r�s dans JdbcTools.java
			uneConnection = JdbcTools.getConnection();
			
			//Cr�e le statement
			unStml = uneConnection.createStatement();
			
			//Cr�e une requ�te Sql
			String sql = "select noStagiaire, nom, prenom, dateDeNaissance from stagiaires";
			ResultSet rs = unStml.executeQuery(sql);
			
			// R�cup�re les donn�es dans un String Builder
			StringBuilder sb = null;
			
			//It�re sur r�sult set
			while(rs.next()) // Tant qu'on a une ligne � afficher, on passe � la suivante
			{
				sb = new StringBuilder();
				sb.append("Num�ro de stagiaire: ");
				sb.append(rs.getInt("noStagiaire"));
				sb.append(", pr�nom: ");
				sb.append(rs.getString("prenom"));
				sb.append(", nom: ");
				sb.append(rs.getString("nom"));// avec getDate(columnInt)
				
				//Cr�e variable de type Date.sql avec getDate(columnLabel)
				@SuppressWarnings("unused")
				Date date = rs.getDate("dateDeNaissance");
				if(!rs.wasNull()) // if(date != null) autre m�thode
				{
					sb.append(", date de naissance");
					sb.append(rs.getDate("dateDeNaissance"));// la date peut �tre null
				}
				System.out.println(sb);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally // finally s'execute toujours: il faut toujours fermer la connexion 
		{
				// Ferme la connection � la DB
				JdbcTools.closeConnection(uneConnection);

		}
	}
}
