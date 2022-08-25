package ss18_string_regex.exercise.validate_email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    private static Pattern pattern;
    private Matcher matcher;

    private  static final String EMail_Regex= "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+[A-Za-z0-9]+(\\.com)$";
     public EmailExample(){
         pattern= Pattern.compile(EMail_Regex);
     }

     public boolean validate(String regex){
         matcher = pattern.matcher(regex);
         return matcher.matches();
     }
}
