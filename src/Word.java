import java.util.Comparator;

public class Word implements Comparable<Word>{
    private String word;
    private int charCount;
    private int wordCount;



    public Word(String word, int countChar) {
        this.word = word;
        this.charCount = countChar;
        this.wordCount = 1;
    }

    public String getWord() {
        return word;
    }

    public int getCountChar() {
        return charCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    @Override
    public String toString() {
        return "В слове "  + word + ' ' + charCount + " букв(ы). " + "Слово встречается " + wordCount + " раз(а).\n";
    }

    @Override
    public int compareTo(Word other) {
        return this.word.compareTo(other.word);
    }

    // Компаратор для сортировки по длине слова
    public static Comparator<Word> lengthComparator = Comparator.comparingInt(w -> w.charCount);

    // Компаратор для сортировки по количеству вхождений слова
    public static Comparator<Word> countComparator = Comparator.comparingInt(w -> w.wordCount);
}
