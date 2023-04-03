package ma.fstt.model;
public class Produit {
    private Long Num_PRD;
    private String nom;
    private double prix;
    private int quantite;

    // constructeur de la classe
    public Produit(String nom, double prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    // méthodes getter et setter pour les attributs
    public Long getNum_PRD(){return Num_PRD;}
    public void setNum_PRD(Long Num_CMD){this.Num_PRD=Num_CMD;}
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }




}




