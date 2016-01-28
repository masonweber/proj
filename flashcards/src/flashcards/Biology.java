/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flashcards;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Mason
 */
public class Biology {
    private HashMap pairs;
    
    public Biology() {
        pairs = new HashMap<>();
    }
    
    public void add(String key, String phrase) {
        pairs.put(key, phrase);
    }
    
    //pull random key
    public String randKey() {
        Random r = new Random();
        int i = r.nextInt(pairs.size());
        Object[] s = new String[pairs.size()];
        s = pairs.keySet().toArray();
        return s[i].toString();
    }
    
    //pull 4 random keys
    public String[] randFourKeys() {
        String[] s = new String[4];
        for (int i = 0; i < 4; i++) {
            s[i] = randKey();
        }
        return s;
    }
    
    public String get(String key) {
        return (String) pairs.get(key);
    }
}
