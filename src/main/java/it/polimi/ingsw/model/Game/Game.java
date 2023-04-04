package it.polimi.ingsw.model.Game;

import it.polimi.ingsw.Action.Action;
import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Position;
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

    public ArrayList<ArrayList<Position>> raggruppaPerColore(Shelf myShelf){
        ArrayList<Position> group = null;
        ArrayList<ArrayList<Position>> groupColor = new ArrayList<>();
        for(ColorItem ci : ColorItem.values()){// comprende anche il nero quindi la dimensione di groupColor è 7new ArrayList<>();
            group = new ArrayList<>();
            for(int r =0;r< myShelf.getRow(); r++){
                for(int c =0; c < myShelf.getCol(); c++){
                    if(myShelf.getMyShelf()[r][c].getColor().equals(ci))
                        group.add(new Position(r,c));
                }
            }
            groupColor.add(group);
        }
        return groupColor;
    }
    public ArrayList<ArrayList<Position>> raggruppaPerAdiacenza(ArrayList<Position> groupColor){
        ArrayList<Position> adiacenzaColore= new ArrayList<>();
        ArrayList<ArrayList<Position>> nuovoListAdiacenza = new ArrayList<>();
        ArrayList<ArrayList<Position>> nuovoListAdiacenzaMerged = new ArrayList<>();
        // adiacenzaColore.add(groupColor.get(0));
        for(int l=0;l<groupColor.size();l++){
            adiacenzaColore.add(groupColor.get(l));
            for(int i =l+1;i<groupColor.size();i++){
                if(distanzaFraPosition(groupColor.get(l),groupColor.get(i))==1) {
                    adiacenzaColore.add(groupColor.get(i));
                }
                //nuovoListAdiacenza.add(adiacenzaColore);
                /*for(Position position : adiacenzaColore)
                    adiacenzaColore.remove(position);*/
            }
            nuovoListAdiacenza.add(adiacenzaColore);

        }
        for(ArrayList<Position> daFondere : nuovoListAdiacenza){
            nuovoListAdiacenzaMerged.add(mergeAdjacency(daFondere));
        }
        return nuovoListAdiacenzaMerged;
        //return adiacenzaColore;
    }

    private int distanzaFraPosition(Position prima, Position seconda){
        int dist =0;
        int distRig = prima.getRow() - seconda.getRow();
        int distCol = prima.getCol() - seconda.getCol();
        dist+=Math.sqrt(Math.pow(distRig,2)+Math.pow(distCol,2));
        return dist;
    }

    private ArrayList<Position> mergeAdjacency(ArrayList<Position> daFondere){
        ArrayList<Position> fuso = new ArrayList<>();
        // elenco di input con duplicati
        ArrayList<String> listWithDuplicates = new ArrayList<>();
        for(Position position : daFondere){
            listWithDuplicates.add(position.getRow()+" "+position.getCol());
        }
        // costruisce un set dagli elementi della lista
        Set<String> set = new LinkedHashSet<>(listWithDuplicates);
        // costruisce una nuova lista da un set e la stampa
        ArrayList<String> listWithoutDuplicates = new ArrayList<>(set);
        for(String string : listWithoutDuplicates)
            fuso.add(new Position(Integer.valueOf(string.split(" ")[0]),Integer.valueOf(string.split(" ")[1])));
        return fuso;
    }
    public static void main(String[] args) {
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
        String msg = "";
        g.initialize();
        /*for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(g.myBoard.getItem(new Position(r,c))!=null)
                    msg+="|\t"+g.myBoard.getItem(new Position(r,c)).getColor()+"" +
                            "\t";
                else
                    msg+="|\tnull\t";
            }
            msg+="|\n";
        }
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                msg+="|\t"+g.myBoard.getAdjacency(new Position(r,c))+"" + "\t";
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
        }*/
        for (int c = 0; c < 5; c++) {
            p0.setMyItem(new Item(ColorItem.GREEN));
            p0.setMyItem(new Item(ColorItem.YELLOW));
            p0.setMyItem(new Item(ColorItem.GREEN));
            p0.setItemInShelf(c);
            p0.setMyItem(new Item(ColorItem.BLUE));
            p0.setMyItem(new Item(ColorItem.PINK));
            p0.setMyItem(new Item(ColorItem.BLUE));
            p0.setItemInShelf(c);
        }
        /**
         * visualizzazione shelf
         */
        for (int r = 0; r < p0.getMyShelf().getRow(); r++) {
            for (int c = 0; c < p0.getMyShelf().getCol(); c++)
                msg += "|\t" + p0.getMyShelf().getMyShelf()[r][c].getColor() + "\t";
            msg += "|\n";
        }
        /**
         * visualizzazione raggruppamento per colore
         */
        ArrayList<ArrayList<Position>> coloriRaggruppati = new ArrayList<>(g.raggruppaPerColore(p0.getMyShelf()));
        for (ArrayList<Position> listeColoriRaggruppati : coloriRaggruppati){
            for (Position position : listeColoriRaggruppati)
                msg += "|\t" + position.getRow() + "," + position.getCol() + "\t";
            msg+="|\n";
        }
        /**
         * visualizzazione array raggruppati
         */
        for(ArrayList<Position> listeColoriRaggruppati : coloriRaggruppati){
            ArrayList<Position> adiacenze;
            if(listeColoriRaggruppati.size()!=0) {
                adiacenze = new ArrayList<>();
                for(ArrayList<Position> merged : g.raggruppaPerAdiacenza(listeColoriRaggruppati)) {
                    for (Position position : merged)
                        adiacenze.add(position);
                }
                for(Position position : adiacenze){
                    msg+="|\t"+position.getRow()+", "+position.getCol()+"\t";
                }
                msg+="|\n";
            }
        }

        /** eliminare le posizioni uguali
        ArrayList<Position> posizioni = new ArrayList<>();
        posizioni.add(new Position(1,2));
        posizioni.add(new Position(1,2));
        posizioni.add(new Position(1,3));
        posizioni.add(new Position(1,3));
        posizioni.add(new Position(1,4));
        ArrayList<Position> posizioniFuse = g.mergeAdjacency(posizioni);
        for(Position position : posizioniFuse)
            msg+="|\t"+position.getRow()+", "+position.getCol()+"\t";
        msg+="|";*/
        System.out.println(msg);
    }
}
