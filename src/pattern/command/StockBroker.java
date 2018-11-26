package pattern.command;

import java.util.ArrayList;
import java.util.List;

public class StockBroker {

    private List<Order> orders = new ArrayList<Order>();

    public void acceptOrder(Order o){
        orders.add(o);
    }


    public void placeOrders(){
        for(Order o: orders){
            o.execute();
        }
    }



}
