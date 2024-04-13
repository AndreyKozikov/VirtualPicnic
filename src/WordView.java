import java.io.IOException;
import java.util.*;

public class WordView {

    public static void fileStatistic () {
        ArrayWord arrayWord = new ArrayWord();
        try {
            FileReaderWord.wordReaderFromFile("input.txt", arrayWord);
            List<Word> words = new ArrayList<>(arrayWord.getValues());
            Collections.sort(words, Word.lengthComparator);
            System.out.println("Самое длинное слово: " + words.get(words.size() - 1).getWord() + " состоит из " + words.get(words.size() - 1).getCountChar() + " букв.");
            System.out.println("Самое короткое слово: " + words.get(0).getWord() + " состоит из " + words.get(0).getCountChar() + " букв.");
            Collections.sort(words, Word.countComparator);
            System.out.println("Чаще всего встречается слово: " + words.get(words.size() - 1).getWord() + ". Встречается раз: " + words.get(words.size() - 1).getWordCount());
            System.out.println("Реже всего встречается слово: " + words.get(0).getWord() + ". Встречается раз: " + words.get(0).getWordCount());
            System.out.println("Всего файл содержит уникальных слов: " + words.size());;
        } catch (RuntimeException | IOException e){

        }
    }
}
