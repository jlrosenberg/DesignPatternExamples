package pattern.strategy.collegestrategyexample;

public class NortheasternStrategy implements InteractionStrategy {

    @Override
    public void interact(String other) {
        if(other.equalsIgnoreCase("Boston University")){
            System.out.println("Sucks to B U");
        }else{
            System.out.println("We love experiential learning!!!");
        }

    }
}
