package Practice_Most_Frequent_Word;

import java.util.*;

public class Practice_Most_Frequent_Word {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Metni giriniz: ");
        String text = inp.nextLine();

        String[] splitText = text.split("\\s+");
        HashMap<String,Integer> words = new HashMap<String,Integer>();

        for (String k : splitText) {
            if (words.containsKey(k)) {
                words.put(k, words.get(k) + 1);
            } else {
                words.put(k, 1);
            }
        }

        Iterator<Map.Entry<String, Integer>> hashIt = words.entrySet().iterator();

        int maxCounter = 0;
        String maxKey = null;
        while(hashIt.hasNext()) {
            Map.Entry<String, Integer> key = hashIt.next();
            if (key.getValue() > maxCounter) {
                maxCounter = key.getValue();
                maxKey = key.getKey();
            }
        }

        System.out.println(maxKey + " kelimesi " + maxCounter + " kere tekrar ediyor.");
    }
}
