package Pepenaire.Domain;

public class Pepenaire {
	private int id;
	private String nom,cate;
	public int getId() {
		return id;
	}
	
	public Pepenaire(String nom, String cate) {
		super();
		this.nom = nom;
		this.cate = cate;
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
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public Pepenaire() {
		super();
	}
	public Pepenaire(int id, String nom, String cate) {
		super();
		this.id = id;
		this.nom = nom;
		this.cate = cate;
	}
	

}
