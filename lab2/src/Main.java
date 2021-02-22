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

                int left = function.indexOf("(");
                int right = function.indexOf(")");
                String functionName = function.substring(0, left);

                String allParams = function.substring(left + 1, right);

                System.out.println(functionName + "\t\t\tИмя процедуры");


                String[] params = allParams.split(",");
                for (String param:
                     params) {
                    if(!param.isEmpty()) {
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

}
