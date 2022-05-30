package menus;

import medias.media;
import people.adherent;
import people.emprunt;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AdherentMenu {
    public static adherent adh;
    private static Scanner input = new Scanner(System.in);
    static void printMenuHeader(){
        System.out.println("Bonjour "+adh.nom+" au menu des adherents :");
        System.out.println("-------------------------");
        System.out.println("- Entrer 1 pour Consulter Tous les Medias disponibles.");
        System.out.println("- Entrer 2 pour Consulter un media specifique.");
        System.out.println("- Entrer 3 pour Emprunter un media.");
        System.out.println("- Entrer 4 pour Restituer un media.");
        System.out.println("- Entrer 0 pour Quitter.");
    }
    public static void mainMenu(){
        printMenuHeader();
        int roleChoice;
        do{
            System.out.println("------------ Entrer 99 pour rafficher le menu ------------");
            roleChoice = input.nextInt();
            input.nextLine();
            switch (roleChoice){
                case 1:
                    media.afficherTous();
                    break;
                case 2:
                    consulterMedia();
                    break;
                case 3:
                    emprunterMedia();
                    break;
                case 4:
                    restituerMedia();
                    break;
                case 99:
                    printMenuHeader();
                    break;
                default:
                    break;
            }
        }while(roleChoice != 0);
    }
    //helper functions
    static int readIntFromConsole(){
        System.out.println("Entrer le ID de media :");
        int id=input.nextInt();
        input.nextLine();
        return id;
    }
    //menu methods
    static void consulterMedia(){
        int id=readIntFromConsole();
        media med = media.getMedia(id);
        if(med == null){
            System.out.println("Media n'existe pas !");
            return;
        }
        adh.consulter(med);
    }
    static void emprunterMedia(){
        int id=readIntFromConsole();
        media med = media.getMedia(id);
        if(med == null){
            System.out.println("Media n'existe pas !");
            return;
        }
        if (!med.isDisponible()){
            System.out.println("Media non disponible !");
            return;
        }
        if(adh.isDansListeNoire()){
            System.out.println("Vous etes dans la liste noire ! ");
            return;
        }
        if(emprunt.getEmprunt(id,adh.matricule)!=null){
            System.out.println("Ce media is deja chez vous !");
            return;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Entrer la date de retour prévue (de type dd/mm/yyyy):");
        String dateStr=input.nextLine();
        LocalDate date = LocalDate.parse(dateStr, df);
        adh.emprunter(med,date);
        System.out.println("Emprunt Creé avec succes, veuillez le retourner au maximum 9 jours apres la date prévue");
    }
    static void restituerMedia(){
        int id=readIntFromConsole();
        emprunt emp=emprunt.getEmprunt(id,adh.matricule);
        if(emp == null){
            System.out.println("Vous n'avez jamais emprunté ce media !");
            return;
        }
        if(emp.estTard()){
            System.out.println("Vous avez remis l'emprunt en retard , Vous faites parti de la liste noire maintenant !");
            adh.setDansListeNoire(true);
        }else{
            System.out.println("Vous avez remis l'emprunt dans le temps , Merciii!");

        }
        adh.restituer(emp);
    }
}
