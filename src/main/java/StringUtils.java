public class StringUtils {




    public static String CapitalFirst(String input)
    {
        String ret = "";
        for(int i=0;i<input.length();i++)
        {
           if(i==0)
           {
           ret+=Character.toUpperCase(input.charAt(i));
           }
           else ret += Character.toLowerCase(input.charAt(i));
        }
        return ret;

    }



}


