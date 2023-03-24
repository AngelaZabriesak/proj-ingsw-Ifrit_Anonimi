package it.polimi.ingsw.Enumerations;

public enum ActionType {
    NULL("NULL"),
    ADDING("ADDING"), //ADD ITEM IN SHELF
    CHOSE("CHOSE"),   //CHOOSE ITEM TO ADD
    ENDGAME("ENDGAME");
    private String abbreviation;

    ActionType(String abbreviation){
        this.abbreviation=abbreviation;
    }

    public String getAbbreviation(){
        return this.abbreviation;
    }


}
