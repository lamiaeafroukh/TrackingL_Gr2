package ma.fstt.model;

import java.util.Date;

public class Commande {
    private Long id;
    private Date date;

    private Produit[] produits;

    // constructeur de la classe
    public Commande(Long id, Date date, Produit[] produits) {
        this.id = id;
        this.date = date;

        this.produits = produits;
    }

    public Commande(long id, Date date) {
        this.id=id;
        this.date=date;
    }

    // méthodes getter et setter pour les attributs
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public Produit[] getProduits() {
        return produits;
    }

    public void setProduits(Produit[] produits) {
        this.produits = produits;
    }


}

