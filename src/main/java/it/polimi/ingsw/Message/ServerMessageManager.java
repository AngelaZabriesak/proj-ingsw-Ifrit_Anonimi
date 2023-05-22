package it.polimi.ingsw.Message;

import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Message.Request.BoardRequest;
import it.polimi.ingsw.Message.Request.ShelfRequest;
import it.polimi.ingsw.Message.Response.*;
import it.polimi.ingsw.Observer.ServerObservable;
import it.polimi.ingsw.Observer.ServerObserver;

public class ServerMessageManager extends ServerObservable {
    public void manage(Message message){
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
            case COLUMN_RESPONSE:
                notifySrvObserver(obs->obs.moveToColumn((ColumnResponse) message));
                break;
            case ITEM_ORDER_RESPONSE:
                notifySrvObserver(obs->obs.chooseOrderItem((ItemOrderResponse) message));
                break;
            case ITEM_1POSITION_RESPONSE:
                notifySrvObserver(obs->obs.choose1ItemPosition((Item1PositionResponse) message));
                break;
            case ITEM_2POSITION_RESPONSE:
                notifySrvObserver(obs->obs.choose2ItemPosition((Item2PositionResponse) message));
                break;
            case ITEM_3POSITION_RESPONSE:
                notifySrvObserver(obs->obs.choose3ItemPosition((Item3PositionResponse) message));
                break;
            case CHOOSEITEM_RESPONSE:
                notifySrvObserver(obs->obs.manageChoose((ChoosePositionResponse) message));
                break;
            case CHAT:
                notifySrvObserver(obs->obs.chat((Chat) message));
                break;
            case NEW_GAME:
                notifySrvObserver(ServerObserver::newGame);
                break;
            default:
                System.out.println("ERROR IN MESSAGE server MANAGER "+message.getClass());
        }
    }
    public void clientDisconnection() {
        notifySrvObserver(ServerObserver::clientDisconnection);
    }
}
