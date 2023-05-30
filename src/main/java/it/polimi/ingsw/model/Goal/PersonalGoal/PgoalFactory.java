package it.polimi.ingsw.Model.Goal.PersonalGoal;

import it.polimi.ingsw.Model.Game.Game;


/**
 * that class implements the factory pattern for PGoal
 */

public class PgoalFactory {

    private static PgoalFactory instance;
    public PgoalFactory() {}

    public static PgoalFactory getInstance(){
        if(instance == null)
            instance = new PgoalFactory();
        return instance;
    }

    /**
     * Generates a personal goal by his id
     * @param id the goal's id
     * @param game the game to assign the goal to
     * @return the requested goal
     */
    public Pgoal getPersonalGoal(int id, Game game){
        Pgoal personalGoal;
        switch (id){
            case 0:
                personalGoal = new PersonalGoal0();
                personalGoal.setGame(game);
                return personalGoal;
            case 1:
                personalGoal = new PersonalGoal1();
                personalGoal.setGame(game);
                return personalGoal;
            case 2:
                personalGoal = new PersonalGoal2();
                personalGoal.setGame(game);
                return personalGoal;
            case 3:
                personalGoal = new PersonalGoal3();
                personalGoal.setGame(game);
                return personalGoal;
            case 4:
                personalGoal = new PersonalGoal4();
                personalGoal.setGame(game);
                return personalGoal;
            case 5:
                personalGoal = new PersonalGoal5();
                personalGoal.setGame(game);
                return personalGoal;
            case 6:
                personalGoal = new PersonalGoal6();
                personalGoal.setGame(game);
                return personalGoal;
            case 7:
                personalGoal = new PersonalGoal7();
                personalGoal.setGame(game);
                return personalGoal;
            case 8:
                personalGoal = new PersonalGoal8();
                personalGoal.setGame(game);
                return personalGoal;
            case 9:
                personalGoal = new PersonalGoal9();
                personalGoal.setGame(game);
                return personalGoal;
            case 10:
                personalGoal = new PersonalGoal10();
                personalGoal.setGame(game);
                return personalGoal;
            case 11:
                personalGoal = new PersonalGoal11();
                personalGoal.setGame(game);
                return personalGoal;
            default:
                return null;
        }
    }
}

