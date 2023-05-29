package it.polimi.ingsw.Model.Game;

import it.polimi.ingsw.Action.*;
import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Message.GameState.*;
import it.polimi.ingsw.Model.Position;
import it.polimi.ingsw.Model.Bag.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Goal.CommonGoal.*;
import it.polimi.ingsw.Model.Goal.PersonalGoal.*;
import it.polimi.ingsw.Observer.Observable;
import it.polimi.ingsw.View.Scene.GameScene;

import java.io.*;
import java.util.*;

public class Game extends Observable implements Serializable {

    private static CreateItemGroup createGroup = new CreateItemGroup();
    private static final int[] VALUE_TOKEN = {8,4,6,2};
    private static final int N_COMMON_GOAL = 2;
    private static final int N_PERSONAL_GOAL = 12;
    private final ArrayList<Player> players;
    private Player currentPlayer;
    private final ArrayList<Pgoal> personalGoal;
    private final Board myBoard;
    private final Bag myBag;
    private Action action;
    private final ArrayList<Cgoal> commonGoal;
    private final ArrayList<Cgoal> myGoal;
    private ArrayList<Position> itemAvailable;

    public Game(ArrayList<Player> players){
        this.players = players;
        // order the token scores from lower to higher
        int[] scores = new int[players.size()];
        System.arraycopy(VALUE_TOKEN, 0, scores, 0, players.size());
        Arrays.sort(scores);
        ArrayList<Token> myToken = new ArrayList<>();
        for(int i = 0; i< players.size(); i++)
            myToken.add(new Token(scores[i]));
        myBoard = new Board();
        myBag = new Bag();
        personalGoal = new ArrayList<>();
        commonGoal = new ArrayList<>();
        myGoal = new ArrayList<>();
        for(int i = 0; i< N_PERSONAL_GOAL; i++) {
            personalGoal.add(PgoalFactory.getInstance().getPersonalGoal(i,this));
            commonGoal.add(CgoalFactory.getInstance().getCommonGoal(i,this));
        }
        for(int i = 0; i<N_COMMON_GOAL; i++) {
            myGoal.add(getRandomCGoal(commonGoal));
            myGoal.get(i).setToken(myToken);
        }
        orderPlayer();
    }

    /**
     *  Fill the board and distributes the cards to the players
     */
    public void initialize(){
        fillBoard();
        myBoard.setMyBoardAdjacency();
        for(Player p : players){
            p.setMyGoal(getRandomPGoal(personalGoal));
        }
    }

    /**
     * define the order of players
     */
    public void orderPlayer(){
        Collections.shuffle(players);
    }

    /**
     * manages the endgame by calculating each player's points
     */
    public void endGame(){
        // add 1 to score of the first player who have fill the shelf for first
        currentPlayer.addMyScore(1);
    }

    public void refillBoard() {
        for (int r = 0; r < myBoard.getRow(); r++) {
            for (int c = 0; c < myBoard.getCol(); c++) {
                if (myBoard.getMyBoardItem()[r][c] == null) {
                    myBoard.getMyBoardItem()[r][c] = new Item(myBag.getItem().getColor());
                }
            }
        }
        myBoard.setMyBoardAdjacency();
    }

    /**
     * fills the board with item by drawing them at random from the bag
     */
    public void fillBoard(){
        for(int r=0; r< myBoard.getRow(); r++){
            for(int c=0; c< myBoard.getCol(); c++){
                if(myBoard.getMyBoardItem()[r][c] == null) {
                    if (r == 0 || r == myBoard.getRow() - 1 || c == 0 || c == myBoard.getCol() - 1)
                        myBoard.getMyBoardItem()[r][c] = new Item(ColorItem.X);
                    if (((r == 1 || r == 2) && (c == 1 || c == 2 || c == myBoard.getCol() - 3 || c == myBoard.getCol() - 2)) || ((r == myBoard.getRow() - 2 || r == myBoard.getRow() - 3) && (c == 1 || c == 2 || c == myBoard.getCol() - 3 || c == myBoard.getCol() - 2)))
                        myBoard.getMyBoardItem()[r][c] = new Item(ColorItem.X);
                    if ((r == 3 && c == 1) || (r == 1 && c == 5) || (r == 5 && c == myBoard.getCol() - 2) || (r == myBoard.getRow() - 2 && c == 3))
                        myBoard.getMyBoardItem()[r][c] = new Item(ColorItem.X);
                    else if (myBoard.getMyBoardItem()[r][c] == null /*||myBoard.getMyBoardItem()[r][c].getColor()==ColorItem.BLACK*/)
                        myBoard.getMyBoardItem()[r][c] = new Item(myBag.getItem().getColor());
                }
            }
        }
        if(players.size()>2){
            if(players.size()==4){
                myBoard.getMyBoardItem()[0][4] = new Item(myBag.getItem().getColor());
                myBoard.getMyBoardItem()[1][5] = new Item(myBag.getItem().getColor());
                myBoard.getMyBoardItem()[3][1] = new Item(myBag.getItem().getColor());
                myBoard.getMyBoardItem()[4][0] = new Item(myBag.getItem().getColor());
                myBoard.getMyBoardItem()[4][8] = new Item(myBag.getItem().getColor());
                myBoard.getMyBoardItem()[5][7] = new Item(myBag.getItem().getColor());
                myBoard.getMyBoardItem()[7][3] = new Item(myBag.getItem().getColor());
                myBoard.getMyBoardItem()[8][4] = new Item(myBag.getItem().getColor());
            }
            myBoard.getMyBoardItem()[0][3] = new Item(myBag.getItem().getColor());
            myBoard.getMyBoardItem()[2][2] = new Item(myBag.getItem().getColor());
            myBoard.getMyBoardItem()[2][6] = new Item(myBag.getItem().getColor());
            myBoard.getMyBoardItem()[3][8] = new Item(myBag.getItem().getColor());
            myBoard.getMyBoardItem()[5][0] = new Item(myBag.getItem().getColor());
            myBoard.getMyBoardItem()[6][2] = new Item(myBag.getItem().getColor());
            myBoard.getMyBoardItem()[6][6] = new Item(myBag.getItem().getColor());
            myBoard.getMyBoardItem()[8][5] = new Item(myBag.getItem().getColor());
        }
    }



