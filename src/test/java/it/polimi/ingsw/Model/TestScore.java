package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Goal.CommonGoal.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestScore {
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
    @DisplayName("Testing goal")
    public void testGoal(){
        StringBuilder s = new StringBuilder();
        Player p0 = game.getCurrentPlayer();
        Shelf shelf = p0.getMyShelf();
        p0.setMyItem(new Item(ColorItem.GREEN));
        p0.setMyItem(new Item(ColorItem.YELLOW));
        p0.setMyItem(new Item(ColorItem.AZURE));
        p0.setItemInShelf(0);
        p0.setMyItem(new Item(ColorItem.BLUE));
        p0.setMyItem(new Item(ColorItem.PINK));
        p0.setMyItem(new Item(ColorItem.WHITE));
        p0.setItemInShelf(0);

        p0.setMyItem(new Item(ColorItem.GREEN));
        p0.setMyItem(new Item(ColorItem.GREEN));
        p0.setMyItem(new Item(ColorItem.GREEN));
        p0.setItemInShelf(1);
        p0.setMyItem(new Item(ColorItem.AZURE));
        p0.setMyItem(new Item(ColorItem.PINK));
        p0.setMyItem(new Item(ColorItem.PINK));
        p0.setItemInShelf(1);

        p0.setMyItem(new Item(ColorItem.PINK));
        p0.setMyItem(new Item(ColorItem.YELLOW));
        p0.setMyItem(new Item(ColorItem.AZURE));
        p0.setItemInShelf(2);
        p0.setMyItem(new Item(ColorItem.AZURE));
        p0.setMyItem(new Item(ColorItem.AZURE));
        p0.setMyItem(new Item(ColorItem.WHITE));
        p0.setItemInShelf(2);

        p0.setMyItem(new Item(ColorItem.GREEN));
        p0.setMyItem(new Item(ColorItem.YELLOW));
        p0.setMyItem(new Item(ColorItem.AZURE));
        p0.setItemInShelf(3);
        p0.setMyItem(new Item(ColorItem.YELLOW));
        p0.setMyItem(new Item(ColorItem.PINK));
        p0.setMyItem(new Item(ColorItem.YELLOW));
        p0.setItemInShelf(3);

        p0.setMyItem(new Item(ColorItem.GREEN));
        p0.setMyItem(new Item(ColorItem.YELLOW));
        p0.setMyItem(new Item(ColorItem.AZURE));
        p0.setItemInShelf(4);
        p0.setMyItem(new Item(ColorItem.BLUE));
        p0.setMyItem(new Item(ColorItem.PINK));
        p0.setMyItem(new Item(ColorItem.WHITE));
        p0.setItemInShelf(4);
        System.out.println(s);
        StringBuilder s1 = new StringBuilder();
        for (int r = 0; r < shelf.getRow(); r++) {
            for (int c = 0; c < shelf.getCol(); c++) {
                if (shelf.getMyShelf()[r][c] != null)
                    s1.append("|\t").append(shelf.getMyShelf()[r][c].getColor()).append("\t");
                else
                    s1.append("|\tnull\t");
            }
            s1.append("|\n");
        }
        System.out.println(s1);
        StringBuilder pg = new StringBuilder();
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 5; c++) {
                if(game.getCurrentPlayer().getMyGoal().getGoal()[r][c]!=null)
                    pg.append("|\t").append(game.getCurrentPlayer().getMyGoal().getGoal()[r][c].getColor()).append("\t");
                else
                    pg.append("|\t------\t");
            }
            pg.append("|\n");
        }
        System.out.println(pg);
        game.calcScore(p0);
        System.out.println(p0.getMyScore());
    }
}
