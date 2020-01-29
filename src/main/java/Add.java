import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import javax.print.DocFlavor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Add {

    private String patternString = "-\\d+|\\d+"; //regex pattern

    int sum = 0;

    public int add(String numbers) throws Exception {
            String delimiter = "\\[.+?\\]"; //a string that looks for any character that starts with a [ and ends with a ]
            Pattern patternDelimiter = Pattern.compile(delimiter);
            Matcher matcherDelimiter = patternDelimiter.matcher(numbers);

            while (matcherDelimiter.find()) {
                numbers = numbers.replace(matcherDelimiter.group().substring(1, matcherDelimiter.group().indexOf("]")), ",");
            }

            if (numbers.length() >= 2 && numbers.substring(0, 2) == "//") {
                numbers = numbers.replace(numbers.substring(2, numbers.indexOf("\n")), ",");  /*replace the delimiter before printing or calculating the sum*/
            }
            // numbers = numbers.replace(numbers.substring(2, numbers.indexOf("\n")), ",");

            StringBuilder negatives = new StringBuilder();

            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(numbers);

            while (matcher.find()) {
                int stringToInt = Integer.parseInt(matcher.group());

                /*If statement to check if a number is a negative number*/
                if (stringToInt < 0) {
                    negatives.append(stringToInt).append(",");

                }
                /*If the number is negative, an error message will be thrown*/
                else if (negatives.length() != 0) {
                    throw new Exception("ERROR: negatives not allowed" + negatives.substring(0, negatives.length() - 1));
                }

                /*If statement to check if a number is greater than 1000 and it ignore it*/
                if (stringToInt >= 1000) {
                    sum += 0;
                } else {
                    sum += Integer.parseInt(matcher.group());
                }

               if(numbers.startsWith("") && numbers.endsWith(";")){
                   throw new Exception("ERROR: invalid input");
               }

        }
        return sum;
    }

}