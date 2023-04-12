package it.polimi.ingsw.model.Game;

import it.polimi.ingsw.Action.*;
import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.model.Position;
import it.polimi.ingsw.model.Bag.*;
import it.polimi.ingsw.model.*;
import it.polimi.ingsw.model.Goal.CommonGoal.*;
import it.polimi.ingsw.model.Goal.PersonalGoal.*;

import java.util.*;

public class Game {
    private final ArrayList<Position>[] gruppo = new ArrayList[30];
    private ArrayList<Position> nuovoGruppo;
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
        while(!currentPlayer.equals(players.get(0))) {
            nextPlayer();
            // scegli item, se c'è da riempire plancia riempi, posiziona item in shelf
        }
        for(Player p : players){
            calcScore(p);
        }
    }

    private void nextPlayer(){
        int pos = players.indexOf(currentPlayer);
        if(pos== players.size()-1)
            pos=0;
        else
            pos++;
        currentPlayer = players.get(pos);
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
                        myBoard.getMyBoardItem()[r][c] = new Item(ColorItem.BLACK);
                    if (((r == 1 || r == 2) && (c == 1 || c == 2 || c == myBoard.getCol() - 3 || c == myBoard.getCol() - 2)) || ((r == myBoard.getRow() - 2 || r == myBoard.getRow() - 3) && (c == 1 || c == 2 || c == myBoard.getCol() - 3 || c == myBoard.getCol() - 2)))
                        myBoard.getMyBoardItem()[r][c] = new Item(ColorItem.BLACK);
                    if ((r == 3 && c == 1) || (r == 1 && c == 5) || (r == 5 && c == myBoard.getCol() - 2) || (r == myBoard.getRow() - 2 && c == 3))
                        myBoard.getMyBoardItem()[r][c] = new Item(ColorItem.BLACK);
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
    }

    public Action getAction(){
        return action;
    }

    /**
     * calculate the score of each player for every turn
     */
    public void calcScore(Player player){
        ArrayList<Position>[] gruppi = creaGruppi(player);
        // do check_p_score later and delete the initialization of check_p_score
        // do the same with token_score1 and token_score_2 ( the c_card are assigned during the game)

        int check_p_score=0;
        int token_score1=0;
        int token_score2=0;
        int p_score;
        int myScore = player.getMyScore();

        int[] p_points = new int[7];
        p_points[0] = 0;
        p_points[1] = 1;
        p_points[2] = 2;
        p_points[3] = 4;
        p_points[4] = 6;
        p_points[5] = 9;
        p_points[6] = 12;

        for(ArrayList<Position> gruppo : gruppi){
            if(gruppo.size()==3)
                myScore+=2;
            if(gruppo.size()==4)
                myScore+=3;
            if(gruppo.size()==5)
                myScore+=5;
            if (gruppo.size()>=6)
                myScore+=8;
        }

        for(int r =0; r<player.getMyShelf().getRow(); r++){
            for(int c=0; c<player.getMyShelf().getCol(); c++){
                if(player.getMyShelf().getMyShelf()[r][c]!=null){
                    if(player.getMyShelf().getMyShelf()[r][c].getColor().equals((player.getMyGoal().getGoal()[r][c].getColor())))
                        check_p_score+=1;
                }
            }
        }

        p_score= p_points[check_p_score];

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
        return commonGoal;
    }

    public Bag getBag(){
        return myBag;
    }

    /**
     * metodo che raggruppa gli item inseriti nella shelf in base al colore
     * @param player il player la cui libreria è da controllare
     * @return un array in cui vengono memorizzate le liste di posizioni
     */
    public ArrayList<Position>[] creaGruppi(Player player){
        Position primo;
        int i=0;
        for(int r =0; r<player.getMyShelf().getRow();r++){
            for(int c=0; c<player.getMyShelf().getCol();c++) {
                this.nuovoGruppo = new ArrayList<>();
                if(player.getMyShelf().getMyShelf()[r][c]!=null){
                    if (player.getMyShelf().getMyShelf()[r][c].getColor() != ColorItem.BLACK && !player.getMyShelf().getMyShelf()[r][c].getInGruppo()) {
                        this.gruppo[i] = new ArrayList<>();
                        primo = new Position(r, c);
                        this.gruppo[i].add(primo);
                        player.getMyShelf().getMyShelf()[r][c].setInGruppo();
                        controllaVicini(player, primo);
                        this.gruppo[i].addAll(this.nuovoGruppo);
                        for (Position p : this.gruppo[i]) {
                            player.getMyShelf().getMyShelf()[r][c] = new Item(ColorItem.BLACK);
                        }
                        i++;
                    }
                }
            }
        }
        return this.gruppo;
    }

    /**
     * metodo che controlla i vicini di un item nella libreria
     * @param player il player la cui libreria è da controllare
     * @param primo il primo item che si trova scorrendo la shelf
     * @return un intero che serve per controllare il numero di vicini che ha un item
     */
    private int controllaVicini(Player player,Position primo){
        ArrayList<Position> gruppo = new ArrayList<>();
        primo.setCheck();
        int adiacenze =0;
        if(primo.getRow()<5 && player.getMyShelf().getMyShelf()[primo.getRow()+1][primo.getCol()]!=null) {
            if(player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()].getColor()==player.getMyShelf().getMyShelf()[primo.getRow()+1][primo.getCol()].getColor()){
                if (!player.getMyShelf().getMyShelf()[primo.getRow() + 1][primo.getCol()].getInGruppo()) {
                    gruppo.add(new Position(primo.getRow() + 1, primo.getCol()));
                    adiacenze++;
                    player.getMyShelf().getMyShelf()[primo.getRow() + 1][primo.getCol()].setInGruppo();
                    controllaVicini(player, new Position(primo.getRow() + 1, primo.getCol()));
                }
            }
        }
        if(primo.getRow()>0 && player.getMyShelf().getMyShelf()[primo.getRow()-1][primo.getCol()]!=null) {
            if(player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()].getColor()==player.getMyShelf().getMyShelf()[primo.getRow()-1][primo.getCol()].getColor()){
                if (!player.getMyShelf().getMyShelf()[primo.getRow() - 1][primo.getCol()].getInGruppo()) {
                    gruppo.add(new Position(primo.getRow() - 1, primo.getCol()));
                    adiacenze++;
                    player.getMyShelf().getMyShelf()[primo.getRow() - 1][primo.getCol()].setInGruppo();
                    controllaVicini(player, new Position(primo.getRow() - 1, primo.getCol()));
                }
            }
        }
        if(primo.getCol()<4 && player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()+1]!=null){
            if(player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()].getColor()==player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()+1].getColor()){
                if(!player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()+1].getInGruppo()){
                    gruppo.add(new Position(primo.getRow(), primo.getCol()+1));
                    adiacenze++;
                    player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()+1].setInGruppo();
                    controllaVicini(player,new Position(primo.getRow(), primo.getCol() + 1));
                }
            }
        }
        if(primo.getCol()>0 && player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()-1]!=null){
            if(player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()].getColor()==player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol()-1].getColor()) {
                if (!player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol() - 1].getInGruppo()) {
                    gruppo.add(new Position(primo.getRow(), primo.getCol() - 1));
                    adiacenze++;
                    player.getMyShelf().getMyShelf()[primo.getRow()][primo.getCol() - 1].setInGruppo();
                    controllaVicini(player, new Position(primo.getRow(), primo.getCol() - 1));
                }
            }
        }
        this.nuovoGruppo.addAll(gruppo);
        return adiacenze;
    }

