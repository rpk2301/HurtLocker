import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemList extends ArrayList<GroceryItem> {


    public void ListBuilder() {
        String Name;
        String Price;
        String Type;
        String Expiration;
        for (int i = 0; i < Parser.EvenBiggerArray.size(); i += 4) {
            String NameTag = Parser.EvenBiggerArray.get(i)[0];
            try {
                Name = Parser.EvenBiggerArray.get(i)[1];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("NO IDENTIFIER FOUND");
                Name = "No Item Name";
            }
            String PirceTag = Parser.EvenBiggerArray.get(i + 1)[0];
            try {
                Price = Parser.EvenBiggerArray.get(i + 1)[1];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("NO IDENTIFIER FOUND");
                Price = "0.00";
            }
            String TypeTag = Parser.EvenBiggerArray.get(i + 2)[0];
            Type = Parser.EvenBiggerArray.get(i + 2)[1];
            String ExpirationTag = Parser.EvenBiggerArray.get(i + 3)[0];
            Expiration = Parser.EvenBiggerArray.get(i + 3)[1];
            GroceryItem added = new GroceryItem(Name, Double.parseDouble(Price), Type, Expiration);
            this.add(added);
        }
    }


    public int countGrocery(ArrayList<GroceryItem> list, String name) {
        int seen = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).name.equals(name)) {
                seen++;
            }
        }
        return seen;
    }

    public int countPrice(ArrayList<GroceryItem> list, double price, String name) {
        int seen = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).price == price && list.get(i).name.equals(name)) {
                seen++;
            }
        }
        return seen;
    }


    public ArrayList<String> countGroceryWords()
    {
        ArrayList<String> temp = new ArrayList<>();
        for(int i =0; i<this.size();i++)
        {
            if(!temp.contains(this.get(i).name))
            {
                temp.add(this.get(i).name);
            }
        }
        return  temp;
    }

   public Map<Double,Integer> getPrices(String name)
   {
       Map<Double, Integer> temp = new HashMap<>();
       for (int i = 0; i < this.size(); i++)
       {
           if (this.get(i).name.equals(name))
           {
               if (!temp.containsKey(this.get(i).price))
               {
                   temp.put(this.get(i).price, 1);
               }
               else
               {
                   Integer f = temp.get(this.get(i).price);
                   temp.put(this.get(i).price, f + 1);
               }
           }
       }
       return temp;
   }

   public ArrayList createList()
   {

     ArrayList items = this.countGroceryWords();


   }



    @Override
    public String toString()
        {
            ArrayList<String> hasBeenCounted = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            //Put item in list if it has already been counted.

            for(int i=0; i<this.size();i++)
            {
                ArrayList<Double> prices = new ArrayList<Double>();
                if(!hasBeenCounted.contains(this.get(i).name))
                {
                    hasBeenCounted.add(this.get(i).name);
                    //Add All Names
                  int  count =  countGrocery(this,this.get(i).name);
                  //Count the number of names this item
                  sb.append("name:   "+ this.get(i).name + "      seen: " + count + " times." );
                  sb.append("\n");
                  double price = this.get(i).price;
                  //
                  prices.add(price);
                  //adds price to the list
                  int countprice = countPrice(this,price,this.get(i).name);
                  sb.append("Price:    $" + this.get(i).price +"     seen:    " + countprice + " times");
                  sb.append("\n");
                  for(int j=0; j<this.size(); j++)
                  {
                   if(this.get(j).name.equals(this.get(i).name) && (!prices.contains(this.get(j).price)))
                   //If more prices with this name exist.
                      {
                          double retPrice = this.get(j).price;
                          prices.add(retPrice);
                          int counter = countPrice(this,retPrice,this.get(j).name);
                          sb.append("Price:      $" + retPrice + "     seen:   "+ counter + " times");
                          sb.append("\n");
                      }
                  }

                }
            }
            return sb.toString();

                //Check for name
                //Check for price







        }




        }










