package PatikaStore;

import java.util.*;

public class PatikaStore {
    private Scanner inp = new Scanner(System.in);
    private static TreeMap<String, Brand> brandSet = new TreeMap<>();


    void run() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            int userInput = inp.nextInt();
            System.out.println("Tercihiniz : " + userInput);
            switch (userInput) {
                case 1:
                    System.out.println("1 - Notebook'ları listele: ");
                    System.out.println("2 - Notebook ekle: ");
                    System.out.println("3 - Notebook sil: ");
                    System.out.println("0 - Önceki menüye dön: ");
                    userInput = inp.nextInt();
                    if (userInput == 1) {
                        System.out.println("Switche girdi");
                        listNotebooks();
                    } else if (userInput == 2) {
                        System.out.println("Eklemek istediğiniz notebook'un özelliklerini giriniz");
                        addNotebook();
                    } else if (userInput == 3) {
                        listNotebooks();
                        System.out.println("Silmek istediğiniz notebook'un id'sini giriniz: ");
                        userInput = inp.nextInt();
                        //deleteNotebook(userInput);
                    } else if (userInput == 0) {

                    }
                    break;
                case 2:
                    break;
                case 3:
                    //addBrand();
                    listBrands();
                    break;
                case 0:
                    break;
            }
        }
    }

    void addBrand() {
        System.out.println("Marka adını giriniz: ");
        String brandName = inp.nextLine();
        System.out.println("Markanın kayıt numarasını giriniz: ");
        int brandID = inp.nextInt();
        this.brandSet.put(brandName ,new Brand(brandName, brandID));
    }

    void addBrandDefault(String brandName, int brandID) {
        this.brandSet.put(brandName, new Brand(brandName, brandID));
    }

    void listBrands() {
        TreeSet<String> sortedKeys = new TreeSet<>( new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        sortedKeys.addAll(brandSet.keySet());

        for (String i : sortedKeys) {
            System.out.println(i);
        }
    }

    void addPhone() {
        System.out.println("Lütfen telefon özelliklerini giriniz");
        System.out.println("Lütfen notebook özelliklerini giriniz");
        System.out.println("Ürünün ID numarasını giriniz: ");
        int id = inp.nextInt();
        System.out.println("Ürünün ücretini giriniz: ");
        double price = this.inp.nextDouble();
        System.out.println("Ürünün indirim oranını giriniz: ");
        double discount = inp.nextDouble();
        System.out.println("Ürünün stoktaki miktarını giriniz: ");
        int stock = inp.nextInt();
        System.out.println("Ürünün adını giriniz: ");
        String name = inp.nextLine();
        System.out.println("Ürünün markasını giriniz: ");
        String brandName = inp.nextLine();
        System.out.println("Ürünün kaç GB RAM'e sahip olduğunu giriniz: ");
        int RAM = inp.nextInt();
        System.out.println("Ürünün depolama kapasitesinin kaç GB olduğunu giriniz: ");
        int diskSpace = inp.nextInt();
        System.out.println("Ürünün ekran boyutunun kaç inç olduğunu giriniz: ");
        double screenSize = inp.nextDouble();
        System.out.println("Ürünün batarya gücünü giriniz: ");
        double batteryPower = inp.nextDouble();
        System.out.println("Ürünün rengini giriniz: ");
        String color = inp.nextLine();
        Phone newPhone = new Phone(batteryPower, color ,id, price, discount, stock,
                name, brandName, RAM, diskSpace, screenSize);
        addToList(newPhone);
        Brand.phoneIDList.add(id);
        System.out.println("Ürün eklendi !");

    }

    void listNotebooks() {
        System.out.println("Liste metoduna girdi");
        TreeSet<Notebook> allNotebooks = new TreeSet<>(new Comparator<Notebook>() {
            @Override
            public int compare(Notebook n1, Notebook n2) {
                return n1.getName().compareTo(n2.getName());
            }
        });

        for (Brand i : brandSet.values()) {
            allNotebooks.addAll(i.getNotebookList());
        }
        for (Notebook k : allNotebooks) {
            System.out.println(k.getBrandName() + " " + k.getName());
        }
        }

    void addNotebook() {
        System.out.println("Ürünün ID numarasını giriniz: ");
        int id = inp.nextInt();
        System.out.println("Ürünün ücretini giriniz: ");
        double price = inp.nextDouble();
        System.out.println("Ürünün indirim oranını giriniz: ");
        double discount = inp.nextDouble();
        System.out.println("Ürünün stoktaki miktarını giriniz: ");
        int stock = inp.nextInt();
        inp.nextLine();
        System.out.println("Ürünün adını giriniz: ");
        String name = inp.nextLine();
        System.out.println("Ürünün markasını giriniz: ");
        String brandName = inp.nextLine();
        System.out.println("Ürünün kaç GB RAM'e sahip olduğunu giriniz: ");
        int RAM = inp.nextInt();
        System.out.println("Ürünün depolama kapasitesinin kaç GB olduğunu giriniz: ");
        int diskSpace = inp.nextInt();
        System.out.println("Ürünün ekran boyutunun kaç inç olduğunu giriniz: ");
        double screenSize = inp.nextDouble();
        Notebook newNotebook = new Notebook(id, price, discount, stock, name,
                brandName, RAM, diskSpace, screenSize);
        addToList(newNotebook);
        Brand.notebookIDList.add(id);
        System.out.println("Ürün eklendi !");
    }

    public void addToList(Phone product) {
        brandSet.get(product.getBrandName()).getPhoneList().add(product);
    }

    public void addToList(Notebook product) {
        brandSet.get(product.getBrandName()).getNotebookList().add(product);
    }

}
