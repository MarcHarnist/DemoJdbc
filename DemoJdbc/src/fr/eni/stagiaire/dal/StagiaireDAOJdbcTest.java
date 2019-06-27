package fr.eni.stagiaire.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.stagiaire.bo.Stagiaire;
import fr.eni.stagiaire.dal.jdbc.StagiaireDAOJdbcImpl;

public class StagiaireDAOJdbcTest {

	public static void main(String[] args) throws SQLException {
		StagiaireDAOJdbcImpl stagiaireDAO = new StagiaireDAOJdbcImpl();
		List<Stagiaire> listeStagiaire = stagiaireDAO.selectAll();
		
		for(Stagiaire s:listeStagiaire)
		{
			System.out.println(s);
		}
	}

}
