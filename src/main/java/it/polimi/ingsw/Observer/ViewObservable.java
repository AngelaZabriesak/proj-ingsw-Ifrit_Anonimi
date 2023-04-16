package it.polimi.ingsw.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class ViewObservable {
    protected final List<ViewObserver> observers = new ArrayList<>();

    /**
     * Adds an observer.
     */
    public void addObserver(ViewObserver obs) {
        observers.add(obs);
    }

    /**
     * Adds a list of observers.
     */
    public void addAllObservers(List<ViewObserver> observerList) {
        observers.addAll(observerList);
    }

    /**
     * Removes an observer.
     */
    public void removeObserver(ViewObserver obs) {
        observers.remove(obs);
    }

    /**
     * Removes a list of observers.
     */
    public void removeAllObservers(List<ViewObserver> observerList) {
        observers.removeAll(observerList);
    }

    /**
     * Notifies all the current observers through the lambda argument.
     */
    protected void notifyObserver(Consumer<ViewObserver> lambda) {
        for (ViewObserver observer : observers) {
            lambda.accept(observer);
        }
    }
}
