package medias;

import people.adherent;

import java.util.Date;

public abstract class media {
    //variables
    public String nom;
    public  int quota;
    private boolean disponible;
    public  adherent emprunterPar;
    private Date dateLimite;

    //constructor
    public media() {}
    public media(String nom, int quota) {
        this.nom = nom;
        this.quota = quota;
    }
    public media(String nom, int quota, adherent emprunterPar) {
        this.nom = nom;
        this.quota = quota;
        this.emprunterPar = emprunterPar;
    }


    //getter and setter
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public Date getDateLimite() {
        return dateLimite;
    }
    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }
}
