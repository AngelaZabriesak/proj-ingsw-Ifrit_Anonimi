package it.polimi.ingsw.Enumerations;

import java.io.Serializable;

public enum MessageType implements Serializable {
    ERROR,
    ITEM_1POSITION_RESPONSE,
    ITEM_2POSITION_RESPONSE,
    ITEM_3POSITION_RESPONSE,
    ITEM_1POSITION_REQUEST,
    ITEM_2POSITION_REQUEST,
    ITEM_3POSITION_REQUEST,
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
    CHOOSEITEM_OK,
    CHOOSEORDER_OK,
    ADDINSHELF_OK,
    LOGIN_REQUEST,
    CHOOSEITEM,
    CHOOSEITEM_RESPONSE,
    ERROR_PLAYER, CHAT, NEW_GAME, COLUMN_REQUEST
}
