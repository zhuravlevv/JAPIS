import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("data.txt")));

        String result = "";
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result += line;
        }

        result = result.replaceAll("\n", "");
        String[] functions = result.split(";");

        System.out.println("Лексема" + "\t\tТип лексемы\n");

        for (String function :
                functions) {
            if (checkFunction(function)) {
                function = deleteSpaces(function);

                int left = function.indexOf("(");
                int right = function.indexOf(")");
                String functionName = function.substring(0, left);

                String allParams = function.substring(left + 1, right);

                functionName = deleteSpaces(functionName);
                allParams = deleteSpaces(allParams);

                System.out.println(functionName + "\t\t\tИмя процедуры");

                String[] params = allParams.split(",");
                for (String param :
                        params) {
                    param = deleteSpaces(param);

                    if (checkRomanNumeral(param)) {
                        System.out.println(param + "\t\t\tРимская цифра");
                    } else if (checkIdentifier(param)) {
                        System.out.println(param + "\t\t\tИдентификатор");
                    } else if (!param.isEmpty()) {
                        cleanConsole();
                        throw new Exception("Syntax error in param - " + param);
                    }
                }

            } else {
                cleanConsole();
                throw new Exception("Syntax error in function - " + function);
            }
        }

    }

    private static boolean checkFunction(String function) {
        String regex = " *([a-zA-Z]+) *\\([a-zA-Z0-9 ,\\-]*\\) *";
        return function.matches(regex);
    }

    private static boolean checkIdentifier(String param) {
        String regex = "[a-zA-Z0-9]+";
        return param.matches(regex);
    }

    private static boolean checkRomanNumeral(String param) {
        String regex = "([-]?)([XVI]+)";
        return param.matches(regex);
    }

    private static String deleteSpaces(String string) {
        if (string.isEmpty())
            return "";
        while (string.indexOf(" ") == 0) {
            string = string.replaceFirst(" ", "");
        }
        if (string.isEmpty())
            return "";
        while (string.lastIndexOf(" ") == string.length() - 1) {
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }

    private static void cleanConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
