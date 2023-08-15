import org.apache.commons.io.IOUtils;

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
