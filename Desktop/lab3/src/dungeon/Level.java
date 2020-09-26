package dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a level in a dungeon consisting of a number of rooms.
 */
public class Level {

  private int levelNumber;
  private List<Room> rooms;

  public static MedievalLevelBuilder getBuilder(int levelNum, int roomNum, int monsterNum, int treasureValue) {
    return new MedievalLevelBuilder(levelNum, roomNum, monsterNum, treasureValue);
  }

  /**
   * Constructor for a level in our dungeon.
   *
   * @param levelNumber a numeric representing which level this is.
   */
  public Level(int levelNumber, List<Room> rooms) {
    this.levelNumber = levelNumber;
    this.rooms = rooms;
  }

  /**
   * Accessor for the level number.
   *
   * @return the level number
   */
  public int getLevelNumber() {
    return levelNumber;
  }

  /**
   * Add a room to this level.
   *
   * @param description the description of the room to add
   */
  public void addRoom(String description) {
    rooms.add(new Room(description));
  }

  /**
   * Adds a monster to a room.
   *
   * @param roomNumber the room number to add the monster to
   * @param m          the monster to add
   */
  public void addMonster(int roomNumber, Monster m) {
    rooms.get(roomNumber).addMonster(m);
  }

  /**
   * Adds a treasure to a room.
   *
   * @param roomNumber the room number to add the treasure to
   * @param t          the treasure to add
   */
  public void addTreasure(int roomNumber, Treasure t) {
    rooms.get(roomNumber).addTreasure(t);
  }

  @Override
  public String toString() {
    String start = String.format("Level %d contains %d rooms:\n", levelNumber, rooms.size());
    StringBuilder sb = new StringBuilder(start);
    for (int i = 0; i < rooms.size(); i++) {
      sb.append("\nRoom " + i + " -- " + rooms.get(i).toString());
    }
    return sb.toString();
  }

  public static class MedievalLevelBuilder {
    private int levelNumber;
    private int roomNum;
    private int monsterNum;
    private int treasureValue;
    private List<Room> rooms;
    private int totalMonsters;
    private int totalTreasureValue;

    public MedievalLevelBuilder(int levelNum, int roomNum, int monsterNum, int treasureValue) {
      this.levelNumber = levelNum;
      this.roomNum = roomNum;
      this.monsterNum = monsterNum;
      this.treasureValue = treasureValue;
      this.rooms = new ArrayList<>();
      totalMonsters = 0;
      totalTreasureValue = 0;
    }

    /**
     * Add a new room to the current level.
     *
     * @param roomDescription The description of the room.
     * @return The MedievalLevelBuilder object.
     */
    public MedievalLevelBuilder addRoom(String roomDescription) {
      if (rooms.size() < roomNum) {
        rooms.add(new Room(roomDescription));
      } else {
        throw new IllegalStateException("Fail to add more rooms to the current level.");
      }
      return this;
    }

    /**
     * Add goblins to a specific room at the current level.
     *
     * @param roomIndex The index of room to insert the goblin.
     * @param goblinNum The number of goblins need to be inserted.
     * @return The MedievalLevelBuilder obejct.
     */
    public MedievalLevelBuilder addGoblin(int roomIndex, int goblinNum) {
      if (roomIndex >= rooms.size()) {
        throw new IllegalArgumentException("Target room has not yet been created.");
      }
      //add monster
      Room currRoom = rooms.get(roomIndex);
      if (totalMonsters + goblinNum < monsterNum) {
        Monster goblin = new Monster("goblin", "A mischievous and very unpleasant, " +
                "vengeful, and greedy creature whose primary purpose is to cause trouble to humankind",
                7);
        for (int i = 0; i < goblinNum; i++) {
          currRoom.addMonster(goblin);
        }
      } else {
        throw new IllegalStateException(String.format("Cannot add %d numbers of goblins", goblinNum));
      }
      return this;
    }

    /**
     * Add orcs to a specific room at the current level.
     *
     * @param roomIndex The index of room to insert the orcs.
     * @param orcNum    The number of orcs need to be inserted.
     * @return The MedievalLevelBuilder obejct.
     */
    public MedievalLevelBuilder addOrc(int roomIndex, int orcNum) {
      if (roomIndex >= rooms.size()) {
        throw new IllegalArgumentException("Target room has not yet been created.");
      }
      //add monster
      Room currRoom = rooms.get(roomIndex);
      if (totalMonsters + orcNum < monsterNum) {
        Monster orc = new Monster("orc", "brutish, aggressive, malevolent being" +
                " serving evil", 20);
        for (int i = 0; i < orcNum; i++) {
          currRoom.addMonster(orc);
        }
      } else {
        throw new IllegalStateException(String.format("Cannot add %d numbers of orcs", orcNum));
      }
      return this;
    }

