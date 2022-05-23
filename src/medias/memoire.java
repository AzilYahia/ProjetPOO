package medias;

import people.adherent;

public class memoire extends media {
    //variables
    public String theme;
    public String Auteur;

    //constructors
    public memoire() {}
    public memoire(String nom, int quota, String theme, String auteur) {
        super(nom, quota);
        this.theme = theme;
        Auteur = auteur;
    }
    public memoire(String nom, int quota, adherent emprunterPar, String theme, String auteur) {
        super(nom, quota, emprunterPar);
        this.theme = theme;
        Auteur = auteur;
    }
}
