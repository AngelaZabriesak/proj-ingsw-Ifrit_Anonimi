package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Goal.CommonGoal.*;
import it.polimi.ingsw.Model.Goal.PersonalGoal.*;

import java.util.*;

/**
 * Defines a generic view to be implemented by each view type
 */
public interface View {
    void askNPlayers();
    void askNickname();
    void askItem();
    void askColumn();
    void askOrder();
    void showBoard(Board board);
    void showShelf(Shelf shelf);
    void showScore(Player player);
    void showCGoal(ArrayList<Cgoal> cgoal);
    void showPGoal(Pgoal pgoal);
    void showLoginResult(boolean nicknameAccepted, boolean connectionSuccessful, String nickname);
    void showErrorAndExit(String error);
    void showError(String error);

}