    /**
     * Add orges to a specific room at the current level.
     *
     * @param roomIndex The index of room to insert the orcs.
     * @param orgeNum   The number of orges need to be inserted.
     * @return The MedievalLevelBuilder obejct.
     */
    public MedievalLevelBuilder addOrge(int roomIndex, int orgeNum) {
      if (roomIndex >= rooms.size()) {
        throw new IllegalArgumentException("Target room has not yet been created.");
      }
      //add monster
      Room currRoom = rooms.get(roomIndex);
      if (totalMonsters + orgeNum < monsterNum) {
        Monster orge = new Monster("orge", "large, hideous man-like being that " +
                "likes to eat humans for lunch", 50);
        for (int i = 0; i < orgeNum; i++) {
          currRoom.addMonster(orge);
        }
      } else {
        throw new IllegalStateException(String.format("Cannot add %d numbers of orges", orgeNum));
      }
      return this;
    }

    /**
     * Add humen to a specific room at the current level.
     *
     * @param roomIndex The index of room to insert the humen.
     * @param humanNum  The number of humen need to be inserted.
     * @return The MedievalLevelBuilder obejct.
     */
    public MedievalLevelBuilder addHuman(int roomIndex, int humanNum) {
      if (roomIndex >= rooms.size()) {
        throw new IllegalArgumentException("Target room has not yet been created.");
      }
      //add monster
      Room currRoom = rooms.get(roomIndex);
      if (totalMonsters + humanNum < monsterNum) {
        Monster human = new Monster("human", "Human loves to fight with human but " +
                "not as powerful as orcs and orges.", 10);
        for (int i = 0; i < humanNum; i++) {
          currRoom.addMonster(human);
        }
      } else {
        throw new IllegalStateException(String.format("Cannot add %d numbers of humen.", humanNum));
      }
      return this;
    }

    /**
     * Add potions to a specific room at the current level.
     *
     * @param roomIndex The index of room to insert the potion.
     * @param potionNum The number of potions need to be inserted.
     * @return The MedievalLevelBuilder obejct.
     */
    public MedievalLevelBuilder addPotion(int roomIndex, int potionNum) {
      if (roomIndex >= rooms.size()) {
        throw new IllegalArgumentException("Target room has not yet been created.");
      }
      Room currRoom = rooms.get(roomIndex);
      if (totalTreasureValue + potionNum * 1 < treasureValue) {
        Treasure potion = new Treasure("a healing potion", 1);
        for (int i = 0; i < potionNum; i++) {
          currRoom.addTreasure(potion);
        }
      } else {
        throw new IllegalStateException(String.format("Cannot add %d numbers of potions.", potionNum));
      }
      return this;
    }

    /**
     * Add potions to a specific room at the current level.
     *
     * @param roomIndex The index of room to insert the gold.
     * @param goldNum   The number of golds need to be inserted.
     * @param goldValue Value for each piece of gold.
     * @return The MedievalLevelBuilder obejct.
     */
    public MedievalLevelBuilder addGold(int roomIndex, int goldNum, int goldValue) {
      if (roomIndex >= rooms.size()) {
        throw new IllegalArgumentException("Target room has not yet been created.");
      }
      Room currRoom = rooms.get(roomIndex);
      if (totalTreasureValue + goldNum * goldValue < treasureValue) {
        Treasure gold = new Treasure("pieces of gold", goldValue);
        for (int i = 0; i < goldNum; i++) {
          currRoom.addTreasure(gold);
        }
      } else {
        throw new IllegalStateException(String.format("Cannot add %d numbers of golds.", goldNum));
      }
      return this;
    }

    /**
     * Add potions to a specific room at the current level.
     *
     * @param roomIndex         The index of room to insert the weapon.
     * @param weaponNum         The number of weapons need to be inserted.
     * @param weaponDescription The description of the weapons.
     * @return The MedievalLevelBuilder obejct.
     */
    public MedievalLevelBuilder addWeapon(int roomIndex, int weaponNum, String weaponDescription) {
      if (roomIndex >= rooms.size()) {
        throw new IllegalArgumentException("Target room has not yet been created.");
      }
      Room currRoom = rooms.get(roomIndex);
      if (totalTreasureValue + weaponNum * 10 < treasureValue) {
        Treasure weapon = new Treasure(weaponDescription, 10);
        for (int i = 0; i < weaponNum; i++) {
          currRoom.addTreasure(weapon);
        }
      } else {
        throw new IllegalStateException(String.format("Cannot add %d numbers of golds.", weaponNum));
      }
      return this;
    }

    /**
     * Add potions to a specific room at the current level.
     *
     * @param roomIndex    The index of room to insert the special treasure.
     * @param specialNum   The number of special treasure need to be inserted.
     * @param specialValue The value of the special treasure.
     * @param description  The description of the special treasure.
     * @return The MedievalLevelBuilder obejct.
     */
    public MedievalLevelBuilder addSpecial(int roomIndex, int specialNum, int specialValue
            , String description) {
      if (roomIndex >= rooms.size()) {
        throw new IllegalArgumentException("Target room has not yet been created.");
      }
      Room currRoom = rooms.get(roomIndex);
      if (totalTreasureValue + specialNum * specialValue < treasureValue) {
        Treasure special = new Treasure(description, specialValue);
        for (int i = 0; i < specialNum; i++) {
          currRoom.addTreasure(special);
        }
      } else {
        throw new IllegalStateException(String.format("Cannot add %d numbers of golds.", specialNum));
      }
      return this;
    }

    /**
     * Build method to return the new level with personalized properties.
     *
     * @return Level of the game.
     */
    public Level build() {
      return new Level(levelNumber, rooms);
    }
  }
}
