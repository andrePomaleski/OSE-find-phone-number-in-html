import java.io.File;
import java.util.LinkedList;
// I would iterate throught all the directory containing the HTMLS files, and check all the text for numbers matches
public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("The right usage of the program is using the folder name after the default run");
            System.exit(1);
        }
        File[] filesList = ReadFiles.avalibleFiles(args[0]);
        if (filesList == null){
            System.out.println("The folder does not contain any file");
            System.exit(3);
        }
        LinkedList<String> allNumber = ReadFiles.readNumbersInFile(filesList);
        for (String number : allNumber) {
            System.out.println(number);
        }
    }
}