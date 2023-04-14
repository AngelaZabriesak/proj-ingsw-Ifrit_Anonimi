package it.polimi.ingsw.Model.Goal.CommonGoal;

import it.polimi.ingsw.Model.Game.*;

public class CgoalFactory {
    private static CgoalFactory instance;

    public static CgoalFactory getInstance(){
        if(instance == null)
            instance = new CgoalFactory();
        return instance;
    }

    /**
     * Generates a common goal by his id
     * @param id the goal's id
     * @param game the game to assign the goal to
     * @return the requested goal
     */
    public Cgoal getCommonGoal(int id, Game game){
        Cgoal commonGoal;
        switch (id){
            case 0:
                commonGoal = new CommonGoal0();
                commonGoal.setGame(game);
                return commonGoal;
            case 1:
                commonGoal = new CommonGoal1();
                commonGoal.setGame(game);
                return commonGoal;
            case 2:
                commonGoal = new CommonGoal2();
                commonGoal.setGame(game);
                return commonGoal;
            case 3:
                commonGoal = new CommonGoal3();
                commonGoal.setGame(game);
                return commonGoal;
            case 4:
                commonGoal = new CommonGoal4();
                commonGoal.setGame(game);
                return commonGoal;
            case 5:
                commonGoal = new CommonGoal5();
                commonGoal.setGame(game);
                return commonGoal;
            case 6:
                commonGoal = new CommonGoal6();
                commonGoal.setGame(game);
                return commonGoal;
            case 7:
                commonGoal = new CommonGoal7();
                commonGoal.setGame(game);
                return commonGoal;
            case 8:
                commonGoal = new CommonGoal8();
                commonGoal.setGame(game);
                return commonGoal;
            case 9:
                commonGoal = new CommonGoal9();
                commonGoal.setGame(game);
                return commonGoal;
            case 10:
                commonGoal = new CommonGoal10();
                commonGoal.setGame(game);
                return commonGoal;
            case 11:
                commonGoal = new CommonGoal11();
                commonGoal.setGame(game);
                return commonGoal;
            default:
                return null;
        }
    }
}
