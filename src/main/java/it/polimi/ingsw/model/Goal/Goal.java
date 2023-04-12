package it.polimi.ingsw.model.Goal;

import it.polimi.ingsw.model.Bag.Item;

public abstract class Goal{

    private String description;
    public void setDescription(String description){this.description=description;}

    public String getDescription() {
        return description;
    }

    public abstract Item[][] getGoal();
}
