package it.polimi.ingsw.Model;

import it.polimi.ingsw.Action.ChooseItem;
import it.polimi.ingsw.Action.ChooseOrder;
import it.polimi.ingsw.Exception.ActionException;
import it.polimi.ingsw.Model.Game.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestChooseOrder {

    private static Game game;

    @BeforeAll
    public static void init(){
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("0"));
        players.add(new Player("1"));
        players.add(new Player("2"));

        game = new Game(players);
        game.setActivePlayer(game.getPlayers().get(0));
        game.initialize();
    }

    @Test
    @DisplayName("Testing putting the items  chose by player 1 in order")
    public void getItem1Player() throws ActionException {
        ArrayList<Integer> position = new ArrayList<>();
        position.add(0);
        position.add(1);
        Player p0 = game.getCurrentPlayer();
        game.setAction(new ChooseItem(game,1,4,p0));
        game.doAction();
        game.setAction(new ChooseItem(game,1,3,p0));
        game.doAction();
        game.setAction(new ChooseOrder(game,p0,position));
        game.doAction();
        assertEquals(2,p0.getPosition().size());

        for(Position p : game.getCurrentPlayer().getPosition())
            game.getBoard().updateNeighboursAdjacency(p);
    }

    @Test
    @DisplayName("Testing putting the items  chose by player 2 in order")
    public void getItem2Player() throws ActionException {
        game.setActivePlayer(game.getPlayers().get(1));
        Player p0 = game.getCurrentPlayer();
        ArrayList<Integer> position = new ArrayList<>();
        game.setAction(new ChooseItem(game,2,4,p0));
        game.doAction();
        game.setAction(new ChooseItem(game,2,3,p0));
        game.doAction();
        position.add(0);
        //position.add(2);
        position.add(1);
        game.setAction(new ChooseOrder(game,p0,position));
        game.doAction();
        assertEquals(2,p0.getPosition().size());
    }
}
