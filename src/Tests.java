import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
private Regular_Expression reg;

    @Before
    public void init(){reg=new Regular_Expression();}
    @After
    public void tearDown(){reg=null;}

    @Test
    public void ip()
    {
        Assert.assertTrue(reg.ip_Check("127.1.1.255"));
        Assert.assertTrue(reg.ip_Check("0.0.0.0"));
        Assert.assertTrue(reg.ip_Check("255.255.255.255"));
        Assert.assertTrue(reg.ip_Check("128.0.0.123"));
        Assert.assertTrue(reg.ip_Check("12.13.14.15"));
        Assert.assertTrue(reg.ip_Check("23.0.3.0"));

        Assert.assertFalse(reg.ip_Check("..."));
        Assert.assertFalse(reg.ip_Check("123.256.0.255"));
        Assert.assertFalse(reg.ip_Check("300.1.1.255"));
        Assert.assertFalse(reg.ip_Check("127.1.10003.255"));
        Assert.assertFalse(reg.ip_Check("127.1.1.2532"));
        Assert.assertFalse(reg.ip_Check("1290.12.12.255"));
    }
}
