package PatikaStore;

public class Notebook extends Product {

    public Notebook(int id, int stock, int diskCapacity, int RAM, double price,
                    double discount, double screenSize, String name, String brand) {
        super(id, stock, diskCapacity, RAM, price, discount, screenSize, name,
                brand);
    }
}
