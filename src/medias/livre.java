package medias;

import people.adherent;

public class livre extends media{
    //variables
    public int nombrePages;
    public String reference;
    public String Auteur;

    //constructors
    public livre() {}
    public livre(int nombrePages, String reference, String auteur) {
        this.nombrePages = nombrePages;
        this.reference = reference;
        Auteur = auteur;
    }
    public livre(String nom, int quota, adherent emprunterPar, int nombrePages, String reference, String auteur) {
        super(nom, quota, emprunterPar);
        this.nombrePages = nombrePages;
        this.reference = reference;
        Auteur = auteur;
    }

}
