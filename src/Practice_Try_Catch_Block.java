import java.util.Scanner;

public class Practice_Try_Catch_Block {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Bir değer giriniz: ");
        int num = inp.nextInt();
        returnByIndex(num);
    }

    static void returnByIndex(int inx) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        try {
            System.out.println(array[inx]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getClass().getName() + ": İndeks array boyutları dışındadır.");
        }
    }
}
