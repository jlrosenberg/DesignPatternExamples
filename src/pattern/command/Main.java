package pattern.command;

public class Main {

    public static void main(String[] args){
        Stock myStock = new Stock("Calvin Klein", 10);

        BuyStock buyOrder = new BuyStock(myStock);
        SellStock sellOrder = new SellStock(myStock);

        StockBroker aoun = new StockBroker();

        aoun.acceptOrder(buyOrder);
        aoun.acceptOrder(sellOrder);

        aoun.placeOrders();

    }
}
