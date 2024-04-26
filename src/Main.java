import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                java.io.File selectedFile = fileChooser.getSelectedFile();
                String fileName = selectedFile.getName();
                int lines = 0;
                int words = 0;
                int characters = 0;

                FileReader fileReader = new FileReader(selectedFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    lines++;
                    characters += line.length();
                    // Split the line by spaces to count words
                    String[] wordsArray = line.split("\\s+");
                    words += wordsArray.length;
                }

                bufferedReader.close();

                System.out.println("File Summary:");
                System.out.println("File Name: " + fileName);
                System.out.println("Number of Lines: " + lines);
                System.out.println("Number of Words: " + words);
                System.out.println("Number of Characters: " + characters);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
