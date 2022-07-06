package semo;

public class Pin extends Product{
    private char size;
    private double price;

    public Pin(int pid, String name, String image, char size, double price) {
        super(pid, name, image);
        this.size = size;
        this.price = price;
    }

    public Pin() {
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
