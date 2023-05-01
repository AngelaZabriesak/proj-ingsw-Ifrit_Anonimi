package it.polimi.ingsw.Model;

import it.polimi.ingsw.Action.*;
import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Model.Game.*;
import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddItemInShelf {
    private static Game game;

    @BeforeAll
    public static void init(){
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("0"));
        players.add(new Player("1"));

        game = new Game(players);
        game.setActivePlayer(game.getPlayers().get(0));
        game.initialize();
    }

    @Test
    @DisplayName("Testing putting an item in the column chose by player 1")
    public void setItem1Player() throws ActionException, WinException {
        ArrayList<Integer> position = new ArrayList<>();
        position.add(0);
        position.add(1);
        Player p0 = game.getCurrentPlayer();
        //prima pescata
        game.setAction(new ChooseItem(game,1,4,p0));
        game.doAction();
        game.setAction(new ChooseItem(game,1,3,p0));
        game.doAction();
        game.setAction(new ChooseOrder(game,p0,position));
        game.doAction();
        //game.setAction(new AddItemInShelf(7,p0));
        game.setAction(new AddItemInShelf(game,4,p0));
        game.doAction();

        //seconda pescata colonna 4 ha 4 posto
        game.setAction(new ChooseItem(game,2,4,p0));
        game.doAction();
        game.setAction(new ChooseItem(game,2,3,p0));
        game.doAction();
        game.setAction(new ChooseItem(game,2,5,p0));
        game.doAction();
        position.clear();
        position.add(0);
        position.add(2);
        position.add(1);
        game.setAction(new ChooseOrder(game,p0,position));
        game.doAction();
        //assertEquals(3,p0.getPosition().size());
        game.setAction(new AddItemInShelf(game,4,p0));
        game.doAction();

        //terza pescata colonna 4 ha 1 posto

        game.setAction(new ChooseItem(game,3,4,p0));
        /*game.doAction();
        game.setAction(new ChooseItem(game,3,3,p0));
        game.doAction();
        game.setAction(new ChooseItem(game,3,5,p0));*/
        game.doAction();
        position.clear();
        position.add(0);
        //position.add(2);
        //position.add(1);
        game.setAction(new ChooseOrder(game,p0,position));
        game.doAction();
        //assertEquals(3,p0.getPosition().size());
        game.setAction(new AddItemInShelf(game,4,p0));
        game.doAction();

        assertEquals(0,p0.getPosition().size());
    }


    @Test
    @DisplayName("Testing putting an item in the column chose by player 2")
    public void setItem2Player() throws ActionException, WinException {
        game.setActivePlayer(game.getPlayers().get(1));
        Player p0 = game.getCurrentPlayer();
        ArrayList<Integer> position = new ArrayList<>();
        game.setAction(new ChooseItem(game,3,5,p0));
        game.doAction();
        game.setAction(new ChooseItem(game,3,2,p0));
        game.doAction();
        position.add(0);
        //position.add(2);
        position.add(1);
        game.setAction(new ChooseOrder(game,p0,position));
        game.doAction();
        game.setAction(new AddItemInShelf(game,2,p0));
        //game.setAction(new AddItemInShelf(4,p0));
        game.doAction();
        assertEquals(0,p0.getPosition().size());
    }

}
