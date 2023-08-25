package application;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Dictionary {
    private List<String> list;
    private Map<String, String> dict;
    
    public Dictionary() {
        this.list = new ArrayList<>();
        this.dict = new HashMap<>();
        
        this.add("owl", "chouette");

    }
    
    public String get(String word) {
        return this.dict.get(word);
    }
    
    public void add(String word, String translation) {
        if (this.dict.size() == 0 || !this.dict.containsKey(word)) {
            this.list.add(word);
        }
        this.dict.put(word, translation);
    }
    
    public String getRandomWord() {
        Random random = new Random();
        return this.list.get(random.nextInt(this.list.size()));
    }
}
