package people;

public abstract class person {
    //variables
    String nom;
    String prenom;
    char gender;
    String matricule;

    //constructors
    person(){}
    public person(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public person(String nom, String prenom, char gender) {
        this.nom = nom;
        this.prenom = prenom;
        this.gender = gender;
    }

    public person(String nom, String prenom, char gender, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.gender = gender;
        this.matricule = matricule;
    }
}
