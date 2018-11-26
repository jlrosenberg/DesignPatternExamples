package pattern.strategy.collegestrategyexample;

public class Main {

    public static void main(String[] args){
        InteractionContext student=new InteractionContext();
        student.setUniversityStrategy(new NortheasternStrategy());


        student.interact("Boston University");
        student.interact("Harvard");

        student.setUniversityStrategy(new BUStrategy());
        student.interact("Cornell");
        student.interact("Northeastern");

        InteractionContext student2=new InteractionContext();
        student2.setUniversityStrategy(new NorthwesternStrategy());
        student2.interact("Columbia University");
        student2.interact("Northeastern University");


    }
}
