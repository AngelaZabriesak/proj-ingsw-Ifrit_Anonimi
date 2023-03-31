package it.polimi.ingsw.model.Game;

import it.polimi.ingsw.Action.Action;
import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.model.Bag.*;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.Goal.*;
import it.polimi.ingsw.model.Goal.CommonGoal.*;
import it.polimi.ingsw.model.Goal.PersonalGoal.*;

import java.util.*;

public class Game {
    private static final int[] VALUE_TOKEN = {8,4,6,2};
    private static final int N_COMMON_GOAL = 2;
    private static final int N_PERSONAL_GOAL = 12;
    private final ArrayList<Player> players;
    private Player currentPlayer;
    private final ArrayList<Goal> personalGoal;
    private final ArrayList<Goal> commonGoal;
    private final Board myBoard;
    private final Bag myBag;
    private Action action;
    private final ArrayList<Cgoal> myGoal = new ArrayList<>();
    private final ArrayList<Token> myToken = new ArrayList<>();

    public Game(ArrayList<Player> players){
        this.players = players;
        // order the token scores from lower to higher
        int[] scores = new int[players.size()];
        for(int i = 0; i< players.size(); i++)
            scores[i]=VALUE_TOKEN[i];
        Arrays.sort(scores);
        for(int i = 0; i< players.size(); i++)
            myToken.add(new Token(scores[i]));

        myBoard = new Board();
        myBag = new Bag();
        personalGoal = new ArrayList<>();
        commonGoal = new ArrayList<>();
        for(int i = 0; i< N_PERSONAL_GOAL; i++) {
            personalGoal.add(PgoalFactory.getInstance().getPersonalGoal(i,this));
            commonGoal.add(CgoalFactory.getInstance().getCommonGoal(i,this));
        }
        for(int i = 0; i<N_COMMON_GOAL; i++) {
            myGoal.add((Cgoal) getRandomGoal(commonGoal));
            myGoal.get(i).setToken(myToken);
            //myGoal.add(getRandomGoal(personalGoal));
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
            p.setMyGoal(getRandomGoal(personalGoal));
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
        for(Player p : players){
            if(p.getMyShelf().getNEmpty()==0){
                new WinException(p.getNickname());
            }
        }
    }

    /**
     * fills the board with item by drawing them at random from the bag
     */
    public void fillBoard(){
        for(int r=0; r< myBoard.getRow(); r++){
            for(int c=0; c< myBoard.getCol(); c++){
                if(r==0 || r==myBoard.getRow()-1 || c==0 || c==myBoard.getCol()-1)
                    myBoard.getMyBoardItem()[r][c] = new Item(ColorItem.BLACK);
                if(((r==1 || r==2) && (c==1 || c==2 || c==myBoard.getCol()-3 || c==myBoard.getCol()-2 )) || ((r==myBoard.getRow()-2 || r==myBoard.getRow()-3) && (c==1 || c==2 || c==myBoard.getCol()-3 || c==myBoard.getCol()-2 )))
                    myBoard.getMyBoardItem()[r][c] = new Item(ColorItem.BLACK);
                if((r==3 && c==1) ||(r==1 && c==5) ||(r==5 && c==myBoard.getCol()-2) ||(r==myBoard.getRow()-2 && c==3))
                    myBoard.getMyBoardItem()[r][c] = new Item(ColorItem.BLACK);
                else if(myBoard.getMyBoardItem()[r][c]==null /*||myBoard.getMyBoardItem()[r][c].getColor()==ColorItem.BLACK*/)
                    myBoard.getMyBoardItem()[r][c] = new Item(myBag.getItem().getColor());
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
    public void setAction(Action myAction) throws ActionException {
        action = myAction;
    }
    /**
     *
     */
    public void doAction() throws ActionException {
        action.execute();
    }

    public Action getAction(){
        return action;
    }

    /**
     * calculate the score of each player for every turn
     */
    public void calcScore(){
        // do check_p_score later and delete the initialization of check_p_score
        // do the same with token_score1 and token_score_2 ( the c_card are assigned during the game)

        int check_p_score=0;
        int token_score1=0;
        int token_score2=0;
        int p_score;
        int myScore;

        int[] p_points = new int[7];
        p_points[0] = 0;
        p_points[1] = 1 ;
        p_points[2] = 2;
        p_points[3] = 4;
        p_points[4] = 6;
        p_points[5] = 9;
        p_points[6] = 12;

        p_score= p_points[check_p_score];

        myScore= p_score+token_score1+token_score2;
    }

    /**
     * @param myGoals is the array of goals enables (personal/common)
     * @return the random goal
     */
    public Goal getRandomGoal(ArrayList<Goal> myGoals){
        double doublepos = Math.random()* myGoals.size();
        int pos = (int) doublepos;
        Goal myGoal = myGoals.get(pos);
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

    public Bag getBag(){
        return myBag;
    }

    public static void main(String[] args){
        Player p0 = new Player("0");
        Player p1 = new Player("1");
        Player p2 = new Player("2");
        Player p3 = new Player("3");
        ArrayList<Player> p = new ArrayList<>();
        p.add(p0);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        Game g = new Game(p);
        String msg ="";
        g.initialize();
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(g.myBoard.getItem(r,c)!=null)
                    msg+="|\t"+g.myBoard.getItem(r,c).getColor()+"" +
                            "\t";
                else
                    msg+="|\tnull\t";
            }
            msg+="|\n";
        }
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                msg+="|\t"+g.myBoard.getAdjacency(r,c)+"" + "\t";
            }
            msg+="|\n";
        }
        msg+="N personal goal "+ g.personalGoal.size()+"\n";
        msg+="N common goal "+ g.commonGoal.size()+"\n";
        msg+="N my common goal "+ g.myGoal.size()+"\n";
        for(Cgoal cg : g.myGoal) {
            msg += cg.getDescription()+"\ttoken: ";
            for(Token t : cg.getMyTokens())
                msg += t.getScore()+"\t";
            msg+= "\n";
        }

        System.out.println(msg);
    }
}
