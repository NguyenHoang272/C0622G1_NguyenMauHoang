package ss18_string_regex.practise.validate_name_class;

public class NameClassTest {
        private static NameClass nameClass;
        public static final String[] validName = new String[] { "C0318G" };
        public static final String[] invalidName = new String[] { "M0318G" };

        public static void main(String args[]) {
            nameClass = new NameClass();
            for (String email : validName) {
                boolean isvalid = nameClass.validate(email);
                System.out.println("Email is " + email +" is valid: "+ isvalid);
            }
            for (String email : invalidName) {
                boolean isvalid = nameClass.validate(email);
                System.out.println("Email is " + email +" is valid: "+ isvalid);
            }
        }
    }

