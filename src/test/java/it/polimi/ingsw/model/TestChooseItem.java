package it.polimi.ingsw.model;

import it.polimi.ingsw.Action.ChooseItem;
import it.polimi.ingsw.Exception.ActionException;
import it.polimi.ingsw.Position;
import it.polimi.ingsw.model.Bag.*;
import it.polimi.ingsw.model.Game.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestChooseItem {
        private static Game game;

        @BeforeAll
        public static void init() {
            ArrayList<Player> players = new ArrayList<>();
            players.add(new Player("0"));
            players.add(new Player("1"));

            game = new Game(players);
            game.setActivePlayer(game.getPlayers().get(0));
            game.initialize();
        }

        @Test
        @DisplayName("Testing getting item chose by player 1")
        public void getItem1Player() throws ActionException {
            Player p0 = game.getCurrentPlayer();
            game.setAction(new ChooseItem(game,1,4,p0));
            game.doAction();
            game.setAction(new ChooseItem(game,1,3,p0));
            game.doAction();
            assertEquals(2,p0.getMyItem().size());

            for(Position p : game.getCurrentPlayer().getPosition())
                game.getBoard().updateNeighboursAdjacency(p.getRow(), p.getCol());
        }

        @Test
        @DisplayName("Testing getting item chose by player 2")
        public void getItem2Player() throws ActionException {
            game.setActivePlayer(game.getPlayers().get(1));
            Player p0 = game.getCurrentPlayer();
            game.setAction(new ChooseItem(game,2,4,p0));
            game.doAction();
            game.setAction(new ChooseItem(game,2,3,p0));
            game.doAction();
            assertEquals(2,p0.getMyItem().size());
        }
}
