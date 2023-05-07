package it.polimi.ingsw.Message.Action;

import it.polimi.ingsw.Enumerations.*;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Shelf;

import java.util.*;

public class AddItemInShelf_OK extends ActionMessage{

    private Shelf shelf;

    public AddItemInShelf_OK(Shelf shelf) {
        super("add item in shelf ok", MessageType.ADDINSHELF_OK);
        this.shelf = shelf;
    }

    public Shelf getShelf(){
        return shelf;
    }
}
