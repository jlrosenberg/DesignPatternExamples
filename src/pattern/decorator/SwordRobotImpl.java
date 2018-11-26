package pattern.decorator;

/**
 *
 */
public class SwordRobotImpl implements Robot {
    private Robot baseRobot;

    /**
     *
     * @param baseRobot
     */
    public SwordRobotImpl(Robot baseRobot) {
        this.baseRobot = baseRobot;
    }

    @Override
    public String attack() {
        return "The Robot swings a mechanical sword in your direction!";
    }

    @Override
    public String defend() {
        return baseRobot.defend();
    }

    @Override
    public int getAttackPower() {
        return baseRobot.getAttackPower() + 20;
    }

    @Override
    public int getDefensePower() {
        return baseRobot.getDefensePower();
    }
}
