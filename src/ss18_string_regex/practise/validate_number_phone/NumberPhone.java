package ss18_string_regex.practise.validate_number_phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPhone {
    private static Pattern pattern;
    private Matcher matcher;

    private  static final String Num_Regex= "^[(][0-9]{2}[)][-][(][0][0-9]{9}[)]$";
    public NumberPhone(){
        pattern= Pattern.compile(Num_Regex);
    }

    public boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
