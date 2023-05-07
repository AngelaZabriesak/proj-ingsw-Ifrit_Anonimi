package it.polimi.ingsw.Message;

import it.polimi.ingsw.Message.Action.AddItemInShelf_OK;
import it.polimi.ingsw.Message.Action.ChooseOrder_OK;
import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Observer.ObserverNew.*;

public class MessageManager2 extends ObsMessage {
    public void manage(Message message){
        //System.out.println("tipo messaggio da gestire:" +message.getType());
        switch(message.getType()){
            case TURN_ALERT:
                notifyViewObserver(obs->obs.TurnAlert((TurnAlert) message));
                break;
            case END_TURN:
                notifyViewObserver(obs->obs.endTurnHandler((EndTurn) message));
                break;
            case ERROR:
                notifyViewObserver(obs-> obs.ErrorManager((Error) message));
                break;
            case OK_CONNECTION:
                notifyViewObserver(obs-> obs.ConnectionSuccessfulHandler((ConnectionOK) message));
                break;
            case OK_QUESTION:
                notifyViewObserver(obs-> obs.CompleteQuestionManager((CompletedQuestion) message));
                break;
            case N_PLAYER_REQUEST:
                notifyViewObserver(obs-> obs.NumOfPlayerHandler((NPlayerRequest) message));
                break;
            case N_PLAYER_RESPONSE:
                notifySrvObserver(obs-> obs.numberOfPlayerHandler((NPlayer) message));
                break;
            case BOARD_RESPONSE:
                notifyViewObserver(obs-> obs.showBoardHandler((BoardResponse) message));
                break;
            case BOARD:
                notifySrvObserver(obs-> obs.showBoardRequestHandler((BoardRequest) message));
                break;
            case SHELF_RESPONSE:
                notifyViewObserver(obs->obs.showShelfHandler((ShelfResponse) message));
                break;
            case SHELF:
                notifySrvObserver(obs->obs.showShelfRequestHandler((ShelfRequest) message));
                break;
            case START:
                notifyViewObserver(obs-> obs.GameStartedHandler((GameStart) message));
                break;
            case WIN:
                notifyViewObserver(obs -> obs.winHandler((Win) message));
                break;
            case END:
                notifyViewObserver(obs -> obs.GameEndedHandler((EndGame) message));
                break;
            case LOGIN:
                notifySrvObserver(obs->obs.loginHandler((Login) message));
                break;
            case N_ITEM_RESPONSE:
                notifySrvObserver(obs->obs.chooseNItemToMove((NItemResponse) message));
                break;
            case COLUMN_RESPONSE:
                notifySrvObserver(obs->obs.moveToColumn((ColumnResponse) message));
                break;
            case ITEM_ORDER_REQUEST:
                notifyViewObserver(obs->obs.chooseOrderItemOK((ChooseOrder_OK) message));
                break;
            case ITEM_ORDER_RESPONSE:
                notifySrvObserver(obs->obs.chooseOrderItem((ItemOrderResponse) message));
                break;
            case ITEM_POSITION_RESPONSE:
                notifySrvObserver(obs->obs.chooseItemPosition((ItemPositionResponse) message));
                break;
            case ADD_ITEM:
                notifyViewObserver(obs->obs.addItemInShelf((AddItemInShelf_OK) message));
            default:
                System.out.println("ERRORE IN MESSAGE MANAGER");
        }
    }
    public void clientDisconnection() {
        notifySrvObserver(ServerObserver::endGameDisconnection);
    }
}
