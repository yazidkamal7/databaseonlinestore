package semo;

public class Product {

    private int pid;
    private String name;
    private String image;

    public Product() {

    }

    public Product(int pid, String name, String image) {
        this.pid = pid;
        this.name = name;
        this.image = image;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
