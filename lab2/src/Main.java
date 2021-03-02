import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("data.txt")));

        String result = "";
        String line;
        while((line = bufferedReader.readLine()) != null){
            result+=line;
        }

        result = result.replaceAll("\n", "");
        String[] functions = result.split(";");

        System.out.println("Лексема" + "\t\tТип лексемы\n");

        for (String function :
                functions) {
            if (function.contains(")") && function.contains("(")) {
                function = deleteSpaces(function);
                if(function.charAt(function.length() - 1) != ')'){
                    cleanConsole();
                    throw new Exception("Syntax error!");
                }

                int left = function.indexOf("(");
                int right = function.indexOf(")");
                String functionName = function.substring(0, left);

                String allParams = function.substring(left + 1, right);

                functionName = deleteSpaces(functionName);
                allParams = deleteSpaces(allParams);

                if (functionName.contains(" ")
                        || functionName.contains("\t")
                        || functionName.contains("\n")
                        || functionName.contains("\\")) {

                    cleanConsole();
                    throw new Exception("Spaces on Function Name");
                }

                System.out.println(functionName + "\t\t\tИмя процедуры");


                String[] params = allParams.split(",");
                for (String param:
                        params) {
                    param = deleteSpaces(param);
                    if(!param.isEmpty()) {
                        if (param.contains(" ")
                                || functionName.contains("\t")
                                || functionName.contains("\n")
                                || functionName.contains("\\")) {

                            cleanConsole();
                            throw new Exception("Spaces on Param Name");
                        }

                        if (isParamRomanNumeral(param)) {
                            System.out.println(param + "\t\t\tРимская цифра");
                        } else {
                            System.out.println(param + "\t\t\tИдентификатор");
                        }

                    }

                }

            }
        }

    }

    public static boolean isParamRomanNumeral(String param){
        if(param.charAt(0) == '-'){
            param = param.replaceAll("X", "");
            param = param.replaceAll("V", "");
            param = param.replaceAll("I", "");
            if(param.length() == 1)
                return true;
            else
                return false;
        }
        param = param.replaceAll("X", "");
        param = param.replaceAll("V", "");
        param = param.replaceAll("I", "");

        if(param.isEmpty())
            return true;
        else
            return false;
    }

    public static String deleteSpaces(String string){
        if(string.isEmpty())
            return "";
        while(string.indexOf(" ") == 0){
            string = string.replaceFirst(" ", "");
        }
        if(string.isEmpty())
            return "";
        while(string.lastIndexOf(" ") == string.length() - 1){
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }

    public static void cleanConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
