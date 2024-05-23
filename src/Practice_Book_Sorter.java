import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Practice_Book_Sorter {
    public static void main(String[] args) {
        Book b1 = new Book("Ölü Canlar",484, "Nikolay Gogol", 1842);
        Book b2 = new Book("Aylaklığa Övgü",192, "Bertrand Russell", 1935);
        Book b3 = new Book("Fahrenheit 451", 230, "Ray Bradbury", 1953);
        Book b4 = new Book("Küçük Prens", 120, "Antoine de Saint-Exupery", 1943);
        Book b5 = new Book("Otomatik Portakal", 171, "Anthony Burgess", 1962);

        Set<Book> booksByName = new TreeSet<>();
        booksByName.add(b1);
        booksByName.add(b2);
        booksByName.add(b3);
        booksByName.add(b4);
        booksByName.add(b5);

        Iterator<Book> iter = booksByName.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().getName());
        }

        Set<Book> booksByPage = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return Integer.compare(book1.getPageNum(), book2.getPageNum()); // Assuming your method is called 'getPageNumber'
            }
        });

        for (Book b : booksByName) {
            booksByPage.add(b);
        }

        System.out.println("\n");
        Iterator<Book> iter2 = booksByPage.iterator();
        while (iter2.hasNext()) {
            Book currentIter = iter2.next();
            System.out.println(currentIter.getName() + " - Sayfa sayısı: " + currentIter.getPageNum());
        }

    }
}
