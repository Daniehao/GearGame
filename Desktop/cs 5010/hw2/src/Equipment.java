public interface Equipment extends Comparable<Equipment> {
  public String getGearName();

  public Type getGearType();

  public int getDefendPts();

  public int getAttackPts();

  public boolean getIsCombined();
}
