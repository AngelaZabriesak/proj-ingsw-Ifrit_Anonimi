package it.polimi.ingsw.Model.Bag;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    private static Item item;

    @BeforeAll
    public static void initItem(){
        item = new Item(ColorItem.GREEN);
    }

    @Test
    @DisplayName("Testing getting the right color")
    public void getColor(){
        assertEquals(ColorItem.GREEN,item.getColor());
    }
}
