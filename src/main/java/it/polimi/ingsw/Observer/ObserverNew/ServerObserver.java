package it.polimi.ingsw.Observer.ObserverNew;

import it.polimi.ingsw.Message.Column;
import it.polimi.ingsw.Message.ItemPosition;
import it.polimi.ingsw.Message.NItem;
import it.polimi.ingsw.Message.Request.BoardRequest;
import it.polimi.ingsw.Message.Request.ItemOrderRequest;
import it.polimi.ingsw.Message.Request.ShelfRequest;
import it.polimi.ingsw.Message.Response.ItemOrderResponse;
import it.polimi.ingsw.Message.GameState.Login;
import it.polimi.ingsw.Message.GameState.NPlayer;

/**
 * Interface used to implement the Observer-Observable pattern between Server and GameController.
 * This interface allows the GameController to observe the Server.
 * It contains all the methods to handle every type of received message.
 */
public interface ServerObserver {

    void loginHandler(Login message);
    void numberOfPlayerHandler(NPlayer message);
    void showItemChooseForOrdering(ItemOrderRequest message);
    void showShelfRequestHandler(ShelfRequest message);
    void showBoardRequestHandler(BoardRequest message);
    void endGameDisconnection();
    void moveToColumn(Column message);
    void chooseItemPosition(ItemPosition message);
    void chooseNItemToMove(NItem message);
    void chooseOrderItem(ItemOrderResponse message);
}
