package it.polimi.ingsw.Observer;


import java.util.*;
import java.util.function.*;

public abstract class SocketClientObservable {
    private final List<SocketClientObserver> observers = new ArrayList<>();

    /**
     * Adds an observer
     * @param observer is the new observer
     */
    public void addObserver(SocketClientObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer
     * @param observer is the removed observer
     */
    public void removeObserver(SocketClientObserver observer) {
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
    public void notifyObserver(Consumer<SocketClientObserver> lambda) {
        int dim = observers.size();
        //System.out.println("DIMENSIONE socketclient-OBSERVABLE "+dim);
        for (SocketClientObserver observer : observers) {
            lambda.accept(observer);
        }
    }
}
