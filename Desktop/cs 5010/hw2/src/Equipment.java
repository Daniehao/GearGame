/**
 * The interface for gear class includes getter methods related to Gear operations.
 */
public interface Equipment extends Comparable<Equipment> {
  public String getGearName();

  public Type getGearType();

  public int getDefendPts();

  public int getAttackPts();

  public boolean getIsCombined();
}
