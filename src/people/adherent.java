package people;
import enums.Gender;
import medias.cd;
import medias.livre;
import medias.media;
import medias.memoire;

import java.time.LocalDate;
import java.util.ArrayList;

public class adherent extends person{

    //constructors

    public adherent(String nom, String prenom, Gender gender, String matricule) {
        super(nom, prenom, gender, matricule);
    }

    //variables
    public static ArrayList<adherent> listeDesAdherents;
    private boolean dansListeNoire = false;



    //getters & setters
    public boolean isDansListeNoire() {
        return dansListeNoire;
    }

    public void setDansListeNoire(boolean dansListeNoire) {
        this.dansListeNoire = dansListeNoire;
    }

    //methods
    public static adherent getAdherent(String matricule){
        for(adherent adh : listeDesAdherents){
            if(adh.matricule.equals(matricule)) {
                return adh;
            }
        }
        return null;
    }
    public void consulter(media med){
        switch (med.type){
            case CD:
                cd CD=(cd) med;
                String cdFormat = "| %-4d | %-20s | %-5d | %-9s | %-8s | %-8s |%n";
                System.out.println("+------+----------------------+-------+-----------+--------------------+");
                System.out.println("|  ID  |      Nom             | Quota |   Type  |   Record  |   Theme  |");
                System.out.println("+------+----------------------+-------+-----------+--------------------+");
                System.out.format(cdFormat, CD.id, CD.nom , CD.quota , CD.type,CD.profRecord,CD.theme);
                System.out.println("+------+----------------------+-------+-----------+--------------------+");
                break;
            case LIVRE:
                livre LIVRE=(livre) med;
                String livreFormat = "| %-4d | %-20s | %-5d | %-7s | %-5d | %-6s | %-9s |%n";
                System.out.println("+------+----------------------+-------+---------+-------+--------+-----------+");
                System.out.println("|  ID  |      Nom             | Quota |   Type  | Pages |   Ref  |   Auteur  |");
                System.out.println("+------+----------------------+-------+---------+-------+--------+-----------+");
                System.out.format(livreFormat, LIVRE.id, LIVRE.nom , LIVRE.quota , LIVRE.type,LIVRE.nombrePages,LIVRE.reference, LIVRE.Auteur);
                System.out.println("+------+----------------------+-------+---------+-------+--------+-----------+");
                break;
            case MEMOIRE:
                memoire MEMOIRE=(memoire) med;
                String memoireFormat = "| %-4d | %-20s | %-5d | %-9s | %-8s | %-9s |%n";
                System.out.println("+------+----------------------+-------+---------+----------+-----------+");
                System.out.println("|  ID  |      Nom             | Quota |   Type  |   Theme  |   Auteur  |");
                System.out.println("+------+----------------------+-------+---------+----------+-----------+");
                System.out.format(memoireFormat, MEMOIRE.id, MEMOIRE.nom , MEMOIRE.quota , MEMOIRE.type,MEMOIRE.theme,MEMOIRE.Auteur);
                System.out.println("+------+----------------------+-------+---------+----------+-----------+");
                break;
        }
    }

    public void emprunter(media med, LocalDate dateDuRetour){
        emprunt newEmprunt=new emprunt(this,med,dateDuRetour);
        emprunt.listeDesEmprunts.add(newEmprunt);
        med.quota--;
    }

    public void restituer(emprunt emp){
        emp.emprunte.quota++;
        emprunt.listeDesEmprunts.remove(emp);
    }

    public static void afficherTous(){
        if(listeDesAdherents.isEmpty()){
            System.out.println("La Listes des adherents est vide pour l'instant");
            return;
        }

        System.out.println("+----------+----------------------+---------+");
        System.out.println("|    mat   |      Nom Et Prenom   |   Sexe  |");
        System.out.println("+----------+----------------------+---------+");
        String leftAlignFormat = "| %-8s | %-20s | %-7s |%n";
        for (adherent adh : listeDesAdherents) {
            System.out.format(leftAlignFormat, adh.matricule, adh.nom + " "+ adh.prenom , adh.gender);
        }
        System.out.println("+----------+----------------------+---------+");
    }


}
