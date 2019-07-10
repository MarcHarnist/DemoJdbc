package fr.eni.stagiaire.bo;

public class Stagiaire {
	
	private int noStagiaire;
	private String prenom;
	private String nom;
	private String motDePasse;
	
	/** Constructeur
	 * @param noStagiaire
	 * @param prenom
	 * @param nom
	 * @param motDePasse
	 */
	public Stagiaire(int noStagiaire, String prenom, String nom, String motDePasse) {
		super();
		this.noStagiaire = noStagiaire;
		this.prenom = prenom;
		this.nom = nom;
		this.motDePasse = motDePasse;
	}
	/**
	 * 
	 */
	public Stagiaire() {
		super();
	}
	public int getNoStagiaire() {
		return noStagiaire;
	}
	public void setNoStagiaire(int noStagiaire) {
		this.noStagiaire = noStagiaire;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stagiaire [noStagiaire=");
		builder.append(noStagiaire);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", motDePasse=");
		builder.append(motDePasse);
		builder.append(", getNoStagiaire()=");
		builder.append(getNoStagiaire());
		builder.append(", getPrenom()=");
		builder.append(getPrenom());
		builder.append(", getNom()=");
		builder.append(getNom());
		builder.append(", getMotDePasse()=");
		builder.append(getMotDePasse());
		builder.append("]");
		return builder.toString();
	}
	
	

}
