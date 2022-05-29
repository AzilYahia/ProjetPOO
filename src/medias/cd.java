package medias;

import enums.MediaType;
import people.adherent;

public class cd extends media{
    //variables
    public String profRecord;
    public String theme;

    //constructors
    public cd(String nom, int quota, String profRecord, String theme) {
        super(nom, quota, MediaType.CD);
        this.profRecord = profRecord;
        this.theme = theme;
    }



}
