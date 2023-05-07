package it.polimi.ingsw.Message;

import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.BoardRequest;
import it.polimi.ingsw.Message.Request.ShelfRequest;
import it.polimi.ingsw.Message.Response.ColumnResponse;
import it.polimi.ingsw.Message.Response.ItemOrderResponse;
import it.polimi.ingsw.Message.Response.ItemPositionResponse;
import it.polimi.ingsw.Message.Response.NItemResponse;
import it.polimi.ingsw.Observer.ObserverNew.ServerObservable;
import it.polimi.ingsw.Observer.ObserverNew.ServerObserver;

public class ServerMessageManager extends ServerObservable {
    public void manage(Message message){
        //System.out.println("tipo messaggio da gestire:" +message.getType());
        switch(message.getType()){
            case N_PLAYER_RESPONSE:
                notifySrvObserver(obs-> obs.numberOfPlayerHandler((NPlayer) message));
                break;
            case BOARD:
                notifySrvObserver(obs-> obs.showBoardRequestHandler((BoardRequest) message));
                break;
            case SHELF:
                notifySrvObserver(obs->obs.showShelfRequestHandler((ShelfRequest) message));
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
            case ITEM_ORDER_RESPONSE:
                notifySrvObserver(obs->obs.chooseOrderItem((ItemOrderResponse) message));
                break;
            case ITEM_POSITION_RESPONSE:
                notifySrvObserver(obs->obs.chooseItemPosition((ItemPositionResponse) message));
                break;
            default:
                System.out.println("ERRORE IN MESSAGE server MANAGER");
        }
    }
    public void clientDisconnection() {
        notifySrvObserver(ServerObserver::endGameDisconnection);
    }
}
