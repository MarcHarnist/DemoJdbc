package fr.eni.stagiaire.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.stagiaire.bo.Stagiaire;

public interface StagiaireDAO {
	
	List<Stagiaire> selectAll() throws SQLException;
	void insert(Stagiaire s);
	void update(Stagiaire s);
	void delete(Stagiaire s);
	Stagiaire selectById(int noStagiaire); // lit une ligne dans TABLE stagiaire, créer et retourner un objet de type Stagiaire

}
