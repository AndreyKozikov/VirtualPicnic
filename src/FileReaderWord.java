
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderWord {


    public static void wordReaderFromFile(String path, ArrayWord arrayWord) throws FileNotFoundException, IOException {
        int symbol;
        int charCount = 0;
        Boolean prevCharWasSpace = false;
        StringBuilder word = new StringBuilder();

        try (FileReader fr = new FileReader(path)) {
            while ((symbol = fr.read()) != -1) {
                if (!Character.isWhitespace(symbol) && !prevCharWasSpace) {
                    word.append((char) symbol);
                    charCount++;
                } else if (Character.isWhitespace(symbol) && !prevCharWasSpace) {
                    prevCharWasSpace = true;
                    arrayWord.addWord(word.toString(), charCount);
                    charCount = 0;
                    word.setLength(0);
                } else if (!Character.isWhitespace(symbol) && prevCharWasSpace) {
                    word.append((char) symbol);
                    charCount = 1;
                    prevCharWasSpace = false;
                }
            }

        } catch (FileNotFoundException e){
            System.err.println("Файл не найден.");
        } catch (IOException e) {
            System.err.println("Ошибка чтения из файла.");;
        }

    }
}
