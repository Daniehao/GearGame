import java.util.List;

public interface Character {
  public void addAttack(int attack);

  public void addDefend(int defend);

  public int getTotalAttackPts();

  public int getTotalDefendPts();

  public int getHeadCount();

  public int getFootCount();

  public int getHandCount();

  public void setDone();

  public boolean getDone();

  public boolean checkCombination(Equipment equipment);

  public Equipment combineEquipments(Equipment equipment);

  public boolean checkSingle(Equipment equipment);

  public void addSingle(Equipment equipment);

  public List<Equipment> getEquipments();
}
