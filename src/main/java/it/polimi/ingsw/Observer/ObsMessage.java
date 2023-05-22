package it.polimi.ingsw.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ObsMessage{

    /**
     * List containing al the observers
     */
    private final List<ServerObserver> serverObservers = new ArrayList<>();
    protected final List<ViewObserver> viewObservers = new ArrayList<>();
    /**
     * add an observer to the observers list
     * @param observer the observer to be added
     */
    public void addObserver(ServerObserver observer) {
        serverObservers.add(observer);
    }
    /**
     * Adds an observer
     * @param observer is the new observer
     */
    public void addObserver(ViewObserver observer) {
        viewObservers.add(observer);
    }

    /**
     * Notifies all the current observers through the lambda argument.
     *
     * @param lambda the lambda to be called on the observers.
     */
    public void notifyViewObserver(Consumer<ViewObserver> lambda) {
        int dim = viewObservers.size();
        //System.out.println("DIMENSIONE viewObservers in OBS-MESSAGE "+dim);
        for (ViewObserver observer : viewObservers) {
            lambda.accept(observer);
        }
    }
    /**
     * Notifies all the observers with the lambda argument.
     * @param lambda the function to be called on the observers.
     */
    public void notifySrvObserver(Consumer<ServerObserver> lambda) {
        int dim = serverObservers.size();
        //System.out.println("DIMENSIONE serverObservers in OBS-MESSAGE "+dim);
        for (ServerObserver observer : serverObservers) {
            lambda.accept(observer);
        }
    }
}
