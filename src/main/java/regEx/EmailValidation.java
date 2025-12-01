package regEx;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//
public class EmailValidation {

    public static void main(String[] args) {
        List<String> list = List.of(
                "ab*c@gmail.com","abc123gmail.com", "ab3c@yahoo.com.co",
                "a_b@rediffmail.org", ".com" , "abc23.com", "abc@", "3494@gmail.com",
                "test@domain", "user@subdomain.domain.com", "user@domain.c", "test@?domain.com"
        );

        for(String email : list) {
            System.out.println("Email-> "+email+" is "+"valid? "+validateEmail(email));
        }

    }

    private static boolean validateEmail(String email) {
       if(email==null || email.isEmpty()) {
           return false;
       }
       String EMAIL_REGEX  = "^[a-zA-Z0-9_+&*-]+@[a-zA-Z0-9.-]+\\.+[a-zA-Z]{2,7}$";

       Pattern pattern = Pattern.compile(EMAIL_REGEX);
       Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