/**
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
   */

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
        for(int r=0;r<9;r++){
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
        }
        /**
         * Riempimento shelf
         */
        for (int c = 0; c < p0.getMyShelf().getCol(); c++) {
            p0.setMyItem(new Item(ColorItem.GREEN));
            p0.setMyItem(new Item(ColorItem.YELLOW));
            p0.setMyItem(new Item(ColorItem.AZURE));
            p0.setItemInShelf(c);
            p0.setMyItem(new Item(ColorItem.BLUE));
            p0.setMyItem(new Item(ColorItem.PINK));
            p0.setMyItem(new Item(ColorItem.WHITE));
            p0.setItemInShelf(c);
        }
        /**
         * visualizzazione shelf
         */
        for (int r = 0; r < p0.getMyShelf().getRow(); r++) {
            for (int c = 0; c < p0.getMyShelf().getCol(); c++) {
                if(p0.getMyShelf().getMyShelf()[r][c]!=null)
                    msg += "|\t" + p0.getMyShelf().getMyShelf()[r][c].getColor() + "\t";
                else
                    msg+="|\tnull\t";
            }
            msg += "|\n";
        }
        for(ArrayList<Position> position : g.creaGruppi(p0)){
            if(position!=null) {
                msg+="dim: "+position.size()+"\t";
                for (Position pos : position)
                    msg += "|\t" + pos.getRow() + ", " + pos.getCol() + "\t";
                msg+="|\n";
            }
        }

        System.out.println(msg);
    }
}
