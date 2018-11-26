package pattern.decorator;

/**
 *
 */
public class ShieldRobotImpl implements Robot {
    private Robot baseRobot;

    /**
     *
     * @param baseRobot
     */
    public ShieldRobotImpl(Robot baseRobot) {
        this.baseRobot = baseRobot;
    }

    @Override
    public String attack() {
        return baseRobot.attack();
    }

    @Override
    public String defend() {
        return "The Robot raises a mechanical shield and defends itself!";
    }

    @Override
    public int getAttackPower() {
        return baseRobot.getAttackPower();
    }

    @Override
    public int getDefensePower() {
        return baseRobot.getDefensePower() + 20;
    }
}
