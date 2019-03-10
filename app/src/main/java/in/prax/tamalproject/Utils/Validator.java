package in.prax.tamalproject.Utils;

/**
 * Created by HP on 3/20/2017.
 */

public class Validator {




    public static boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() >= 8;
    }

    public static boolean isUserValid(String Udise) {
        //TODO: Replace this with your own logic
        return Udise.length() == 10;
    }

    public static boolean isNotEmpty(String Udise) {
        //TODO: Replace this with your own logic
        return Udise.length() > 0;
    }
    public static boolean isMatched(String m1,String m2) {
        //TODO: Replace this with your own logic
        return m1.equals(m2);
    }

}
