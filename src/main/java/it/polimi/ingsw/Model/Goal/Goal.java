package it.polimi.ingsw.Model.Goal;

import it.polimi.ingsw.Model.Bag.Item;

public abstract class Goal{

    private String description;
    public void setDescription(String description){this.description=description;}

    public String getDescription() {
        return description;
    }

    public abstract Item[][] getGoal();
}
