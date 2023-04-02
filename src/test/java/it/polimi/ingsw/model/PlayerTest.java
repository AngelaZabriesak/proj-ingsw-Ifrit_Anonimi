package it.polimi.ingsw.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private static Player player;

    @BeforeAll
    public static void initBag(){
        player = new Player("0");
    }

    @Test
    @DisplayName("Testing getting the adjacency present in the shelf")
    public void getAdjacencyGoal(){

    }
}
