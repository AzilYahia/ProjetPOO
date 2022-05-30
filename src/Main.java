import enums.Gender;
import menus.AdherentMenu;
import menus.BibliothecaireMenu;
import people.*;
import medias.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
Poo Projet
Done By :  Rafik Kasmi and Yahya Azil
Acad B
*/

public class Main {
     static void mainMenu(){
         System.out.println("Bienvenu Dans Notre Bibliotheque");
        System.out.println("-------------------------");
        System.out.println("Veuillez Selectionner Votre Role :");
        System.out.println("- Entrer 1 pour Bibliothecaire.");
         System.out.println("- Entrer 2 pour Adherent.");
         System.out.println("- Entrer 0 pour Quitter.");
    }
    public static void main(String[] args) {
        //Global Variables
        ArrayList<media> tabMedia = new ArrayList<media>();
        ArrayList<adherent> tabUsers = new ArrayList<adherent>();
        ArrayList<emprunt> tabEmprunts = new ArrayList<emprunt>();
        adherent.listeDesAdherents=tabUsers;
        media.listeDesMedias=tabMedia;
        emprunt.listeDesEmprunts=tabEmprunts;
        //dummy data
        BibliothecaireMenu.bib=new bibliothecaire("kasmi","rafik", Gender.MALE,"2020");
        BibliothecaireMenu.bib.enregistrerMedia(new cd("cours analyse",40,"rwre","trae"));
        BibliothecaireMenu.bib.enregistrerMedia(new livre("The 100$ Startup",40,250,"trae","Chris Guillebeau"));
        BibliothecaireMenu.bib.enregistrerMedia(new memoire("Deep Learning for tamazight",40,"A.I","Rafik Kasmi"));
        BibliothecaireMenu.bib.enregistrerAdherent(new adherent("Azil","Yahya",Gender.MALE,"007"));

        Scanner input = new Scanner(System.in);
        int roleChoice;
        do{
            mainMenu();
            roleChoice = input.nextInt();
            input.nextLine();
         switch (roleChoice){
             case 1:
                 BibliothecaireMenu.mainMenu();
                 break;
             case 2:
                 System.out.println("Entrer ton matricule :");
                 String matricule = input.nextLine();
                 adherent User=adherent.getAdherent(matricule);
                 if(User==null){
                     System.out.println("un Adherent avec ce matricule n'existe pas !");
                     break;
                 }
                 //setting the user in the adherent menu
                 AdherentMenu.adh=User;
                 AdherentMenu.mainMenu();
                 break;
             default:
                 break;
         }
        }while(roleChoice != 0);

    }
}