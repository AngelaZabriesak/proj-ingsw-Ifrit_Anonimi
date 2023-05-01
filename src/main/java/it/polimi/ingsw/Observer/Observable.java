package it.polimi.ingsw.Observer;


import java.util.*;
import java.util.function.Consumer;

public abstract class Observable{
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
     * Notifies all the current observers through the lambda argument.
     */
    public abstract void notifyObserver(Consumer<Observer> lambda);
}
