import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws Exception{
    Parser.readRawDataToString();
    Parser.parse();
    Parser.format();
    ItemList itemList = new ItemList();
    itemList.ListBuilder();
    System.out.println(itemList.toString());
}}
