package medias;

import enums.MediaType;
import people.adherent;
import people.emprunt;

import java.util.ArrayList;
import java.util.Date;

public abstract class media {
    //variables
    public static ArrayList<media> listeDesMedias;
    private static int counter = 1;
    public int id;
    public String nom;
    public  int quota;
    private boolean disponible;
    public  adherent emprunterPar;
    private Date dateLimite;
    public MediaType type;

    //constructor
    public media(String nom, int quota,MediaType type) {
        id=counter;
        counter++;
        this.nom = nom;
        this.quota = quota;
        this.type=type;
    }



    //getter and setter

    public boolean isDisponible() {
        return quota!=0;
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
    //methods
    public static media getMedia(int id){
        for(media media : listeDesMedias){
            if(media.id==id) {
                return media;
            }
        }
        return null;
    }
    public static void afficherTous(){
        if(listeDesMedias.isEmpty()){
            System.out.println("La Listes des medias est vide pour l'instant");
            return;
        }

        System.out.println("+------+----------------------+-------+---------+");
        System.out.println("|  ID  |      Nom             | Quota |   Type  |");
        System.out.println("+------+----------------------+-------+---------+");
        String leftAlignFormat = "| %-4d | %-20s | %-4d | %-7s |%n";
        for (media med : listeDesMedias) {
            System.out.format(leftAlignFormat, med.id, med.nom , med.quota , med.type);
        }
        System.out.println("+------+----------------------+-------+---------+");
    }
}
