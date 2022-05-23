package medias;

import people.adherent;

public class cd extends media{
    //variables
    public String profRecord;
    public String theme;

    //constructors
    public cd() {}
    public cd(String nom, int quota, String profRecord, String theme) {
        super(nom, quota);
        this.profRecord = profRecord;
        this.theme = theme;
    }
    public cd(String nom, int quota, String theme) {
        super(nom, quota);
        this.theme = theme;
    }
    public cd(String nom, int quota, adherent emprunterPar, String theme) {
        super(nom, quota, emprunterPar);
        this.theme = theme;
    }
    public cd(String nom, int quota, adherent emprunterPar, String profRecord, String theme) {
        super(nom, quota, emprunterPar);
        this.profRecord = profRecord;
        this.theme = theme;
    }


}
