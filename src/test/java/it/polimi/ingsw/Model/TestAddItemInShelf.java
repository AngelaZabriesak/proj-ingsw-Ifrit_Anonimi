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
        players.add(new Player("2"));
        players.add(new Player("3"));

        game = new Game(players);
        game.setActivePlayer(game.getPlayers().get(0));
        game.initialize();
    }

    @Test
    @DisplayName("Testing putting an item in the column chose by player 1")
    public void setItem1Player() throws ActionException {
        ArrayList<Integer> position = new ArrayList<>();
        position.add(0);
        position.add(1);
        Player p0 = game.getCurrentPlayer();
        game.setAction(new ChooseItem(game,p0,null,null,new Position(1,3)));
        game.doAction();
        game.setAction(new ChooseItem(game,p0,new Position(1,4),null,new Position(1,5)));
        game.doAction();
        game.setAction(new ChooseOrder(game,p0,position));
        game.doAction();
        //game.setAction(new AddItemInShelf(7,p0));
        game.setAction(new AddItemInShelf(game,4,p0));
        game.doAction();
        assertEquals(0,p0.getPosition().size());
    }

    @Test
    @DisplayName("testing refill")
    public void testingRefill(){
        game.fillBoard();
        Board board = game.getBoard();
        for(int riga = 0; riga<board.getRow(); riga++){
            for(int colonna = 0; colonna<board.getCol();colonna++){
                if(board.getMyBoardAdjacency()[riga][colonna]<=4){
                    //if(colonna !=5 && riga !=5)
                        board.removeItem(new Position(riga, colonna));
                }
            }
        }
        String msg ="";
        for(int riga = 0; riga<board.getRow(); riga++){
            for(int colonna = 0; colonna<board.getCol();colonna++){
                if(board.getItem(new Position(riga,colonna))!=null)
                    msg+=(board.getItem(new Position(riga,colonna)).getColor()+" "+board.getAdjacency(new Position(riga,colonna)));
                else
                    msg+=("null\t"+board.getAdjacency(new Position(riga,colonna)));
            }
            msg+=("\n");
        }
        System.out.println(msg);

        game.refillBoard();

        String msg2 ="";
        for(int riga = 0; riga<board.getRow(); riga++){
            for(int colonna = 0; colonna<board.getCol();colonna++){
                if(board.getItem(new Position(riga,colonna))!=null)
                    msg2+=(board.getItem(new Position(riga,colonna)).getColor()+" "+board.getAdjacency(new Position(riga,colonna)));
                else
                    msg2+=("null\t");
            }
            msg2+=("\n");
        }
        System.out.println(msg2);
    }
}
