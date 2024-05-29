package PatikaStore;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class PatikaStore {
    static Brand[] brandList = new Brand[9];
    Scanner inp = new Scanner(System.in);
    TreeSet<Phone> phonesByName = new TreeSet<>(Comparator.comparing(Phone::getName));
    TreeSet<Integer> phoneIDList = new TreeSet<>();
    TreeSet<Notebook> notebooksByName = new TreeSet<>(Comparator.comparing(Notebook::getName));
    TreeSet<Integer> notebookIDList = new TreeSet<>();

    static {
        String[] brands = {"Apple", "Asus", "Casper", "HP",
                "Huawei", "Lenovo", "Monster", "Samsung", "Xiaomi"};
        for (int i = 0;i < brands.length; i++) {
            brandList[i] = new Brand(brands[i], i);
        }
    }

    void run() {
        phonesByName.add(new Phone(1, 45, 256, 8, 4599.99, 0.15, 6.1, "Iphone 13S", "Apple", "Siyah", 3240));
        phonesByName.add(new Phone(2, 22, 512, 12, 6999.0, 0.05, 6.7, "Galaxy S6", "Samsung", "Beyaz", 4500));
        phonesByName.add(new Phone(3, 8, 128, 4, 2999.90, 0.10, 5.8, "Redmi 10C", "Xiaomi", "Mavi", 3700));
        phonesByName.add(new Phone(4, 35, 1024, 16, 8499.0, 0.0, 7.2, "Zenfone 2 5.0", "Asus", "Gri", 5000));
        phonesByName.add(new Phone(5, 15, 512, 8, 5299.0, 0.20, 6.5, "P50 Pro", "Huawei", "Yeşil", 4200));
        phoneIDList.add(1);
        phoneIDList.add(2);
        phoneIDList.add(3);
        phoneIDList.add(4);
        phoneIDList.add(5);
        notebooksByName.add(new Notebook(1, 425, 512, 8, 3599.99, 0.15, 12, "MacBook Air", "Apple"));
        notebooksByName.add(new Notebook(1, 145, 1024, 16, 13599.99, 0.2, 24, "Redmibook", "Xiaomi"));
        notebookIDList.add(1);
        notebookIDList.add(2);


        store : while (true) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1- Notebook İşlemleri");
            System.out.println("2- Cep Telefonu İşlemleri");
            System.out.println("3- Marka Listele");
            System.out.println("0- Çıkış Yap");
            int userChoice = inp.nextInt();
            System.out.println("Tercihiniz " + userChoice);

            switch (userChoice) {
                case 1:
                    choiceMenuNotebook();
                    break;
                case 2:
                    choiceMenuPhone();
                    break;
                case 3:
                    listAllBrands();
                    break;
                case 0:
                    break store;
            }
        }
    }

    void listAllBrands() {
        System.out.println("-------------");
        System.out.println("| Marka     |");
        System.out.println("-------------");
        for (Brand i : brandList) {
            System.out.println(String.format("| %-9s |", i.getName()));
        }
        System.out.println("-------------");
      }

    void listPhoneByBrand() {
        TreeSet<Phone> phonesByBrand = new TreeSet<>(Comparator.comparing(Phone::getBrand).thenComparing(Phone::getName));
        phonesByBrand.addAll(phonesByName);
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-25s | %-13s | %-10s | %-10s | %-10s | %-10s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Phone i : phonesByBrand) {
            System.out.printf("| %-2d | %-25s | %-10.1f TL | %-10s | %-10d | %-10.1f | %-10d |%n",
                    i.getId(), i.getName(), i.getPrice() * i.getDiscount(), i.getBrand(), i.getDiskCapacity(), i.getScreenSize(), i.getRAM());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    void listPhoneByName() {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-25s | %-13s | %-10s | %-10s | %-10s | %-10s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Phone i : phonesByName) {
            System.out.printf("| %-2d | %-25s | %-10.1f TL | %-10s | %-10d | %-10.1f | %-10d |%n",
                    i.getId(), i.getName(), i.getPrice(), i.getBrand(), i.getDiskCapacity(), i.getScreenSize(), i.getRAM());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    void addPhone() {
        int id;
        while (true) {
            System.out.print("Telefonun ID numarasını giriniz: ");
            int idTry = inp.nextInt();
            if (phoneIDList.contains(idTry)) {
                System.out.println("Lütfen başka bir ID numarası giriniz");
            } else {
                id = idTry;
                break;
            }
        }
        System.out.print("Telefonun stok miktarını giriniz: ");
        int stock = inp.nextInt();
        System.out.print("Telefonun hafıza kapasitesini giriniz: ");
        int diskCapacity = inp.nextInt();
        System.out.print("Telefonun kaç GB RAM'e sahip olduğunu giriniz: ");
        int RAM = inp.nextInt();
        System.out.print("Telefonun fiyatını giriniz: ");
        double price = inp.nextDouble();
        System.out.println("Telefonun indirim miktarını giriniz: ");
        double discount = inp.nextDouble();
        System.out.println("Telefonun ekran boyutunu giriniz: ");
        double screenSize = inp.nextDouble();
        System.out.println("Telefonun adını giriniz: ");
        inp.nextLine();
        String name = inp.nextLine();
        String brand;
        brand : while (true) {
            System.out.println("Telefonun markasını giriniz: ");
            String brandTry = inp.nextLine();
            for (Brand i : brandList) {
                if (brandTry.equals(i.getName())) {
                    brand = brandTry;
                    break brand;
                }
            }
            System.out.println("Veritabanında var olan bir marka giriniz");
        }
        System.out.println("Telefonun rengini giriniz: ");
        String color = inp.nextLine();
        System.out.println("Telefonun batarya gücünü giriniz: ");
        int batteryPower = inp.nextInt();

        Phone newPhone = new Phone(id, stock, diskCapacity, RAM, price, discount, screenSize, name, brand, color, batteryPower);
        phonesByName.add(newPhone);
        phoneIDList.add(newPhone.getId());
    }

    void deletePhone() {
        while (true) {
            System.out.println("Lütfen silmek istediğiniz telefonun ID numarasını giriniz: ");
            int deleteID = inp.nextInt();
            boolean isDeleted = false;
            Iterator<Phone> iter = phonesByName.iterator();
            while (iter.hasNext()){
                Phone next = iter.next();
                if (next.getId() == deleteID){
                    iter.remove();
                    isDeleted = true;
                }
            }
            if (isDeleted == false) {
                System.out.println("Lütfen var olan bir ID numarası giriniz.");
            } else {
                break;
            }
        }
    }

    void filterPhoneByBrand() {
        System.out.println("Listelemek istediğiniz telefon markasını giriniz: ");
        inp.nextLine();
        String chosenBrand = inp.nextLine();
        Iterator<Phone> iter = phonesByName.iterator();
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-25s | %-13s | %-10s | %-10s | %-10s | %-10s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");
        while (iter.hasNext()){
            Phone next = iter.next();
            if (next.getBrand().equals(chosenBrand)){
                System.out.printf("| %-2d | %-25s | %-10.1f TL | %-10s | %-10d | %-10.1f | %-10d |%n",
                        next.getId(), next.getName(), next.getPrice(), next.getBrand(), next.getDiskCapacity(), next.getScreenSize(), next.getRAM());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    void choiceMenuPhone() {
        System.out.println("1- Ürünleri Markaya Göre Listele");
        System.out.println("2- Ürünleri İsme Göre Listele");
        System.out.println("3- Ürünleri Markaya Göre Filtrele");
        System.out.println("4- Ürün Ekle");
        System.out.println("5- Ürün Sil");
        int userChoice = inp.nextInt();
        switch (userChoice) {
            case 1:
                listPhoneByBrand();
                break;
            case 2:
                listPhoneByName();
                break;
            case 3:
                filterPhoneByBrand();
                break;
            case 4:
                addPhone();
                break;
            case 5:
                deletePhone();
                break;
        }
    }

    void choiceMenuNotebook() {
        System.out.println("1- Ürünleri Markaya Göre Listele");
        System.out.println("2- Ürünleri İsme Göre Listele");
        System.out.println("3- Ürünleri Markaya Göre Filtrele");
        System.out.println("4- Ürün Ekle");
        System.out.println("5- Ürün Sil");
        int userChoice = inp.nextInt();
        switch (userChoice) {
            case 1:
                listNotebookByBrand();
                break;
            case 2:
                listNotebookByName();
                break;
            case 3:
                filterNotebooksByBrand();
                break;
            case 4:
                addNotebook();
                break;
            case 5:
                deleteNotebook();
                break;
        }
    }

    void listNotebookByBrand() {
        TreeSet<Notebook> notebooksByBrand = new TreeSet<>(Comparator.comparing(Notebook::getBrand).thenComparing(Notebook::getName));
        notebooksByBrand.addAll(notebooksByName);
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-25s | %-13s | %-10s | %-10s | %-10s | %-10s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Notebook i : notebooksByBrand) {
            System.out.printf("| %-2d | %-25s | %-10.1f TL | %-10s | %-10d | %-10.1f | %-10d |%n",
                    i.getId(), i.getName(), i.getPrice(), i.getBrand(), i.getDiskCapacity(), i.getScreenSize(), i.getRAM());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    void listNotebookByName() {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-25s | %-13s | %-10s | %-10s | %-10s | %-10s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Notebook i : notebooksByName) {
            System.out.printf("| %-2d | %-25s | %-10.1f TL | %-10s | %-10d | %-10.1f | %-10d |%n",
                    i.getId(), i.getName(), i.getPrice(), i.getBrand(), i.getDiskCapacity(), i.getScreenSize(), i.getRAM());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    void filterNotebooksByBrand() {
        System.out.println("Listelemek istediğiniz notebook markasını giriniz: ");
        inp.nextLine();
        String chosenBrand = inp.nextLine();
        Iterator<Notebook> iter = notebooksByName.iterator();
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-25s | %-13s | %-10s | %-10s | %-10s | %-10s |%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");
        while (iter.hasNext()) {
            Notebook next = iter.next();
            if (next.getBrand().equals(chosenBrand)) {
                System.out.printf("| %-2d | %-25s | %-10.1f TL | %-10s | %-10d | %-10.1f | %-10d |%n",
                        next.getId(), next.getName(), next.getPrice(), next.getBrand(), next.getDiskCapacity(), next.getScreenSize(), next.getRAM());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    void addNotebook() {
        int id;
        while (true) {
            System.out.print("Notebook'un ID numarasını giriniz: ");
            int idTry = inp.nextInt();
            if (notebookIDList.contains(idTry)) {
                System.out.println("Lütfen başka bir ID numarası giriniz");
            } else {
                id = idTry;
                break;
            }
        }
        System.out.print("Notebook'un stok miktarını giriniz: ");
        int stock = inp.nextInt();
        System.out.print("Notebook'un hafıza kapasitesini giriniz: ");
        int diskCapacity = inp.nextInt();
        System.out.print("Notebook'un kaç GB RAM'e sahip olduğunu giriniz: ");
        int RAM = inp.nextInt();
        System.out.print("Notebook'un fiyatını giriniz: ");
        double price = inp.nextDouble();
        System.out.println("Notebook'un indirim miktarını giriniz: ");
        double discount = inp.nextDouble();
        System.out.println("Notebook'un ekran boyutunu giriniz: ");
        double screenSize = inp.nextDouble();
        System.out.println("Notebook'un adını giriniz: ");
        inp.nextLine();
        String name = inp.nextLine();
        String brand;
        brandNotebook : while (true) {
            System.out.println("Notebook'un markasını giriniz: ");
            String brandTry = inp.nextLine();
            for (Brand i : brandList) {
                if (brandTry.equals(i.getName())) {
                    brand = brandTry;
                    break brandNotebook;
                }
            }
            System.out.println("Veritabanında var olan bir marka giriniz");
        }

        Notebook newNotebook = new Notebook(id, stock, diskCapacity, RAM, price, discount, screenSize, name, brand);
        notebooksByName.add(newNotebook);
        notebookIDList.add(newNotebook.getId());
    }

    void deleteNotebook() {
        while (true) {
            System.out.println("Lütfen silmek istediğiniz notebook'un ID numarasını giriniz: ");
            int deleteID = inp.nextInt();
            boolean isDeleted = false;
            Iterator<Notebook> iter = notebooksByName.iterator();
            while (iter.hasNext()){
                Notebook next = iter.next();
                if (next.getId() == deleteID){
                    iter.remove();
                    isDeleted = true;
                }
            }
            if (isDeleted == false) {
                System.out.println("Lütfen var olan bir ID numarası giriniz.");
            } else {
                break;
            }
        }
    }
}