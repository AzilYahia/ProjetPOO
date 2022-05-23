package people;

import medias.media;

public  class bibliothecaire extends person{
    //constructors
    bibliothecaire(){}
    public bibliothecaire(String nom, String prenom) {
        super(nom, prenom);
    }
    public bibliothecaire(String nom, String prenom, char gender)
    {
        super(nom, prenom, gender);
    }
    public bibliothecaire(String nom, String prenom, char gender, String matricule) {
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
    public void ajouterAListeNoire(adherent adh) {
        if(!adh.isDansListeNoire()) {
            listeNoire[current] = adh;
            adh.setDansListeNoire(true);
            current++;
        }
    }
    public void supprimerListeNoire(adherent adh) {
        if (adh.isDansListeNoire()) {
            listeNoire[current] = null;
            current--;
            adh.setDansListeNoire(false);
        }
    }

    void enregistrer(adherent adh){}

    void enregistrer(media med){}

    void modifier(adherent adh){}

    void modifier(media med){}

    void supprimer(adherent adh){}

    void supprimer(media med){}

    void afficherListeNoire(){
        for(int i =0; i< current; i++)
        {
            System.out.println("l'adherent : " +listeNoire[i].nom +" "+ listeNoire[i].prenom+" est  dans la liste noire.");
        }
    }

}
