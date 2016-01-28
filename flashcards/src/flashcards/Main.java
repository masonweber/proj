/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mason
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Biology b = new Biology();
        Random r = new Random();
        b.add("Mason", " is awesome.");
        b.add("Kisses", " is a dog.");
        b.add("Molly", " is a pretty girl.");
        b.add("Kari", " is moving out.");
        int flag = 0;
        String ans;
        Scanner in = new Scanner(System.in);
        while (flag >= 0) {
            System.out.println("Options: (select mode)");
            System.out.println("1. Guess definition from vocab word");
            System.out.println("2. Guess vocab word from definition");
            System.out.println("3. Multiple choices for definition");
            System.out.println("4. Multiple choices for vocab word");
            try {
                flag = in.nextInt();
            } catch (Exception e) {
                flag = -1;
                System.out.println(flag);
            }
            String key, lock;
            String[] keys, locks;

            switch (flag) {
                case 1:
                    //mode 1: match vocab word to definition            
                    key = b.randKey();
                    lock = b.get(key);
                    //show key
                    System.out.println(key);
                    //wait for buttonpress to show lock
                    ans = in.next();
                    System.out.println(lock);
                    break;

                case 2:
                    //mode 2: match definition to vocab word
                    key = b.randKey();
                    lock = b.get(key);
                    //show lock
                    System.out.println(lock);
                    //wait for buttonpress to show key
                    ans = in.next();
                    System.out.println(key);
                    break;

                case 3:
                    //mode 3: quiz style multiple choice match vocab to def
                    keys = b.randFourKeys();
                    locks = new String[4];
                    for (int i = 0; i < 4; i++) {
                        locks[i] = b.get(keys[i]);
                    }
                    int j = r.nextInt(4);
                    System.out.println(keys[j]);
                    System.out.println("A: " + locks[0]);
                    System.out.println("B: " + locks[1]);
                    System.out.println("C: " + locks[2]);
                    System.out.println("D: " + locks[3]);
                    
                    ans = in.next();
                    System.out.println(locks[j]);
                    break;

                case 4:
                    //mode 4: quiz style multiple choice match def to vocab
                    keys = b.randFourKeys();
                    locks = new String[4];
                    for (int i = 0; i < 4; i++) {
                        locks[i] = b.get(keys[i]);
                    }
                    j = r.nextInt(4);
                    System.out.println(locks[j]);
                    System.out.println("A: " + keys[0]);
                    System.out.println("B: " + keys[1]);
                    System.out.println("C: " + keys[2]);
                    System.out.println("D: " + keys[3]);
                    
                    ans = in.next();
                    System.out.println(keys[j]);
                    break;

                default:
                    System.out.println(flag);
                    flag = -1;
                    break;
            }
            
        }
    }
    
    public static void guessDef() {
        
    }
}
