package it.polimi.ingsw.model.Bag;

import it.polimi.ingsw.model.Bag.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BagTest {
    private static Bag bag;

    @BeforeAll
    public static void initBag(){
        bag = new Bag();
    }

    @Test
    @DisplayName("Testing getting random item")
    public void getItem(){
        Item result0 = bag.getItem();
        Item result1 = bag.getItem();
        Item result2 = bag.getItem();
        System.out.println(result0.getColor()+"\t"+result1.getColor()+"\t"+result2.getColor()+"\t");
        assertEquals(129,bag.getSize());
    }
}
