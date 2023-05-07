package it.polimi.ingsw.Observer.ObserverNew;

import java.util.*;

/**
 * Personalized observervable class used by gameController to notify his observers when all players have
 * completed their login
 */
public class LoginObservable{
    private final List<LoginObserver> observers = new ArrayList<>();

    /**
     * Adds an observer
     * @param observer is the new observer
     */
    public void addObserver(LoginObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer
     * @param observer is the removed observer
     */
    public void removeObserver(LoginObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all the observers with a message
     */
    public void notifyObserver() {
        int dim = observers.size();
        //System.out.println("DIMENSIONE login-OBSERVABLE "+dim);
        for (LoginObserver observer : observers) {
            observer.update();
        }
    }

}