    /**
     * manage the action of the players
     */
    public void setAction(Action myAction) {
        action = myAction;
    }

    public void doAction() throws ActionException {
        action.execute();
        notifyObserver(action.getMessage());
    }

    public Action getAction(){
        return action;
    }

    /**
     * calculate the score of each player for every turn
     */
    public void calcScore(Player player){
        ArrayList<Position>[] gruppi = createGroup.creaGruppi(player.getMyShelf());
        // do check_p_score later and delete the initialization of check_p_score
        // do the same with token_score1 and token_score_2 ( the c_card are assigned during the game)

        int check_p_score=0;
        int token_score1=0;
        int token_score2=0;
        int p_score;
        int myScore = player.getMyScore();
        System.out.println("All'inizio "+myScore);
        int[] p_points = new int[7];
        p_points[0] = 0;
        p_points[1] = 1;
        p_points[2] = 2;
        p_points[3] = 4;
        p_points[4] = 6;
        p_points[5] = 9;
        p_points[6] = 12;

        for(ArrayList<Position> gruppo : gruppi){
            if(gruppo!=null) {
                if (gruppo.size() == 3)
                    myScore += 2;
                if (gruppo.size() == 4)
                    myScore += 3;
                if (gruppo.size() == 5)
                    myScore += 5;
                if (gruppo.size() >= 6)
                    myScore += 8;
            }
        }
        System.out.println("raggrupando: "+myScore);
        for(int r =0; r<player.getMyShelf().getRow(); r++){
            for(int c=0; c<player.getMyShelf().getCol(); c++){
                if(player.getMyShelf().getMyShelf()[r][c]!=null){
                    if(player.getMyGoal().getGoal()[r][c]!=null) {
                        if (player.getMyShelf().getMyShelf()[r][c].getColor().equals((player.getMyGoal().getGoal()[r][c].getColor())))
                            check_p_score += 1;
                    }
                }
            }
        }

        System.out.println("check p score "+check_p_score);
        p_score= p_points[check_p_score];

        System.out.println("p socre "+p_score);
        myScore+= p_score+token_score1+token_score2;
        player.setMyScore(myScore);
    }

    /**
     * @param myGoals is the array of personal goals enables
     * @return the random goal
     */
    public Pgoal getRandomPGoal(ArrayList<Pgoal> myGoals){
        double doublepos = Math.random()* myGoals.size();
        int pos = (int) doublepos;
        Pgoal myGoal = myGoals.get(pos);
        myGoals.remove(pos);
        return myGoal;

    }

    /**
     * @param myGoals is the array of common goals enables
     * @return the random goal
     */
    public Cgoal getRandomCGoal(ArrayList<Cgoal> myGoals){
        double doublepos = Math.random()* myGoals.size();
        int pos = (int) doublepos;
        Cgoal myGoal = myGoals.get(pos);
        myGoals.remove(pos);
        return myGoal;

    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public Board getBoard(){
        return myBoard;
    }

    public void setActivePlayer(Player player){
        currentPlayer = player;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public ArrayList<Cgoal> getCGoal(){
        return myGoal;
    }

    public Bag getBag(){
        return myBag;
    }

    public ArrayList<Position> getPositionAvailable(Position p1,Position p2){
        int row,col;
        itemAvailable = new ArrayList<>();
        if(p1==null) {
            for (int r = 0; r < myBoard.getRow(); r++) {
                for (int c = 0; c < myBoard.getCol(); c++) {
                    if (myBoard.getPositionAvailable(r, c) > 0)
                        itemAvailable.add(new Position(r, c));
                }
            }
        }
        else if(p2==null){
            if(myBoard.getPositionAvailable(p1.getRow(),p1.getCol()+1)>0)
                itemAvailable.add(new Position(p1.getRow(), p1.getCol()+1));
            if(myBoard.getPositionAvailable(p1.getRow(),p1.getCol()-1)>0)
                itemAvailable.add(new Position(p1.getRow(), p1.getCol()-1));
            if(myBoard.getPositionAvailable(p1.getRow()-1,p1.getCol())>0)
                itemAvailable.add(new Position(p1.getRow()-1, p1.getCol()));
            if(myBoard.getPositionAvailable(p1.getRow()+1,p1.getCol())>0)
                itemAvailable.add(new Position(p1.getRow()+1, p1.getCol()));
        }
        else {
            row = p2.getRow()-p1.getRow();
            col = p2.getCol()-p1.getCol();
            if(row !=0 && myBoard.getPositionAvailable(p2.getRow()+row,p2.getCol())>0)
                itemAvailable.add(new Position(p2.getRow()+row,p2.getCol()));
            if(col !=0 && myBoard.getPositionAvailable(p2.getRow(),p2.getCol()+col)>0)
                itemAvailable.add(new Position(p2.getRow(),p2.getCol()+col));
        }
        return itemAvailable;
    }

}

