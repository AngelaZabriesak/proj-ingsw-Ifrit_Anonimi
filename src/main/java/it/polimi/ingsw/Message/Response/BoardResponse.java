package it.polimi.ingsw.Message.Response;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Message.Message;
import it.polimi.ingsw.Model.Game.*;

public class BoardResponse extends Message {
    private Board board;
    public BoardResponse(Board board) {
        super(MessageType.BOARD_RESPONSE);
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }
}
