package it.polimi.ingsw.Model.Goal;

import it.polimi.ingsw.Model.Bag.Item;

import java.io.Serializable;


/**
 * class that define Goal
 */

public abstract class Goal implements Serializable {

    private String description;
    public void setDescription(String description){this.description=description;}

    public String getDescription() {
        return description;
    }

    public abstract Item[][] getGoal();
}
