import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        try{
            File file = new File("In.txt");
            Scanner scannerFile = new Scanner(file);
            while(scannerFile.hasNextLine()){
                String word = scannerFile.nextLine().toLowerCase();
                String[] words = word.split("\\s+");
                for (String lines : words) {
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if(!word.isBlank()){
                        wordCount.put(lines, wordCount.getOrDefault(lines, 0) + 1);
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("linie====");

        Map<String, Integer> nameCount = new HashMap<>();
        String FrequentName = "";
        int FrequentCount = 0;

        try{
            File fileName = new File("Person.txt");
            Scanner scannerFile = new Scanner(fileName);
            while(scannerFile.hasNextLine()){
                String name = scannerFile.nextLine().toLowerCase();
                nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
                if(nameCount.get(name) > FrequentCount){
                    FrequentCount = nameCount.get(name);
                    FrequentName = name;
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(FrequentName + " " + FrequentCount);
    }
}
