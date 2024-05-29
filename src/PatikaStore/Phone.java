package PatikaStore;

public class Phone extends Product {
    String color;
    int batteryPower;

    public Phone(int id, int stock, int diskCapacity, int RAM, double price,
                 double discount, double screenSize, String name, String brand,
                 String color, int batteryPower) {
        super(id, stock, diskCapacity, RAM, price, discount, screenSize, name,
                brand);
        this.color = color;
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }
}
