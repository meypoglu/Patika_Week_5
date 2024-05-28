package PatikaStore;

public class Main {
    public static void main(String[] args) {
    PatikaStore store = new PatikaStore();
    store.addBrandDefault("Samsung", 1);
    store.addBrandDefault("Lenovo", 2);
    store.addBrandDefault("Apple", 3);
    store.addBrandDefault("Huawei", 4);
    store.addBrandDefault("Casper", 5);
    store.addBrandDefault("Asus", 6);
    store.addBrandDefault("HP", 7);
    store.addBrandDefault("Xiaomi", 8);
    store.addBrandDefault("Monster", 9);
    store.run();
    }
}
