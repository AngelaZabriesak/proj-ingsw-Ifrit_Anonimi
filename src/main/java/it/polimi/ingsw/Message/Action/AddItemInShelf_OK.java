package it.polimi.ingsw.Message.Action;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Shelf;

public class AddItemInShelf_OK extends ActionMessage{

    private final Shelf shelf;
    private final Player player;

    public AddItemInShelf_OK(Shelf shelf, Player player) {
        super("add item in shelf ok", MessageType.ADDINSHELF_OK);
        this.shelf = shelf;
        this.player=player;
    }

    public Shelf getShelf(){
        return shelf;
    }

    public Player getPlayer() {
        return player;
    }
}
