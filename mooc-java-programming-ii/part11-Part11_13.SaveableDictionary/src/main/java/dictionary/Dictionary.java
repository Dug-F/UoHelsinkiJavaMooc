package dictionary;


public class Dictionary {
    private String word;
    private String translation;
    private boolean direction;                // true = forward (e.g. English to Finnish), false = reverse (e.g. Finnish to English)

    public Dictionary(String word, String translation, boolean direction) {
        this.word = word;
        this.translation = translation;
        this.direction = direction;
    }
    
    public String getWord() {
        return this.word;
    }
    
    public String getTranslation() {
        return this.translation;
    }
    
    public boolean getDirection() {
        return this.direction;
    }
    
}
