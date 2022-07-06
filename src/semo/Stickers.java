package semo;

public class Stickers extends Product{
    private char size;
    private double price;
    private String image;

    public Stickers(int pid, String name, String image, char size, double price) {
        super(pid, name, image);
        this.size = size;
        this.price = price;
    }

    public Stickers() {
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

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }
}
