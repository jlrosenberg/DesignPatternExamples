package pattern.command;

public interface Receiver {

    void acceptOrder(Order o);

    void placeOrders();
}
