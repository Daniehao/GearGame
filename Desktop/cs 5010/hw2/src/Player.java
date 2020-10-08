import java.util.ArrayList;
import java.util.List;

/**
 * The class which contains operations to retrieve the current player's attack points, defend
 * points, count of the hand gear, count of the head gear, count of the foot gear,
 * and operations to check whether we should add a single equipment or whether we should combine
 * with a equipment that a player already has.
 */
public class Player implements Character {
  private int attackPts;
  private int defendPts;
  private List<Equipment> headList;
  private List<Equipment> handList;
  private List<Equipment> footList;
  private List<Boolean> combinedList;
  private List<Equipment> equipments;
  private boolean done;

  /**
   * Constructor for Player class.
   * @param index The index of the current player.
   */
  public Player(int index) {
    attackPts = 0;
    defendPts = 0;
    headList = new ArrayList<>();
    handList = new ArrayList<>();
    footList = new ArrayList<>();
    equipments = new ArrayList<>();
    combinedList = new ArrayList<>();
    combinedList.add(false);
    combinedList.add(false);
    combinedList.add(false);
    done = false;
  }

  /**
   * Add attack points to the player.
   * @param attack The attack point that need to be added.
   */
  @Override
  public void addAttack(int attack) {
    attackPts += attack;
  }

  /**
   * Add defend points to the player.
   * @param defend The defend point that need to be added.
   */
  @Override
  public void addDefend(int defend) {
    defendPts += defend;
  }

  /**
   * Get the total attack points.
   * @return The total attack points of current player.
   */
  @Override
  public int getTotalAttackPts() {
    return attackPts;
  }

  /**
   * Get the total defend points.
   * @return The total defend points of current player.
   */
  @Override
  public int getTotalDefendPts() {
    return defendPts;
  }

  /**
   * Get the total number of head gears.
   * @return The total number of head gears for the current player.
   */
  @Override
  public int getHeadCount() {
    return headList.size();
  }

  /**
   * Get the total number of foot gears.
   * @return The total number of foot gears for the current player.
   */
  @Override
  public int getFootCount() {
    return footList.size();
  }

  /**
   * Get the total number of hand gears.
   * @return The total number of hand gears for the current player.
   */
  @Override
  public int getHandCount() {
    return handList.size();
  }

  /**
   * Set true if the player cannot add more gears.
   */
  @Override
  public void setDone() {
    done = true;
  }

  /**
   * Get if the player could add more gears.
   */
  @Override
  public boolean getDone() {
    return done;
  }

  /**
   * Check if the player could combine with the input equipment.
   * @param equipment The equipment object.
   * @return True/False.
   */
  @Override
  public boolean checkCombination(Equipment equipment) {
    Type equipmentType = equipment.getGearType();
    if (equipmentType == Type.HEAD) {
      return combinedList.get(0);
    } else if (equipmentType == Type.HAND) {
      return combinedList.get(1);
    } else {
      return combinedList.get(2);
    }
  }

  /**
   * Choose which type of equipment should combine with the input equipment object.
   * @param equipment The equipment object.
   * @return The combined equipment.
   */
  @Override
  public Equipment combineEquipments(Equipment equipment) {
    Type equipmentType = equipment.getGearType();
    if (equipmentType == Type.HEAD) {
      return combineSpecificType(equipment, headList, 0);
    } else if (equipmentType == Type.HAND) {
      return combineSpecificType(equipment, handList, 1);
    }
    return combineSpecificType(equipment, footList, 2);
  }

  /**
   * Combine the input equipment with one of the same type equipment that the player currently has.
   * @param equipment The equipment object.
   * @param equipmentLst The specific type of the gear list that the player currently has.
   * @param index The index of the combinedList, order by the gear type in the Type class.
   * @return The combined equipment.
   */
  private Equipment combineSpecificType(Equipment equipment, List<Equipment> equipmentLst,
                                        int index) {
    Equipment curr;
    curr = equipmentLst.get(0);
    attackPts -= curr.getAttackPts();
    defendPts -= curr.getDefendPts();
    combinedList.set(index, false);
    String[] names = curr.getGearName().split(" ");
    Equipment combinedEquipment = new Gear(curr.getGearType(), names[0] + ", " +
            equipment.getGearName(), true, curr.getAttackPts() +
            equipment.getAttackPts(), curr.getDefendPts() + equipment.getDefendPts());
    attackPts += combinedEquipment.getAttackPts();
    defendPts += combinedEquipment.getDefendPts();
    equipments.remove(curr);
    equipments.add(combinedEquipment);
    return combinedEquipment;
  }

  /**
   * Check if the input equipment can be added individually to the gear lists.
   * @param equipment The input equipment.
   * @return True/False.
   */
  @Override
  public boolean checkSingle(Equipment equipment) {
    Type equipmentType = equipment.getGearType();
    if (equipmentType == Type.HEAD) {
      if (headList.size() > 0) {
        return false;
      }
    } else if (equipmentType == Type.HAND) {
      if (handList.size() > 0) {
        return false;
      }
    } else {
      if (footList.size() > 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Add the input equipment individually to the gear lists.
   * @param equipment The input equipment.
   * @return True/False.
   */
  @Override
  public void addSingle(Equipment equipment) {
    Type equipmentType = equipment.getGearType();
    if (equipmentType == Type.HEAD) {
      if (headList.size() == 0) {
        headList.add(equipment);
        combinedList.set(0, true);
        equipments.add(equipment);
      }
    } else if (equipmentType == Type.HAND) {
      if (handList.size() == 0) {
        handList.add(equipment);
        combinedList.set(1, true);
        equipments.add(equipment);
      }
    } else {
      if (footList.size() == 0) {
        footList.add(equipment);
        combinedList.set(2, true);
        equipments.add(equipment);
      }
    }
  }

  /**
   * Return the list of equipments for the current player.
   * @return List of equipments.
   */
  @Override
  public List<Equipment> getEquipments() {
    return equipments;
  }
}
