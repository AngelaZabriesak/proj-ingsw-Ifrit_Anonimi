package it.polimi.ingsw.Enumerations;

import java.io.Serializable;

public enum MessageType implements Serializable {
    ERROR,
    ITEM_POSITION_RESPONSE,
    ITEM_POSITION_REQUEST,
    COLUMN_RESPONSE,
    N_ITEM_RESPONSE,
    BOARD,
    BOARD_RESPONSE,
    N_PLAYER_REQUEST,
    N_PLAYER_RESPONSE,
    SHELF,
    SHELF_RESPONSE,
    ITEM_ORDER_REQUEST,
    ITEM_ORDER_RESPONSE,
    WIN,
    START,
    TURN_ALERT,
    LOGIN,
    OK_QUESTION,
    OK_CONNECTION,
    END,
    END_TURN,
    ADD_ITEM,
    N_ITEM_REQUEST,
    CHOOSEITEM_OK,
    CHOOSEORDER_OK,
    ADDINSHELF_OK,
    COLUMN_REQUEST
}
