package LoginUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String args[]) {

        String pattern = "^[\\d\\.\\d]";
        String text = "1 item(s) - $0.00";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        m.reset();

        while (m.find()) {

            System.out.print(text.substring(m.start(), m.end()));
        }
    }

       /* String pattern = "\\d\\.\\d+";
        String text = "1 item(s) - $0.00";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        m.reset();

        while (m.find()){

            System.out.print(text.substring(m.start(), m.end()));
        }
    }*/

}
