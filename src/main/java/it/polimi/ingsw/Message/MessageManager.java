package it.polimi.ingsw.Message;

import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Observer.ObserverNew.*;

public class MessageManager extends ObsMessage {
    public void manage(Message message){
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
                notifySrvObserver(obs->obs.numberOfPlayerHandler((NPlayer) message));
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
            case N_ITEM:
                notifySrvObserver(obs->obs.chooseNItemToMove((NItem) message));
                break;
            case COLUMN:
                notifySrvObserver(obs->obs.moveToColumn((Column) message));
                break;
            case ITEM_ORDER:
                notifyViewObserver(obs->obs.showItemChooseForOrdering((ItemOrderRequest) message));
                break;
            case ITEM_ORDER_RESPONSE:
                notifySrvObserver(obs->obs.chooseOrderItem((ItemOrderResponse) message));
                break;
            case ITEM_POSITION:
                notifySrvObserver(obs->obs.chooseItemPosition((ItemPosition) message));
                break;
            default:
                System.out.println("ERRORE IN MESSAGE MANAGER");
        }
    }
    public void clientDisconnection() {
        notifySrvObserver(ServerObserver::endGameDisconnection);
    }
}
