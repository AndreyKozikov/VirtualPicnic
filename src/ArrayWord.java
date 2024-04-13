import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ArrayWord implements Iterable<Word> {
    private HashMap<String, Word> dict;

    public ArrayWord() {
        this.dict = new HashMap<>();
    }

    public void addWord(String key, int charCount) {
        int countWord;
        Word tmpWord;
        if (this.dict.containsKey(key.toUpperCase())) {
            tmpWord = this.dict.get(key.toUpperCase());
            countWord = tmpWord.getWordCount();
            countWord++;
            tmpWord.setWordCount(countWord);
            this.dict.put(key.toUpperCase(), tmpWord);
        } else {
            this.dict.put(key.toUpperCase(), new Word(key, charCount));
        }
    }

    public Collection<Word> getValues() {
        return this.dict.values();

    }


    @Override
    public String toString() {
        return "ArrayWord{" +
                "dict=" + dict +
                '}';
    }

    @Override
    public Iterator<Word> iterator() {
        return this.dict.values().iterator();
    }
}
