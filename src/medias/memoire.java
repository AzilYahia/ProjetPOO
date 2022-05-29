package medias;

import enums.MediaType;
import people.adherent;

public class memoire extends media {
    //variables
    public String theme;
    public String Auteur;

    //constructors
    public memoire(String nom, int quota, String theme, String auteur) {
        super(nom, quota, MediaType.MEMOIRE);
        this.theme = theme;
        Auteur = auteur;
    }

}
