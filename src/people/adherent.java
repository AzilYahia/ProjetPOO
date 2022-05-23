package people;
import medias.media;
import java.util.Date;

public class adherent extends person{

    //constructors
    adherent(){}
    public adherent(String nom, String prenom) {
        super(nom, prenom);
    }
    public adherent(String nom, String prenom, char gender) {
        super(nom, prenom, gender);
    }
    public adherent(String nom, String prenom, char gender, String matricule) {
        super(nom, prenom, gender, matricule);
    }

    //variables
    Date dateEmprunt;
    private boolean dansListeNoire = false;

    //getters & setters
    public boolean isDansListeNoire() {
        return dansListeNoire;
    }

    public void setDansListeNoire(boolean dansListeNoire) {
        this.dansListeNoire = dansListeNoire;
    }

    //methods
    void consulter(media med){}

    void restituer(media med){}

    void emprunter(media med){}

}
