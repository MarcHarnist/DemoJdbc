package fr.eni.stagiaire.dal;

import fr.eni.stagiaire.dal.jdbc.StagiaireDAOJdbcImpl;

public class DAOFactory {
	
	public static StagiaireDAO getStagiaireDAO() {
		StagiaireDAO stagiaireDAO = new StagiaireDAOJdbcImpl();
		return stagiaireDAO;
	}
}
