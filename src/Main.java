import enums.MediaType;
import people.*;
import medias.*;

import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        //Global Variables
        ArrayList<media> tabMedia = new ArrayList<media>();
        ArrayList<adherent> tabUsers = new ArrayList<adherent>();
        ArrayList<emprunt> tabEmprunts = new ArrayList<emprunt>();
        adherent.listeDesAdherents=tabUsers;
        media.listeDesMedias=tabMedia;
        emprunt.listeDesEmprunts=tabEmprunts;
//        cd cd1 = new cd("pes 2016",20,"jeux");
//        cd cd2 = new cd("pes 2015",20,"jeux");
//        cd cd3 = new cd("pes 2017",20,"jeux");
//        System.out.println(cd1.id);
//        System.out.println(cd2.id);
//        System.out.println(cd3.id);
        bibliothecaire Bib=new bibliothecaire("rafik","kasmi",'M',"2020",tabUsers,tabMedia);
        adherent adh1=new adherent("rafik","kasmi",'M',"2021");
        Bib.enregistrerAdherent(adh1);
        Bib.enregistrerAdherent(new adherent("mouloudia","kasmi",'M',"20215"));
        Bib.supprimerAdherent("20215");
        cd media1=new cd("pes 2016",1,"jeux","geo");
        Bib.enregistrerMedia(media1);
        Bib.enregistrerMedia(new livre("les miserables",20,50,"rarea","rear"));
        Bib.enregistrerMedia(new memoire("tamzight machine learning",20,"rafd","reawr"));
//        adherent.afficherTous();
//        for (adherent adh : tabUsers) {
//            System.out.println(adh.nom);
//        }
        adh1.consulter(1);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dob="17-07-2002";
        LocalDate date = LocalDate.parse("19/06/2022", df);


        adh1.emprunter(1,date);
        adh1.restituer(1);
        adh1.emprunter(99,date);
        adh1.restituer(19);
        adh1.emprunter(3,date);
        emprunt.afficherTous();
    }
}