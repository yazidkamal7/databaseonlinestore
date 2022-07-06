package semo;

public class PhoneCase extends Product{
    private String phonemodel;
    private double price;

    public PhoneCase(int pid, String name, String image, String phonemodel, double price) {
        super(pid, name, image);
        this.phonemodel = phonemodel;
        this.price = price;
    }

    public PhoneCase() {
    }

    public String getPhonemodel() {
        return phonemodel;
    }

    public void setPhonemodel(String phonemodel) {
        this.phonemodel = phonemodel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
