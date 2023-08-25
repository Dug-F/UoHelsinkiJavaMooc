package dictionary;

import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.PrintWriter;

public class SaveableDictionary {
    private HashMap<String, Dictionary> words;
    private String filename;

    public SaveableDictionary() {
        this.words = new HashMap<>();
    }
    
    public SaveableDictionary(String file) {
        this();
        this.filename = file;
    }
    
    public boolean load() {
        try {
            Files.lines(Paths.get(this.filename))
                    .map(row -> row.split(":"))
                    .filter(row -> row.length == 2)
                    .forEach(s -> this.add(s[0], s[1]));
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(this.filename);
            this.words.values().stream()
                    .filter(w -> w.getDirection())
                    .forEach(w -> writer.println(w.getWord() + ":" + w.getTranslation()));
            writer.close();
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public void add(String words, String translation) {
        if (!this.words.containsKey(words)) {
            this.words.put(words, new Dictionary(words, translation, true));
            this.words.put(translation, new Dictionary(translation, words, false));
        }
    }
    
    public String translate(String word) {
        Dictionary entry = this.words.get(word);
        if (entry == null) {
            return null;
        }
        return entry.getTranslation();
    }
    
    public void delete(String word) {
        Dictionary entry = this.words.get(word);
        if (entry == null) {
            return;
        }
        String translation = entry.getTranslation();
        this.words.remove(word);
        this.words.remove(translation);
    }
}
