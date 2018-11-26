package pattern.decorator;

/**
 * Represents a human-like robot with the ability to attack and defend itself.
 */
public class RobotImpl implements Robot {
    private int attackPower;
    private int defensePower;

    /**
     * Creates a robot with a given attack and defense power.
     * @param attackPower  - the attack power of the robot.
     * @param defensePower - the defense power of the robot.
     */
    public RobotImpl(int attackPower, int defensePower) {
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    @Override
    public String attack() {
        return "The Robot makes a quick attack punch in your direction!";
    }

    @Override
    public String defend() {
        return "The Robot puts its arms up and defends itself!";
    }

    @Override
    public int getAttackPower() {
        return this.attackPower;
    }

    @Override
    public int getDefensePower() {
        return this.defensePower;
    }
}
