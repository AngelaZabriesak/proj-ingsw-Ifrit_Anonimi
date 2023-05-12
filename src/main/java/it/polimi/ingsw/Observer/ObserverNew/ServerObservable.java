package it.polimi.ingsw.Observer.ObserverNew;

import java.util.*;
import java.util.function.*;

/**
 * Class used to implement the Observer-Observable pattern between Server and GameController.
 * This class allows the ServerMessageHandler to be observed by GameController.
 */
public class ServerObservable {

    /**
     * List containing al the observers
     */
    private final List<ServerObserver> observers = new ArrayList<>();

    /**
     * add an observer to the observers list
     * @param observer the observer to be added
     */
    public void addObserver(ServerObserver observer) {
        observers.add(observer);
    }

    /**
     * removes an observer
     * @param observer the observer to be removed
     */
    public void removeObserver(ServerObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all the observers with the lambda argument.
     * @param lambda the function to be called on the observers.
     */
    public void notifySrvObserver(Consumer<ServerObserver> lambda) {
        int dim = observers.size();
        System.out.println("DIMENSIONE server-OBSERVABLE "+dim);
//        for (ServerObserver observer : observers) {
            lambda.accept(observers.get(0));
//        }
    }
}
