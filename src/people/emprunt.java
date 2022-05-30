package people;

import medias.media;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class emprunt {
    public static ArrayList<emprunt> listeDesEmprunts;
    public adherent emprunteur;
    public media emprunte;
    private LocalDate dateDuRetourPrevue;

    public emprunt(adherent emprunteur, media emprunte, LocalDate dateDuRetourPrevue){
        this.emprunteur=emprunteur;
        this.emprunte=emprunte;
        this.dateDuRetourPrevue=dateDuRetourPrevue;
    }

    public static void afficherTous(){
        for (emprunt emp : listeDesEmprunts) {
            System.out.println(emp.emprunte.nom+"/" +emp.dateDuRetourPrevue);
        }
    }
    public static emprunt getEmprunt(int idMedia,String matriculeAdh){
        for (emprunt emp : listeDesEmprunts) {
            if(emp.emprunte.id==idMedia && emp.emprunteur.matricule.equals(matriculeAdh))
                return emp;
        }
        return null;
    }
    public boolean estTard(){
        LocalDate now = LocalDate.now();
        LocalDate dernierDelai=this.dateDuRetourPrevue.plusDays(10);
        long diffDesJours = DAYS.between(now,dernierDelai);
        System.out.println("vous etes en retard de "+ diffDesJours+" jours");
        return diffDesJours<0;
    }


}
