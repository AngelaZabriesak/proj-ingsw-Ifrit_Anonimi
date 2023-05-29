package it.polimi.ingsw.View;

import it.polimi.ingsw.Message.GameState.GameStart;
import it.polimi.ingsw.Message.Request.ChoosePositionRequest;
import it.polimi.ingsw.Model.Bag.Item;
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
    void askItem(Board board,Position p1, Position p2,ArrayList<Position> availablePosition);
    void askOther(ChoosePositionRequest message);
    void askColumn();
    void askOrder(ArrayList<Item> itemToOrder);
    void showBoard(Board board);
    void showShelf(Shelf shelf,Player player);
    void showItemToOrder(ArrayList<Item> itemToOrder);
    void showScore(Player player);
    void showCGoal(ArrayList<Cgoal> cgoal);
    void showPGoal(Pgoal pgoal);
    void showError(String error);
    void showMessage(String message);
    void showWait(int nPlayers);
    void askEnd();
    void exit();
    void initGame(GameStart message);
    void showTable(Board board,ArrayList<Position> availablePositions, Shelf shelf, ArrayList<Cgoal> cgoal,Pgoal pgoal,Player player);
}
