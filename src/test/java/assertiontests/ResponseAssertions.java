package assertiontests;

import org.junit.Assert;

public class ResponseAssertions {

    public static void responseResult(String actual, String expected){


        Assert.assertEquals("The response of the message",expected,actual);
    }
}
