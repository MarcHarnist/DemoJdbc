package fr.eni.stagiaire.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.stagiaire.bo.Stagiaire;

public class StagiaireDAOJdbcTest {

	public static void main(String[] args) throws SQLException {
		StagiaireDAO stagiaireDAO = DAOFactory.getStagiaireDAO();
		List<Stagiaire> listeStagiaire = stagiaireDAO.selectAll();
		
		for(Stagiaire s:listeStagiaire)
		{
			System.out.println(s);
		}
	}

}
