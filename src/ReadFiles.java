import java.io.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFiles {
    public static File[] avalibleFiles(String dir) {
        File folder = new File(dir);
        if (!(folder.exists() && folder.isDirectory())) {
            System.out.println("Folder does not exist or is not a directory: " + dir);
            System.exit(2);
        }
        return folder.listFiles();
    }

    public static LinkedList<String> readNumbersInFile(File[] file){
        LinkedList<String> numbers = new LinkedList<>();
        /* this regex makes possible the number have or not '(' or ')' or both at the first 3 digits of the number
           it makes optional spaces instead of "-" or, just the number itself.
           it'll group by certain amount of numbers, wich will help to ensure everything is equally formatted later
        */
        Pattern numberPattern = Pattern.compile("\\(?([0-9]{3})\\)? ?-?([0-9]{3})-? ?([0-9]{4})");
        for (File f : file) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String line;
                while ((line = reader.readLine()) != null) {
                    Matcher numberMatches = numberPattern.matcher(line);
                    if (numberMatches.find()){
                        String number = "("+numberMatches.group(1)+") "+numberMatches.group(2)+"-"+numberMatches.group(3);
                        numbers.offer(number);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return numbers;
    }
}
