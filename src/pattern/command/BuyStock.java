package pattern.command;

public class BuyStock implements Order {
    private Stock myStock;

    public BuyStock(Stock myStock) {
        this.myStock = myStock;
    }

    @Override
    public void execute() {
        myStock.buy();
    }
}
