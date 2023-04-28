package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Message.*;

import java.util.*;

public class Observable {
    private final List<Observer> observers = new ArrayList<>();

    /**
     * Adds an observer.
     *
     * @param obs the observer to be added.
     */
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    /**
     * Removes an observer.
     *
     * @param obs the observer to be removed.
     */
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    /**
     * Notifies all the current observers through the update method and passes to them a message
     *
     * @param message the message to be passed to the observers.
     */
    protected void notifyObserver(MessageToClient message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
