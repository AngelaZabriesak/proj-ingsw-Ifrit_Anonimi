package it.polimi.ingsw.Action;

import it.polimi.ingsw.Exception.*;
import it.polimi.ingsw.Message.Action.ActionMessage;
import it.polimi.ingsw.Message.Action.AddItemInShelf_OK;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Bag.ColorItem;
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

        for(Position p : game.getCurrentPlayer().getPosition())
            game.getBoard().updateNeighboursAdjacency(p);

        player.setItemInShelf(chosenColumn);

        for(Cgoal goal : game.getCGoal()){
            if(goal.isTaken(player.getMyShelf()))
                player.addMyScore(goal.getToken().getScore());
        }

        boolean ok = true;
        for(int r =0;r<game.getBoard().getRow() && ok;r++){
            for(int c=0; c<game.getBoard().getCol() && ok; c++){
                if((game.getBoard().getMyBoardAdjacency()[r][c]>0) && (game.getBoard().getMyBoardAdjacency()[r][c]<5))
                    ok = false;
            }
        }
        if(ok){
            game.refillBoard();
        }
    }

    @Override
    public ActionMessage getMessage() {
        return new AddItemInShelf_OK(player.getMyShelf());
    }

    @Override
    public void addDescription(String s) {
        description+=s;
    }

    @Override
    public void checkInput() throws ActionException {
        if(!checkColumnValid()) {
            throw new ActionException("The id column chose isn't valid");
        }
        if(!checkColumnEmpty()) {
            throw new ActionException("The id column chose doesn't have enough space");
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
