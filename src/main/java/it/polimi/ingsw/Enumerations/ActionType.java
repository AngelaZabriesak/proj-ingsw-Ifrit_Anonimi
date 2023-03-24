package it.polimi.ingsw.Enumerations;

public enum ActionType {
    NULL("NULL"),
    PLANNING("PLANNING"),
    MOVEMENT("MOVEMENT"),
    ENDGAME("ENDGAME");
    private String abbreviation;

    ActionType(String abbreviation){
        this.abbreviation=abbreviation;
    }

    public String getAbbreviation(){
        return this.abbreviation;
    }


}
