package pattern.command;

public class Stock {

    private String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void buy(){
        System.out.println("Buying "+quantity+" units of "+name+" stock");
    }

    public void sell(){
        System.out.println("Selling "+quantity+" units of "+name+" stock");
    }
}
