/**
 * The gear class which contains getters to retrieve the information of the gear object, including
 * the type of gear, the name of gear, whether the gear has been combined already, the attack and
 * the defend strength for the gear.
 */
public class Gear implements Equipment {
  private final Type type;
  private final String name;
  private boolean isCombined;
  private final int attack;
  private final int defend;

  /**
   * Constructor for the gear object.
   * @param type Type of gear.
   * @param name  Name of gear.
   * @param isCombined  Whether it is combined.
   * @param attack  The attack strength;
   * @param defend The defend strength;
   */
  public Gear(Type type, String name, boolean isCombined, int attack, int defend) {
    this.type = type;
    this.name = name;
    this.isCombined = isCombined;
    this.attack = attack;
    this.defend = defend;
  }

  /**
   * Get the name of the gear.
   * @return Name of gear.
   */
  @Override
  public String getGearName() {
    return name;
  }

  /**
   * Get the type of the gear.
   * @return Type of gear.
   */
  @Override
  public Type getGearType() {
    return type;
  }

  /**
   * Get the defend points of the gear.
   * @return The defend points of the gear.
   */
  @Override
  public int getDefendPts() {
    return defend;
  }

  /**
   * Get the attack points of the gear.
   * @return The attack points of the gear.
   */
  @Override
  public int getAttackPts() {
    return attack;
  }

  /**
   * Get if the gear is combined already or not.
   * @return True/False.
   */
  @Override
  public boolean getIsCombined() {
    return isCombined;
  }

  /**
   * Compare the equipment with the input equipment order by attack strength and follows by defend
   * strength.
   * @param other The input equipment.
   * @return The comparator result.
   */
  @Override
  public int compareTo(Equipment other) {
    if (this.attack != other.getAttackPts()) {
      return other.getAttackPts() - this.attack;
    } else {
      return other.getDefendPts() - this.defend;
    }
  }

  /**
   *
   * @return
   */
  @Override
  public String toString() {
    return String.format("The current equipment type is %s, name is %s, attack strength " +
                    "is %s, defend strength is %s.",
            getGearType(), getGearName(), getAttackPts(), getDefendPts());
  }
}
