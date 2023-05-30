package it.polimi.ingsw.Model;


import java.io.Serializable;

/**
 * this class is about the token that gives different point after doing a common goal
 */

public class Token implements Serializable {

    private final int score;

    /**
     *
     * @param score score of every token
     */

    public Token(int score) {
        this.score = score;
    }

    public int getScore() {
        return score ;}

    }



