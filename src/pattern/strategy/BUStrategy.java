package pattern.strategy;

public class BUStrategy implements InteractionStrategy {
    @Override
    public void interact(String other) {
        System.out.println("BU sucks but we don't want to admit that northeastern is better even though it is");
    }
}
