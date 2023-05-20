package it.polimi.ingsw.Observer.ObserverNew;

import it.polimi.ingsw.Message.Chat;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Message.GameState.*;

/**
 * Interface used to implement the Observer-Observable pattern between Server and GameController.
 * This interface allows the GameController to observe the Server.
 * It contains all the methods to handle every type of received message.
 */
public interface ServerObserver {

    void loginHandler(Login message);
    void numberOfPlayerHandler(NPlayer message);
    void showShelfRequestHandler(ShelfRequest message);
    void showBoardRequestHandler(BoardRequest message);
    void endGameDisconnection();
    void moveToColumn(ColumnResponse message);
    void choose1ItemPosition(Item1PositionResponse message);
    void choose2ItemPosition(Item2PositionResponse message);
    void choose3ItemPosition(Item3PositionResponse message);
    void manageChoose(ChoosePositionResponse message);
    void chooseOrderItem(ItemOrderResponse message);
    void chat(Chat message);
    void clientDisconnection();
    void newGame();
}
