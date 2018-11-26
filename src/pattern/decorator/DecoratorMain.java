package pattern.decorator;

public class DecoratorMain {

    public static void main(String[] args) {

        // Here is our base class - let's see what it can do.
        Robot baseRobot = new RobotImpl(10,10);

        System.out.println(baseRobot.attack());
        System.out.println(baseRobot.defend());
        System.out.println("Base Robot Attack Power: " + baseRobot.getAttackPower());
        System.out.println("Base Robot Defense Power: " + baseRobot.getDefensePower());

        System.out.println("-----");
        // Now let's give our robot a sword and see what it can do.
        // Here we are decorating the robot by giving
        Robot swordRobot = new SwordRobotImpl(baseRobot);
        System.out.println(swordRobot.attack());
        System.out.println(swordRobot.defend());
        System.out.println("Sword Robot Attack Power: " + swordRobot.getAttackPower());
        System.out.println("Sword Robot Defense Power: " + swordRobot.getDefensePower());

        System.out.println("-----");
        // Now let's give our robot a shield and see what it can do.
        Robot swordShieldRobot = new ShieldRobotImpl(swordRobot);
        System.out.println(swordShieldRobot.attack());
        System.out.println(swordShieldRobot.defend());
        System.out.println("Sword + Shield Robot Attack Power: " + swordShieldRobot.getAttackPower());
        System.out.println("Sword + Shield Robot Defense Power: " + swordShieldRobot.getDefensePower());

        System.out.println("-----");
        // Just to double check - let's look at the base robot one more time.
        System.out.println(baseRobot.attack());
        System.out.println(baseRobot.defend());
        System.out.println("Base Robot Attack Power: " + baseRobot.getAttackPower());
        System.out.println("Base Robot Defense Power: " + baseRobot.getDefensePower());

        System.out.println("-----");
        // But we should be careful - does this do what we would expect?
        Robot wildRobot = new SwordRobotImpl(swordShieldRobot);
        System.out.println(wildRobot.attack());
        System.out.println(wildRobot.defend());
        System.out.println("Wild Robot Attack Power: " + wildRobot.getAttackPower());
        System.out.println("Wild Robot Defense Power: " + wildRobot.getDefensePower());

        // It's also good to know the limitations of design patterns! Consider why this is occurring
        // and if there's anything that can be done to fix it! (Hint: what else would you have access
        // to on your base robot that could identify if a weapon has already been equipped?)
    }
}
