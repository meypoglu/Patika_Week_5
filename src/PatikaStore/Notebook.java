package PatikaStore;

public class Notebook extends Brand{
    Notebook(int id, double price, double discount, int stock, String name,
             String brandName, int RAM, int diskSpace, double screenSize) {
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
}
