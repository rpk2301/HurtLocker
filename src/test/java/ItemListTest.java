import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ItemListTest {

    //Im going to put stuff in here I promise.
    @Test
    public void testCountGroceryWords()
    {
        ItemList list = new ItemList();
        list.add(new GroceryItem("Milk",9.99,"Food","9/10/21"));
        list.add(new GroceryItem("Broccoli",10.99,"Food","9/10/21"));
        list.add(new GroceryItem("Pizza",9.99,"Food","9/10/21"));
        list.add(new GroceryItem("Garlic",10.99,"Food","9/10/21"));
        int expeced = 4;
        ArrayList F = list.countGroceryWords();
        int actual = F.size();
        Assert.assertEquals(expeced,actual);
    }
    @Test
    public void testMap()
    {
        ItemList list = new ItemList();
        list.add(new GroceryItem("Milk",9.99,"Food","9/10/21"));
        list.add(new GroceryItem("Milk",10.99,"Food","9/10/21"));
        list.add(new GroceryItem("Milk",9.99,"Food","9/10/21"));
        list.add(new GroceryItem("Milk",10.99,"Food","9/10/21"));
        Map expeced = list.getPrices("Milk");
       Assert.assertTrue(expeced.keySet().contains(10.99));
       Assert.assertTrue(expeced.keySet().contains(9.99));
       Assert.assertTrue(expeced.get(10.99).equals(2));
    }

    @Test
    public void testCountGrocery()
    {
        ItemList list = new ItemList();
        list.add(new GroceryItem("Milk",9.99,"Food","9/10/21"));
        list.add(new GroceryItem("Milk",10.99,"Food","9/10/21"));
        list.add(new GroceryItem("Milk",9.99,"Food","9/10/21"));
        list.add(new GroceryItem("Milk",10.99,"Food","9/10/21"));
        int actual = list.countGrocery(list,"Milk");
        Assert.assertEquals(4,actual);
    }

    @Test
    public void testCountPrice()
    {
        ItemList list = new ItemList();
        list.add(new GroceryItem("Milk",9.99,"Food","9/10/21"));
        list.add(new GroceryItem("Milk",10.99,"Food","9/10/21"));
        list.add(new GroceryItem("Milk",9.99,"Food","9/10/21"));
        list.add(new GroceryItem("Milk",10.99,"Food","9/10/21"));
        int actual = list.countPrice(list,10.99,"Milk");
        Assert.assertEquals(2,actual);
    }




}