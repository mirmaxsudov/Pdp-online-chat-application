package pdp_pnnline.abdurahmon.code.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DtoValidation {
    public static boolean checkEmail(String email) {
        return Pattern
                .compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
                .matcher(email).
                matches();
    }
}
