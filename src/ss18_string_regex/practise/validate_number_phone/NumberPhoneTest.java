package ss18_string_regex.practise.validate_number_phone;

import ss18_string_regex.practise.validate_name_class.NameClass;

public class NumberPhoneTest {
    private static NumberPhone numberPhone;
    public static final String[] validNum = new String[] { "(84)-(0978489648)" };
    public static final String[] invalidNum = new String[] { "(a8)-(22222222)" };

    public static void main(String args[]) {
        numberPhone = new NumberPhone();
        for (String email : validNum) {
            boolean isvalid = numberPhone.validate(email);
            System.out.println("Email is " + email +" is valid: "+ isvalid);
        }
        for (String email : invalidNum) {
            boolean isvalid = numberPhone.validate(email);
            System.out.println("Email is " + email +" is valid: "+ isvalid);
        }
    }
}
