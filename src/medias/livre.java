package medias;

import enums.MediaType;
import people.adherent;

public class livre extends media{
    //variables
    public int nombrePages;
    public String reference;
    public String Auteur;

    //constructors

    public livre(String nom, int quota, int nombrePages, String reference, String auteur) {
        super(nom, quota, MediaType.LIVRE);
        this.nombrePages = nombrePages;
        this.reference = reference;
        Auteur = auteur;
    }

}
