package people;

import medias.media;

public abstract class bibliothecaire extends person{
    private int current=0;
    private adherent[] listeNoire;

    public adherent[] getListeNoire() {
        return listeNoire;
    }

    public void ajouterAListeNoire(adherent adh) {
        listeNoire[current] = adh;
      current++;
    }
    public void supprimerListeNoire(adherent adh) {
        listeNoire[current] = null;
        current--;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    void enregistrer(adherent adh){};
    void enregistrer(media med){};
    void modifier(adherent adh){};
    void modifier(media med){};
    void supprimer(adherent adh){};
    void supprimer(media med){};

     void afficherListeNoire(){
        for(int i =0; i< current; i++)
        {
            System.out.println("l'adherent : " +listeNoire[i].nom +" "+ listeNoire[i].prenom+" est  dans la liste noire.");
        }
    };

}
