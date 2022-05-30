package menus;

import enums.Gender;
import enums.MediaType;
import medias.cd;
import medias.livre;
import medias.media;
import medias.memoire;
import people.adherent;
import people.bibliothecaire;

import java.util.Scanner;

public class BibliothecaireMenu {
    public static bibliothecaire bib;
    private static Scanner input = new Scanner(System.in);
    static void printMenuHeader(){
        System.out.println("Bonjour au menu de Bibliothecaire:");
        System.out.println("-------------------------");
        System.out.println("- Entrer 1 pour Consulter Tous les Medias.");
        System.out.println("- Entrer 2 pour Consulter Tous les Adherent.");
        System.out.println("- Entrer 3 pour Ajouter un adherent.");
        System.out.println("- Entrer 4 pour Modifer un adherent.");
        System.out.println("- Entrer 5 pour Supprimer un adherent.");
        System.out.println("- Entrer 6 pour Ajouter un media.");
        System.out.println("- Entrer 7 pour Modifer un media.");
        System.out.println("- Entrer 8 pour Supprimer un media.");
        System.out.println("- Entrer 9 pour Afficher la liste noire.");
        System.out.println("- Entrer 10 pour Supprimer la liste noire.");
        System.out.println("- Entrer 0 pour Quitter.");
    }
    public static void mainMenu(){

        printMenuHeader();
        int roleChoice;
        do{
            System.out.println("------------ Entrer 99 pour rafficher le menu ------------");
            roleChoice = input.nextInt();
            input.nextLine(); //consumes last nextInt
            switch (roleChoice){
                case 1:
                    media.afficherTous();
                    break;
                case 2:
                    adherent.afficherTous();
                    break;
                case 3:
                    ajouterAdherent();
                    break;
                case 4:
                    modiferAdherent();
                    break;
                case 5:
                    supprimerAdherent();
                    break;
                case 6:
                    ajouterMedia();
                    break;
                case 7:
                    modiferMedia();
                    break;
                case 8:
                    supprimerMedia();
                    break;
                case 9:
                    bib.afficherListeNoire();
                    break;
                case 10:
                    supprimerDeListeNoire();
                    break;
                case 99:
                    printMenuHeader();
                    break;
                default:
                    break;
            }
        }while(roleChoice != 0);
    }
    //methods des menus
    //adherent
    static void ajouterAdherent(){
        System.out.println("Entrer un matricule :");
        String matricule=input.nextLine();
        adherent adh = adherent.getAdherent(matricule);
        if(adh != null) {
            System.out.println("un adherent existe deja avec le meme matricule !");
            return;
        }
        System.out.println("Entrer le le nom d'adherent :");
        String nom=input.nextLine();
        System.out.println("Entrer le le prenom d'adherent :");
        String prenom=input.nextLine();
        System.out.println("Entrer le le sexe d'adherent (f ou m) :");
        String sexeStr=input.next();
        Gender sexe= Gender.fromString(sexeStr);
        bib.enregistrerAdherent(new adherent(nom,prenom,sexe,matricule));
        System.out.println("Adherent ajouté avec succes !");
    }
    static void modiferAdherent() {
        System.out.println("Entrer un matricule :");
        String matricule=input.nextLine();
        adherent adh = adherent.getAdherent(matricule);
        if(adh == null) {
            System.out.println("aucun adherent n'existe avec ce matricule !");
            return;
        }
        System.out.println("Entrer le nouveau nom d'adherent (laisser vide pour garder la valeur precedente) :");
        String nom=input.nextLine();
        System.out.println("Entrer le nouveau prenom (laisser vide pour garder la valeur precedente) :");
        String prenom=input.nextLine();
        System.out.println("Entrer le nouveau sexe d'adherent (f ou m) :");
        String sexeStr=input.next();
        Gender sexe= Gender.fromString(sexeStr);
        bib.modifierAdherent(adh,nom,prenom,sexe);
        System.out.println("Adherent modifié avec succes !");
    }
    static void supprimerAdherent() {
        System.out.println("Entrer le matricule :");
        String matricule=input.nextLine();
        adherent adh = adherent.getAdherent(matricule);
        if(adh == null) {
            System.out.println("aucun adherent n'existe avec ce matricule !");
            return;
        }
        bib.supprimerAdherent(adh);
        System.out.println("Adherent supprimé avec succes !");
    }
    //media
    static void ajouterMedia(){
        MediaType type;
        do{
            System.out.println("Selectionner le type du media (1 pour CD , 2 pour Livre, 3 pour Memoire) :");
            int typeNum=input.nextInt();
            input.nextLine();
            type=MediaType.fromNum(typeNum);
        }while (type==null);
        System.out.println("Entrer le nom de media :");
        String nom=input.nextLine();
        System.out.println("Entrer le quota :");
        int quota=input.nextInt();
        input.nextLine();
        String theme,auteur;
        switch (type){
            case CD:
                System.out.println("Entrer le createur de ce CD :");
                String profRecord=input.nextLine();
                System.out.println("Entrer le theme de cd :");
                theme=input.nextLine();
                bib.enregistrerMedia(new cd(nom,quota,profRecord,theme));
                break;
            case LIVRE:
                System.out.println("Entrer le nombre des pages de ce livre :");
                int nbrPages=input.nextInt();
                input.nextLine();
                System.out.println("Entrer la reference :");
                String reference=input.nextLine();
                System.out.println("Entrer le nom de l'auteur :");
                auteur=input.nextLine();
                bib.enregistrerMedia(new livre(nom,quota,nbrPages,reference,auteur));
                break;
            case MEMOIRE:
                System.out.println("Entrer le theme de ce memoire :");
                theme=input.nextLine();
                System.out.println("Entrer l'auteur :");
                auteur=input.nextLine();
                bib.enregistrerMedia(new memoire(nom,quota,theme,auteur));
                break;
            default:
                break;
        }
        System.out.println("Media ajouté avec succes !");
    }
    static void modiferMedia() {
        System.out.println("Entrer le ID de media :");
        int id=input.nextInt();
        input.nextLine();
        media med = media.getMedia(id);
        if(med == null){
            System.out.println("Media n'existe pas !");
            return;
        }
        System.out.println("-------(laisser vide pour garder la valeur precedente)-------");
        System.out.println("Entrer le nouveau nom de media :");
        String nom=input.nextLine();
        System.out.println("Entrer le nouveau quota (entrer -1 pour garder l'ancienne valeur) :");
        int quota=input.nextInt();
        input.nextLine();
        String theme,auteur;
        switch (med.type){
            case CD:
                cd CD= (cd) med;
                System.out.println("Entrer le nouveau createur de ce CD :");
                String profRecord=input.nextLine();
                System.out.println("Entrer le nouveau theme de cd :");
                theme=input.nextLine();
                bib.modifierMediaCD(med,nom,quota,profRecord,theme);
                break;
            case LIVRE:
                System.out.println("Entrer le nouveau nombre des pages de ce livre  (entrer -1 pour garder l'ancienne valeur) :");
                int nbrPages=input.nextInt();
                input.nextLine();
                System.out.println("Entrer la nouvelle reference :");
                String reference=input.nextLine();
                System.out.println("Entrer le nom de l'auteur :");
                auteur=input.nextLine();
                bib.modifierMediaLivre(med,nom,quota,nbrPages,reference,auteur);
                break;
            case MEMOIRE:
                System.out.println("Entrer le nouveau theme de ce memoire :");
                theme=input.nextLine();
                System.out.println("Entrer le nouveau auteur :");
                auteur=input.nextLine();
                bib.modifierMediaMemoire(med,nom,quota,theme,auteur);
                break;
            default:
                break;
        }
        System.out.println("Media modifié avec succes !");
    }
    static void supprimerMedia() {
        System.out.println("Entrer le id de media :");
        int id=input.nextInt();
        input.nextLine();
        media med = media.getMedia(id);
        if(med == null){
            System.out.println("Media n'existe pas !");
            return;
        }
        bib.supprimerMedia(med);
        System.out.println("Media supprimé avec succes !");
    }
    static void supprimerDeListeNoire(){
        System.out.println("Entrer le matricule :");
        String matricule=input.nextLine();
        adherent adh = adherent.getAdherent(matricule);
        if(adh == null) {
            System.out.println("aucun adherent n'existe avec ce matricule !");
            return;
        }
        if(adh.isDansListeNoire()){
            adh.setDansListeNoire(false);
            System.out.println(adh.nom+" a eté supprimé de la liste noir !");
            return;
        }
        System.out.println("cet utilisateur n'existe pas dans la liste noire");
    }
}
