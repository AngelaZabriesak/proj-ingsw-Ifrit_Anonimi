package it.polimi.ingsw.Observer.ObserverNew;

import it.polimi.ingsw.Observer.Observable;

import java.util.*;
import java.util.function.*;

/**
 * Implementation of the observable class
 */
public abstract class ClientObservable{

    private final List<ClientObserver> observers = new ArrayList<>();

    /**
     * Adds an observer
     * @param observer is the new observer
     */
    public void addObserver(ClientObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer
     * @param observer is the removed observer
     */
    public void removeObserver(ClientObserver observer) {
        observers.remove(observer);
    }

    /**
     * Removes all the observers
     */
    public void removeAllObservers() {
        observers.clear();
    }


    /**
     * Notifies all the current observers through the lambda argument.
     *
     * @param lambda the lambda to be called on the observers.
     */
    public void notifyObserver(Consumer<ClientObserver> lambda) {
        for (ClientObserver observer : observers) {
            lambda.accept(observer);
        }
    }
}
