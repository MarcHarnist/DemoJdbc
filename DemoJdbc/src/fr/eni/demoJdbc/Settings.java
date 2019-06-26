package fr.eni.demoJdbc;

import java.io.IOException;
import java.util.Properties;

public class Settings {
	
	//Attributs
	private static Properties properties;

	// Bloc d'initiatlisation static
	static {
		// Instancie l'attribut properties
		properties = new Properties(); 
		//Charge le fichier settings.properties
		try {
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key)
	{
		String parametres = properties.getProperty(key);
		return parametres;
	}

}
