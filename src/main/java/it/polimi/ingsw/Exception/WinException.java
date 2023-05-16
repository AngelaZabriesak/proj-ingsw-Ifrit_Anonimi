package it.polimi.ingsw.Exception;

/**
 * this exception is thrown if a player wins the game
 */
public class WinException extends Exception{
    private final String nickname;

    public WinException(String nickname ){
        super();
        this.nickname = nickname;
    }

    @Override
    public String getMessage() {
        return nickname;
    }
}
