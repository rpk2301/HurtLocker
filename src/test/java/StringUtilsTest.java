
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
public class StringUtilsTest {

    @Test
    public void testCapital()
    {
       String actual = StringUtils.CapitalFirst("jOHN");
       String expected = "John";
        Assert.assertEquals(expected,actual);


    }



}
