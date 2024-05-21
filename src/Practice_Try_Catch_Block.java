import java.util.Scanner;

public class Practice_Try_Catch_Block {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in); // Kullanıcıdan girdi alınır
        System.out.println("Bir değer giriniz: ");
        int num = inp.nextInt();
        returnByIndex(num); // Metod çağrılır
    }

    static void returnByIndex(int inx) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Oluşturulan array
        try {
            System.out.println(array[inx]); // Arraydeki belirtilen indeks yazdırılmaya çalışılır, eğer hata alınırsa catch bloğuna girilir.
        } catch (ArrayIndexOutOfBoundsException e) { // OutOfBounds hatası burda yakalanır
            System.out.println(e.getClass().getName() + ": İndeks array boyutları dışındadır."); // Hata sınıfı alınır ve hata mesajıyla beraber yazdırılır
        }
    }
}
