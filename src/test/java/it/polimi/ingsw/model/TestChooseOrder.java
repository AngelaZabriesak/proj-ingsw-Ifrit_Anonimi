package it.polimi.ingsw.model;

import it.polimi.ingsw.model.Game.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

public class TestChooseOrder {

    private Game game;

    @BeforeAll
    public void init() throws IOException {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("0"));
        players.add(new Player("1"));

        game = new Game(players);
        game.setActivePlayer(game.getPlayers().get(0));
    }

    @Test
    @DisplayName("Testing putting an item in the column chose")
    public void getItem(){

    }

}
