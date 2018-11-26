package pattern.strategy;

public class InteractionContext {

    private InteractionStrategy strat;

    public void setUniversityStrategy(InteractionStrategy strat){
        this.strat=strat;
    }

    public void interact(String otherUniversity){
        strat.interact(otherUniversity);
    }
}
