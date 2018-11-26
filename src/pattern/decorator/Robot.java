package pattern.decorator;

/**
 * This represents the behavior for a text-based battle robot with the ability to attack and defend itself.
 */
public interface Robot {

    /**
     * Enables the robot with a basic robot attack move.
     * @return the textual representation of the robot attacking
     */
    String attack();

    /**
     * Enables the robot with a basic robot defense move.
     * @return the textual representation of the robot defending
     */
    String defend();

    /**
     * Describes the attack power of the robot.
     * @return the integer representation of the robot attack power.
     */
    int getAttackPower();

    /**
     * Describes the defense power of the robot.
     * @return the integer representation of the robot defense power.
     */
    int getDefensePower();
}
