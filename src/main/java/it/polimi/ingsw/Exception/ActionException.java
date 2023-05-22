package it.polimi.ingsw.Exception;

/**
 * This class is used to send an Exception in every action
 */
public class ActionException extends Exception{

    private final String message;
    public ActionException(String description){
        super();
        this.message = description;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
