import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("\"" + calculator(scan.nextLine()) + "\"");
    }
    public static boolean isNumeric(String value) {
        return Pattern.matches("\\d+", value);
    }
    public static String calculator(String value) throws Exception {
        String[] spl = value.split("\"");
        String str = spl[2];
        if (!spl[0].equals("")) {
            throw new Exception();
        } else if (str.length() > 3) {
            String[] spl1 = str.split(" ");
            return mulDiv(spl[1], spl1[1], spl1[2]);
        } else {
            return sumMin(spl[1], spl[2], spl[3]);
        }
    }
    public static String sumMin(String value, String value1, String value2) throws Exception {
        if ((value.length() > 10) | (value2.length() > 10)) {
            throw new Exception();
        }
        if (value1.equals(" + ")) {
            return value + value2;
        } else if (value1.equals(" - ")) {
            return value.replace(value2, "");
        } else {
            throw new Exception();
        }
    }
    public static String mulDiv (String value, String value1, String value2) throws Exception {
        String result = "";
        if ((Integer.parseInt(value2) > 10) | (Integer.parseInt(value2) < 1) | (value.length() > 10)) {
            throw new Exception();
        }
        if (value1.equals("*")) {
             for (int i=0; i<Integer.parseInt(value2); i++) {
                 result += value;
             }
        } else if (value1.equals("/")) {
            int len = value.length() / Integer.parseInt(value2);
            return value.substring(0, len);
        } else {
            throw new Exception();
        }
        if (result.length() > 40) {
            return (result.substring(0, 40) + "...");
        }
        return result;
    }
}