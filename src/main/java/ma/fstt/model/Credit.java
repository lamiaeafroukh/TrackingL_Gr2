package ma.fstt.model;
import java.util.Date;

public class Credit {
    private Long id;
    private double montant;
    private double tauxInteret;
    private int duree;
    private Date DateCredit;
    private Date dateDebutRemboursement;


    // constructeur de la classe
    public Credit(Long id, double montant, double tauxInteret, int duree,Date DateCredit ,Date dateDebutRemboursement) {
        this.id = id;
        this.montant = montant;
        this.tauxInteret = tauxInteret;
        this.duree = duree;
        this.dateDebutRemboursement = dateDebutRemboursement;
        this.DateCredit = DateCredit;
    }

    // méthodes getter et setter pour les attributs
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setDateCredit(Date DateCredit){
        this.DateCredit=DateCredit;
    }
    public Date getDateCredit(){
        return this.DateCredit;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDateDebutRemboursement() {
        return dateDebutRemboursement;
    }

    public void setDateDebutRemboursement(Date dateDebutRemboursement) {
        this.dateDebutRemboursement = dateDebutRemboursement;
    }



}


