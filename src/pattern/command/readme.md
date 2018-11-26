# The Command Pattern
_The command pattern is applicable when we need to issue requests to objects without knowing anything about the operation being requested or the receiver of the request._

This will become a little more clear if we look at an example. First, let's make a command interface

```java
public interface Command{
    void execute();
}
```
This interface only has one method, and it is void with no parameters. For those of you familiar with the functional interfaces provided by java, this is essentially the same as Runnable (you could use Runnables in lieu of commands). 

When interacting with a command, we really don't directly see what it does, or what is happening underneath the hood. All we know is that we can call execute on it, and (hopefully) it will do whatever it is supposed to do.

Now, we need to define the behavior of a class that can receive and execute these Commands. This is ofter referred to as a **receiver**.

```java
public interface Receiver{
    void acceptCommand(Command c);
    
    void executeCommands();
}
```

#### Stock Example

For this example, let's look at the scenario of buying and selling stocks through a stock broker.
 
 First, we define a stock below
 ```java
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
```

Now, let's define some commands that act on a stock.
```java
public class BuyStock implements Command {
    private Stock myStock;

    public BuyStock(Stock myStock) {
        this.myStock = myStock;
    }

    @Override
    public void execute() {
        myStock.buy();
    }
}


public class SellStock implements Command {

    private Stock myStock;

    public SellStock(Stock myStock) {
        this.myStock = myStock;
    }

    @Override
    public void execute() {
        myStock.sell();
    }
}
```
 
 Now that we have defined some commands,Our broker is going to be our receiver, so we define the broker below.

```java
public class StockBroker implements Receiver{
    List<Command> commands=new ArrayList<Command>();
    
    void acceptCommand(Command c){
        commands.add(c);
    }
    
    void executeCommands(){
        for(Command c: commands){
            c.execute();
        }    
    }
}
```

In the main class, you can see some examples of this pattern in use.


#### That's great in theory... but where can I actually use this?
This is a great question, and something I know I struggled with a bit when I took this class as well - sure, I understand the examples, but all the examples do are print things out, which is trivial.

This website does a really good job explaining how its applicable to a problem you probably encountered in Assignment 7 while implementing your controller: https://alvinalexander.com/java/java-command-design-pattern-in-java-examples

## Additional Resources
1. https://sourcemaking.com/design_patterns/command
2. https://www.tutorialspoint.com/design_pattern/command_pattern.htm
3. https://www.geeksforgeeks.org/command-pattern/
4. https://www.oodesign.com/command-pattern.html
5. https://dzone.com/articles/design-patterns-command