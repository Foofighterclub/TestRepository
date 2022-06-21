import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPhoneRegex {



  /*
    args[0] = "554891894" --> true se è un numero di telefono valido
    "asfd454646465465werwe"
    "123 244599"
    "+56 123 8658 999"


   */

  private static String PHONE_NUMBER_PATTERN = "\\s*([+]\\d{0,2})?\\s*(\\d{3})\\s*(\\d{2})\\s*(\\d{2})\\s*(\\d{3})\\s*";

  public static void main(String[] args) {

    String inputNumber = args[0];

    boolean isValid = isPhoneNumeber(inputNumber);

    System.out.println(isValid);

    if (isValid) {
      doFormatPhoneNumberV2(inputNumber);

    } else {
      System.out.printf("Invalid input format");
    }


  }

  private static boolean isPhoneNumeber(String input) {
    Pattern phonePattern = Pattern.compile("\\s*\\+?(\\s*\\d+\\s*)*\\s*");

    Pattern secondPhonePattern = Pattern.compile(PHONE_NUMBER_PATTERN);

    Matcher phoneMatcher = phonePattern.matcher(input);

    return phoneMatcher.matches();
  }

  private static String doFormatPhoneNumber(String input) {
    Pattern digitPattern = Pattern.compile("(\\d)");

    Matcher numberMatcher = digitPattern.matcher(input);

    String formatResult = "";

    while (numberMatcher.find()) {

      formatResult += numberMatcher.group(1);

    }

    return formatResult;
  }

  private static void doFormatPhoneNumberV2(String input) {
    Pattern digitPattern = Pattern.compile(PHONE_NUMBER_PATTERN);

    Matcher numberMatcherV2 = digitPattern.matcher(input);

    if (numberMatcherV2.matches()) {
      System.out.printf("Phone number: %s %s %s %s %s\n", numberMatcherV2.group(1) != null ? numberMatcherV2.group(1) : "",
          numberMatcherV2.group(2), numberMatcherV2.group(3), numberMatcherV2.group(4),
          numberMatcherV2.group(5));
    }

  }


}


