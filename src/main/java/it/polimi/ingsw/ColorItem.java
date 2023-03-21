package it.polimi.ingsw;

public enum ColorItem {
    BLUE("blue",1),
    WHITE("white",2),
    PINK("pink",3),
    GREEN("green",4),
    YELLOW("yellow",5),
    TURQUOISE("turquoise",6),
    BLACK("black",7)
    ;

    ColorItem(String color, int position) {

    }

    @Override
    public String toString() {
        return "ColorItem{}";
    }
}
