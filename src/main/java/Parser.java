import org.apache.commons.io.IOUtils;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Parser {

    static String output;
    static ArrayList<String[]> EvenBiggerArray = new ArrayList<>();


    public Parser() throws Exception {
    }

    public static String readRawDataToString() throws Exception{
        ClassLoader classLoader = Parser.class.getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void format()
    {
        for(String[] arrays: EvenBiggerArray)
        {
            for(int i=0; i<arrays.length;i++)
            {
               arrays[i] = StringUtils.CapitalFirst(arrays[i]);
            }
        }
    }

    public static ArrayList<String[]> normalize(ArrayList<String[]> Array)
    {
        ArrayList<String[]> ret = new ArrayList<>();
        for(int i= 0; i<Array.size();i++)
        {
             ret.add(Array.get(i));
        }
        for(int i= 0; i<ret.size();i++)
        {
            if ( ret.get(i).length>1 && ret.get(i)[1].contains("0") && ret.get(i)[1].contains("o"))
            {
                String apply ="";
               for(int j =0;j<ret.get(i)[1].length();j++)
               {
                   if(ret.get(i)[1].charAt(j)=='0')
                   {
                       apply+="o";
                   }
                   else apply+=ret.get(i)[1].charAt(j);
               }
            ret.get(i)[1] = apply;
            }
        }
        return ret;
    }



    public static void parse()
    {
        String[] outputArray = output.split("##");
        ArrayList<String[]> biggerArray = new ArrayList<>();
        ArrayList<String[]> EvenBiggerArray = new ArrayList<>();
        for(String item: outputArray)
        {
            biggerArray.add(item.split("[^A-Za-z0-9./:]"));

        }
        for(String[] item: biggerArray)
        {
            for(String item2: item)
            {
                EvenBiggerArray.add(item2.split("[:]"));
            }
        }
        EvenBiggerArray=normalize(EvenBiggerArray);
        Parser.EvenBiggerArray = EvenBiggerArray;
    }





    static {
        try {
            output = readRawDataToString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
