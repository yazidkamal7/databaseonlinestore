package semo;

public class NoteBook extends Product{
    private int numOfPaper;
    private double price;

    public NoteBook() {
    }

    public NoteBook(int pid, String name, String image, int numOfPaper, double price) {
        super(pid, name, image);
        this.numOfPaper = numOfPaper;
        this.price = price;
    }

    public int getNumOfPaper() {
        return numOfPaper;
    }

    public void setNumOfPaper(int numOfPaper) {
        this.numOfPaper = numOfPaper;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
