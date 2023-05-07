package it.polimi.ingsw.View;

import it.polimi.ingsw.Message.Request.NItemRequest;
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
    void askItem(int nItem);
    void askNItem(NItemRequest message);
    void askColumn(ArrayList<Item> itemOrdered,Shelf shelf);
    void askOrder(ArrayList<Item> itemToOrder);
    void showBoard(Board board);
    void showShelf(Shelf shelf);
    void showItemToOrder(ArrayList<Item> itemToOrder);
    void showScore(Player player);
    void showCGoal(ArrayList<Cgoal> cgoal);
    void showPGoal(Pgoal pgoal);
    void showErrorAndExit(String error);
    void showError(String error);
    void showMessage(String message);

}
