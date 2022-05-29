package people;
import medias.media;

import java.util.ArrayList;

public  class bibliothecaire extends person{
    //constructors

    public bibliothecaire(String nom, String prenom, char gender, String matricule,ArrayList<adherent> listeDesAdherents,ArrayList<media> listeDesMedias) {

        super(nom, prenom, gender, matricule);
        this.listeDesAdherents=listeDesAdherents;
        this.listeDesMedias=listeDesMedias;
    }

    //variables
    private int current=0;
    private adherent[] listeNoire;
    private ArrayList<media> listeDesMedias;
    private ArrayList<adherent> listeDesAdherents;

    //getters
    public adherent[] getListeNoire() {
        return listeNoire;
    }
    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    //methods

    //manipulate les adherents

    public void enregistrerAdherent(adherent newAdh){
        adherent adh = adherent.getAdherent(newAdh.matricule);
        if(adh != null) {
            System.out.println("un adherent existe deja avec le meme matricule !");
            return;
        }
        listeDesAdherents.add(newAdh);
    }

    public void modifierAdherent(String matricule, String newNom, String newPrenom, char newGender){
        adherent adh = adherent.getAdherent(matricule);
        if(adh == null) {
            return;
        }
        adh.nom=(!newNom.equals("")) ? newNom : adh.nom;
        adh.prenom=(!newPrenom.equals("")) ? newPrenom : adh.prenom;
        adh.gender=(newGender == ' ') ? newGender : adh.gender;
    }

    public void supprimerAdherent(String matricule){
        adherent adh = adherent.getAdherent(matricule);
        if(adh == null) {
            return;
        }
        listeDesAdherents.remove(adh);
    }

    //manipulate les medias


    public void enregistrerMedia(media newMedia){
        listeDesMedias.add(newMedia);
    }

    public void modifierMedia(int id){
        media med = media.getMedia(id);
        if(med == null) {
            return;
        }
//        media.nom=(!newNom.equals("")) ? newNom : adherent.nom;
//        adherent.prenom=(!newPrenom.equals("")) ? newPrenom : adherent.prenom;
//        adherent.gender=(newGender == ' ') ? newGender : adherent.gender;
    }

    public void supprimerMedia(int id){
        media med = media.getMedia(id);
        if(med == null) {
            return;
        }
        listeDesMedias.remove(med);
    }

    void afficherListeNoire(){
        for(int i =0; i< current; i++)
        {
            System.out.println("l'adherent : " +listeNoire[i].nom +" "+ listeNoire[i].prenom+" est  dans la liste noire.");
        }
    }

}
