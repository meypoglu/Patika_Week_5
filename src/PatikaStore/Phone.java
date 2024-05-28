package PatikaStore;

public class Phone extends Brand {
    private double batterPower;
    private String color;

    public Phone(double batteryPower, String color,int id, double price,
                 double discount, int stock, String name, String brandName,
                 int RAM, int diskSpace, double screenSize) {
        this.batterPower = batterPower;
        this.color = color;
        super.setId(id);
        super.setPrice(price);
        super.setDiscount(discount);
        super.setStock(stock);
        super.setName(name);
        super.setBrandName(brandName);
        super.setRAM(RAM);
        super.setDiskSpace(diskSpace);
        super.setScreenSize(screenSize);
    }

    public double getBatterPower() {
        return batterPower;
    }

    public void setBatterPower(double batterPower) {
        this.batterPower = batterPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
