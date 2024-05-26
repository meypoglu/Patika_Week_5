package Practice_Most_Frequent_Word;

import java.util.*;

public class Practice_Most_Frequent_Word {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in); // Kullanıcıdan girdinin alınması
        System.out.println("Metni giriniz: ");
        String text = inp.nextLine();

        String[] splitText = text.split("\\s+"); // Alınan girdi split metodu ile kelimelere ayrılır
        HashMap<String,Integer> words = new HashMap<String,Integer>(); // Kelimelerin kaç kere tekrar edildiğinin tespit edilebilmesi için HashMap oluşturulur

        for (String k : splitText) { // Ayrılan kelimeler HashMap'e kaydedilir. Eğer halihazırda kayıtlı bir kelime varsa value kısmı 1 artırılır
            if (words.containsKey(k)) {
                words.put(k, words.get(k) + 1);
            } else {
                words.put(k, 1);
            }
        }

        Iterator<Map.Entry<String, Integer>> hashIt = words.entrySet().iterator(); // Elde edilen HashMap'teki en çok değere sahip key bir Iterator yardımıyla tespit edilir

        int maxCounter = 0; // Maksimum değeri tutan değişken
        String maxKey = null; // Maksimum değere sahip key'i tutan değişken
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
