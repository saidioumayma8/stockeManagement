package net.javaguides.productmanagement.model;

public class product {
	private int id;
	private String nom;
	private String description;
	private int quantite;
	private double prix; // Correct naming
	
	public product(int id, String nom, String description, int quantite, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.quantite = quantite;
		this.prix = prix;
	}
	
	
	public product(String nom, String description, int quantite, double prix) {
		super();
		this.nom = nom;
		this.description = description;
		this.quantite = quantite;
		this.prix = prix;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	


}
