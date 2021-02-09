import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        String delimiter = ", ";

        HashTable hashTable = new HashTable();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("data.txt")));
        String data = bufferedReader.readLine();

        String[] strings = data.split(delimiter);
        for (String el : strings) {
            hashTable.add(el);
        }

        for (String el: strings) {
            System.out.println("По ID " + el.hashCode() + " найдено: " + hashTable.find(el));
        }
    }
}