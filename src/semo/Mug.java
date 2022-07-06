package semo;

public class Mug  extends Product{
    private boolean Mugic;
    private double price;

    public Mug(int pid, String name, String image, boolean Mugic, double price) {
        super(pid, name, image);
        this.Mugic = Mugic;
        this.price = price;
    }

    public Mug() {

    }

    public boolean isMugic() {
        return Mugic;
    }

    public void setMugic(boolean mugic) {
        this.Mugic = mugic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
