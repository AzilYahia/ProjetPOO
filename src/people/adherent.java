package people;
import medias.media;

import java.time.LocalDate;
import java.util.ArrayList;

public class adherent extends person{

    //constructors

    public adherent(String nom, String prenom, char gender, String matricule) {
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
    public static void afficherTous(){
        for (media media : media.listeDesMedias) {
            System.out.println(media.nom);
        }
    }
    public void consulter(int id){
        media med = media.getMedia(id);
        if(med == null){
            return;
        }
        System.out.println("MEDIA HOUWA :"+med.nom);
    }

    public void emprunter(int id, LocalDate dateDuRetour){
        media med = media.getMedia(id);
        if(med == null){
            System.out.println("Media n'existe pas !");
            return;
        }
        if (!med.isDisponible()){
            System.out.println("Media non disponible !");
            return;
        }
        if(this.dansListeNoire){
            System.out.println("Vous etes dans la liste noire ! ");
            return;
        }
        if(emprunt.getEmprunt(id,this.matricule)!=null) return;
        emprunt newEmprunt=new emprunt(this,med,dateDuRetour);
        emprunt.listeDesEmprunts.add(newEmprunt);
        med.quota--;
    }

    public void restituer(int id){
        emprunt emp=emprunt.getEmprunt(id,this.matricule);
        if(emp == null){
            System.out.println("Vous n'avez jamais emprunté ce media !");
            return;
        }
        if(emp.estTard()){
            System.out.println("Jebtha retard kho !");
            emp.emprunteur.setDansListeNoire(true);
        }
        emp.emprunte.quota++;
    }


}
