package it.polimi.ingsw.Model;

import it.polimi.ingsw.Action.ChooseItem;
import it.polimi.ingsw.Action.ChooseOrder;
import it.polimi.ingsw.Exception.ActionException;
import it.polimi.ingsw.Exception.WinException;
import it.polimi.ingsw.Model.Game.Game;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGoal {
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
    public void test() throws ActionException, WinException {
        ArrayList<Integer> position = new ArrayList<>();
        position.add(0);
        position.add(1);
        Player p0 = game.getCurrentPlayer();
        game.setAction(new ChooseItem(game,p0,null,null,new Position(1,4)));
        game.doAction();
        game.setAction(new ChooseItem(game,p0,new Position(1,4),null,new Position(1,3)));
        game.doAction();
        game.setAction(new ChooseOrder(game,p0,position));
        game.doAction();
        assertEquals(0,p0.getPosition().size());

        for(Position p : game.getCurrentPlayer().getPosition())
            game.getBoard().updateNeighboursAdjacency(p);
    }
}
