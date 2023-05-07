package it.polimi.ingsw.Message;

import it.polimi.ingsw.Message.Action.*;
import it.polimi.ingsw.Message.Error.Error;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.*;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Observer.*;

public class ViewMessageManager extends ViewObservable {
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
            case N_ITEM_REQUEST:
                notifyViewObserver(obs->obs.chooseNumberItem((NItemRequest) message));
                break;
            case N_PLAYER_REQUEST:
                notifyViewObserver(obs-> obs.NumOfPlayerHandler((NPlayerRequest) message));
                break;
            case BOARD_RESPONSE:
                notifyViewObserver(obs-> obs.showBoardHandler((BoardResponse) message));
                break;
            case SHELF_RESPONSE:
                notifyViewObserver(obs->obs.showShelfHandler((ShelfResponse) message));
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
            case CHOOSEORDER_OK:
                notifyViewObserver(obs->obs.chooseOrderItemOK((ChooseOrder_OK) message));
                break;
            case COLUMN_REQUEST:
                notifyViewObserver(obs->obs.chooseColumn((ColumnRequest) message));
                break;
            case ADDINSHELF_OK:
                notifyViewObserver(obs->obs.addItemInShelf((AddItemInShelf_OK) message));
                break;
            case ITEM_POSITION_REQUEST:
                notifyViewObserver(obs->obs.chooseItemPosition((ItemPositionRequest) message));
                break;
            case ITEM_ORDER_REQUEST:
                notifyViewObserver(obs->obs.chooseOrderItem((ItemOrderRequest) message));
                break;
            case CHOOSEITEM_OK:
                notifyViewObserver(obs -> obs.chooseItemOk((ChooseItem_OK) message));
                break;
            default:
                System.out.println("ERRORE IN view MESSAGE MANAGER");
        }
    }
}
