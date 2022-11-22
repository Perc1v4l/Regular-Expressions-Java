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
    @Test
    public void Guid()
    {
        Assert.assertTrue(reg.GUID_Check("e02fd0e4-00fd-090A-ca30-0d00a0038ba0"));
        Assert.assertTrue(reg.GUID_Check("e02fABCD-00f1-0903-7830-0d00a0038bA0"));
        Assert.assertTrue(reg.GUID_Check("F23d0e41-f04d-BcBA-ca30-0d00a0038ba0"));
        Assert.assertTrue(reg.GUID_Check("e02fd0e4-00fd-090A-ca30-0d00a0038ba0"));
        Assert.assertTrue(reg.GUID_Check("e02fd0e4-00fd-090A-abcd-0d00a0038ba0"));
        Assert.assertTrue(reg.GUID_Check("e02fd0e4-120f-090A-ca30-0d00a0038ba0"));

        Assert.assertFalse(reg.GUID_Check("----"));
        Assert.assertFalse(reg.GUID_Check("TT2fd0e4-00fd-090A-ca30-0d00a0038ba0"));
        Assert.assertFalse(reg.GUID_Check("e02fd0e41-00fd-090A-ca30-0d00a0038ba0"));
        Assert.assertFalse(reg.GUID_Check("e02fd0e4-020fd-090A-ca30-0d00a0038ba0"));
        Assert.assertFalse(reg.GUID_Check("e02fd0e4-00fd-0930A-ca30-0d00a0038ba0"));
        Assert.assertFalse(reg.GUID_Check("e02fd0e4-00fd-090A-ca430-0d00a02038ba0"));
    }
    @Test
    public void url()
    {
        Assert.assertTrue(reg.url_Check("http://www.example.com:80/path/to/myfile.html?key1=value1&key2=value2#SomewhereInTheDocument"));
        Assert.assertTrue(reg.url_Check("http://www.example.com"));
        Assert.assertTrue(reg.url_Check("http://example.com"));
        Assert.assertTrue(reg.url_Check("http://example.com:8080"));
        Assert.assertTrue(reg.url_Check("http://example.com"));
        Assert.assertTrue(reg.url_Check("developer.mozilla.org/ru/search.jpg?q=URL"));

        Assert.assertFalse(reg.url_Check("Just text"));
        Assert.assertFalse(reg.url_Check("http://a.com"));
        Assert.assertFalse(reg.url_Check("http://aads-.com"));
        Assert.assertFalse(reg.url_Check("http://-asda.com"));
        Assert.assertFalse(reg.url_Check("http://asd_sdas.com"));
        Assert.assertFalse(reg.url_Check("http://adsa dsa.com"));
    }
    @Test
    public void passwrd()
    {
        Assert.assertTrue(reg.pass_is_diff("C00l_Pass"));
        Assert.assertTrue(reg.pass_is_diff("SupperStas228"));
        Assert.assertTrue(reg.pass_is_diff("NukutaSheshin1love"));
        Assert.assertTrue(reg.pass_is_diff("NastyaMohova2love"));
        Assert.assertTrue(reg.pass_is_diff("Nadejda_Vladimirovna_B3st"));
        Assert.assertTrue(reg.pass_is_diff("plsHelps0me0ne"));

        Assert.assertFalse(reg.pass_is_diff("C00l_ps"));
        Assert.assertFalse(reg.pass_is_diff("C00L_PASS"));
        Assert.assertFalse(reg.pass_is_diff("sadsa2323112321"));
        Assert.assertFalse(reg.pass_is_diff("SimpleCode"));
        Assert.assertFalse(reg.pass_is_diff("C00L_PASS210321"));
        Assert.assertFalse(reg.pass_is_diff("chtobiewepridumat'?????"));
    }
}
