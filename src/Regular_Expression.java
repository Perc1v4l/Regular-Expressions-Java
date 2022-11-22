import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular_Expression
{
    boolean ip_Check(String s)
    {
        String regex = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        if(Pattern.matches(regex,s)) return true;
        else return false;
    }
}
