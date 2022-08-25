package ss18_string_regex.practise.validate_name_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClass {
    private static Pattern pattern;
    private Matcher matcher;

    private  static final String Name_Regex= "^[CAP]{1}?[0-9]{4}[GHIKLM]$";
    public NameClass(){
        pattern= Pattern.compile(Name_Regex);
    }

    public boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
