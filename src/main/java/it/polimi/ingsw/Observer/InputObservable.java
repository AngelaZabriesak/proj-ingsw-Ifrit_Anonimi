package it.polimi.ingsw.Observer;


import java.util.*;
import java.util.function.*;

public abstract class  InputObservable {
    protected final List<InputObserver> observers = new ArrayList<>();

    /**
     * Adds an observer
     * @param observer is the new observer
     */
    public void addObserver(InputObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer
     * @param observer is the removed observer
     */
    public void removeObserver(InputObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all the current observers through the lambda argument.
     *
     * @param lambda the lambda to be called on the observers.
     */
    public void notifyInObserver(Consumer<InputObserver> lambda) {
        int dim = observers.size();
        //System.out.println("DIMENSIONE input-OBSERVABLE "+dim);
        for (InputObserver observer : observers) {
            lambda.accept(observer);
        }
    }
    public void addAllObservers(List<InputObserver> observerList) {
        observers.addAll(observerList);
    }
}
