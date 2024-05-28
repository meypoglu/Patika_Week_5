package PatikaStore;

import java.util.ArrayList;

public class Brand extends PatikaStore {
    private String name, brandName;
    private int id, productID, stock, RAM, diskSpace;
    private double discount, screenSize, price;

    public static ArrayList<Integer> notebookIDList = new ArrayList<Integer>();
    public static ArrayList<Integer> phoneIDList = new ArrayList<Integer>();
    private ArrayList<Phone> phoneList = new ArrayList<Phone>();
    private ArrayList<Notebook> notebookList = new ArrayList<Notebook>();
    public Brand() {

    }

    public Brand(String brandName, int id) {
        this.brandName = brandName;
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getDiskSpace() {
        return diskSpace;
    }

    public void setDiskSpace(int diskSpace) {
        this.diskSpace = diskSpace;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public ArrayList<Phone> getPhoneList() {
        return this.phoneList;
    }

    public ArrayList<Notebook> getNotebookList() {
        return this.notebookList;
    }

}
