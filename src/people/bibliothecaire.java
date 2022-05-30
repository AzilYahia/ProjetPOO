package people;

import enums.Gender;
import medias.cd;
import medias.livre;
import medias.media;
import medias.memoire;

import java.util.ArrayList;

public  class bibliothecaire extends person{
    //constructors
    public bibliothecaire(String nom, String prenom, Gender gender, String matricule) {
        super(nom, prenom, gender, matricule);
    }

    //variables
    private int current=0;
    private adherent[] listeNoire;

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

        adherent.listeDesAdherents.add(newAdh);
    }

    public void modifierAdherent(adherent adh, String newNom, String newPrenom, Gender newGender){
        adh.nom=(!newNom.equals("")) ? newNom : adh.nom;
        adh.prenom=(!newPrenom.equals("")) ? newPrenom : adh.prenom;
        adh.gender=newGender ;
    }

    public void supprimerAdherent(adherent adh){
                //supprimer les emprunts de l'adherent et l'adherent lui meme
        for (emprunt emp : emprunt.listeDesEmprunts) {
            if(emp.emprunteur.matricule.equals(adh.matricule))
                emprunt.listeDesEmprunts.remove(emp);
        }
        adherent.listeDesAdherents.remove(adh);
    }

    //manipulate les medias


    public void enregistrerMedia(media newMedia){
        media.listeDesMedias.add(newMedia);
    }

    //modifer
    private void modifierMedia(media med,String newNom, int newQuota ) {
        med.nom = (!newNom.equals("")) ? newNom : med.nom;
        med.quota = (newQuota != -1) ? newQuota : med.quota;
    }
    public void modifierMediaCD(media med,String newNom, int newQuota,String newProfRecord,String newTheme ){
        //cd
        modifierMedia(med,newNom,newQuota);
        cd element = (cd) med;
         element.profRecord=(!newProfRecord.equals("")) ? newProfRecord : element.profRecord;
         element.theme=(!newTheme.equals("")) ? newTheme : element.theme;
     }
    public void modifierMediaMemoire(media med,String newNom, int newQuota,String newTheme,String newAut ){
        //memoire
        modifierMedia(med,newNom,newQuota);
        memoire element=(memoire) med;
        element.theme=(!newTheme.equals("")) ? newTheme : element.theme;
        element.Auteur=(!newAut.equals("")) ? newAut : element.Auteur;
    }
    public void modifierMediaLivre(media med,String newNom, int newQuota, int newNbrPages ,String newRef,String newAut ){
        //livre
        modifierMedia(med,newNom,newQuota);
        livre element=(livre) med;
        element.nombrePages = (newNbrPages != -1) ? newNbrPages : element.nombrePages;
        element.reference=(!newRef.equals("")) ? newRef : element.reference;
        element.Auteur=(!newAut.equals("")) ? newAut : element.Auteur;
    }

    public void supprimerMedia(media med){

        media.listeDesMedias.remove(med);
    }

    public  void afficherListeNoire(){

            System.out.println("La Listes noire :");
            System.out.println("+----------+----------------------+---------+");
            System.out.println("|    mat   |      Nom Et Prenom   |   Sexe  |");
            System.out.println("+----------+----------------------+---------+");
            String leftAlignFormat = "| %-8s | %-20s | %-7s |%n";
            for (adherent adh : adherent.listeDesAdherents) {
                if(adh.isDansListeNoire())
                    System.out.format(leftAlignFormat, adh.matricule, adh.nom + " "+ adh.prenom , adh.gender);
            }
            System.out.println("+----------+----------------------+---------+");
    }

}
