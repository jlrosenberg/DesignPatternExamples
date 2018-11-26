package pattern.strategy.collegestrategyexample;

public class NorthwesternStrategy implements InteractionStrategy {
    @Override
    public void interact(String other) {
        if(other.equalsIgnoreCase("Northeastern University")){
            System.out.println("NU stands for northeastern not northwestern");
        }else{
            System.out.println("Northeastern is way cooler than us");
        }
    }
}
