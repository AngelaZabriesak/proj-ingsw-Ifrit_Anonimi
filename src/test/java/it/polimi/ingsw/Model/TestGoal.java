package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Bag.ColorItem;
import it.polimi.ingsw.Model.Bag.Item;
import it.polimi.ingsw.Model.Game.Game;
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;
import it.polimi.ingsw.Model.Goal.CommonGoal.CgoalFactory;
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
    @DisplayName("Testing goal")
    public void testGoal(){
        StringBuilder s = new StringBuilder();
        Player p0 = game.getCurrentPlayer();
        Shelf shelf = p0.getMyShelf();
        for(int r =0;r<shelf.getRow();r++){
            for(int c=0;c<shelf.getCol();c++){
                shelf.setMyShelf(new Position(r,c),new Item(ColorItem.GREEN));
                s.append("|\t").append(shelf.getMyShelf()[r][c].getColor()).append("\t");
            }
            s.append("|\n");
        }
        System.out.println(s);
        ArrayList<Cgoal> cgoals = new ArrayList<>();
        for(int i = 0; i< 11; i++) {
            cgoals.add(CgoalFactory.getInstance().getCommonGoal(i,game));
        }
        for(Cgoal cg : cgoals){
            System.out.println(cg.isTaken(shelf)+" "+cg.getDescription());
        }
        game.calcScore(p0);
        System.out.println(p0.getMyScore());
    }
}
