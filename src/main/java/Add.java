import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Add {

    private String patternString = "-\\d+|\\d+"; //regex pattern

    public int add(String numbers) throws Exception {

        if(numbers.length() >=2 && numbers.substring(0, 2) == "//") {
            numbers = numbers.replace(numbers.substring(2, numbers.indexOf("\n")), ",");  /*replace the delimiter before printing or calculating the sum*/
        }
       // numbers = numbers.replace(numbers.substring(2, numbers.indexOf("\n")), ",");

        StringBuilder negatives = new StringBuilder();

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(numbers);

        int sum=0;
        while(matcher.find())
        {
            int stringToInt = Integer.parseInt(matcher.group());

            /*If statement to check if a number is a negative number*/
            if(stringToInt<0)
            {
                negatives.append(stringToInt).append(",");
                //System.out.println(stringToInt);
            }
            /*If the number is negative, an error message will be thrown*/
            else if(negatives.length() !=0 )
            {
                throw new Exception("ERROR: negatives not allowed" + negatives.substring(0, negatives.length()-1));
            }

            /*If statement to check if a number is greater than 1000 and it ignore it*/
            if(stringToInt >= 1000){
                sum+= 0;
            }

            else {
                sum += Integer.parseInt(matcher.group());
            }
        }

        return sum;

    }
}
