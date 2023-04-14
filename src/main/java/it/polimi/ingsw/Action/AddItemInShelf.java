package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Game.*;
import it.polimi.ingsw.Model.Goal.CommonGoal.Cgoal;

public class AddItemInShelf implements Action{
    private final Game game;
    private final int chosenColumn;
    private final Player player;
    private String description = "";

    public AddItemInShelf(Game game,int chosenColumn, Player player){
        this.game = game;
        this.chosenColumn = chosenColumn;
        this.player = player;
    }

    @Override
    public void execute() throws ActionException {
        checkInput();
        player.setItemInShelf(chosenColumn);

        if (player.getMyShelf().getNEmpty()==0)
            game.endGame();

        for(Cgoal goal : game.getCGoal()){
            if(goal.isTaken(player.getMyShelf()))
                player.addMyScore(goal.getToken().getScore());
        }

        for(Position p : game.getCurrentPlayer().getPosition())
            game.getBoard().updateNeighboursAdjacency(p);

        boolean ok = true;
        for(int r =0;r<game.getBoard().getRow() && ok == true;r++){
            for(int c=0; c<game.getBoard().getCol() && ok == true; c++){
                if(game.getBoard().getMyBoardAdjacency()[r][c]!=0)
                    ok = false;
            }
        }
        if(ok){
            game.refillBoard();
        }
    }

    @Override
    public void addDescription(String s) {
        description+=s;
    }

    @Override
    public void checkInput() throws ActionException {
        if(!checkColumnValid()) {
            System.out.println("The id column chose isn't valid");
            throw new ActionException();
        }
        if(!checkColumnEmpty()) {
            System.out.println("The id column chose doesn't have enough space");
            throw new ActionException();
        }
    }


    /**
     * checks if the given column id is valid
     * @return boolean
     */
    private boolean checkColumnValid(){
        return chosenColumn >= 0 && chosenColumn <= 4;
    }

    /**
     * check if the column have enough spaces
     * @return boolean
     */
    private boolean checkColumnEmpty(){
        return player.getMyShelf().getFreeRowByColumn(chosenColumn) >= player.getMyItem().size();
    }
}
