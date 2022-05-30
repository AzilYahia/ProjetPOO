package people;

import enums.Gender;

public abstract class person {
    //variables
    public String nom;
    public String prenom;
    public Gender gender;
    public String matricule;

    //constructors

    public person(String nom, String prenom, Gender gender, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.gender = gender;
        this.matricule = matricule;
    }
}
