
import org.junit.Before;
import org.junit.Test;

import dungeon.Level;

import static org.junit.Assert.assertEquals;

public class MedievalLevelBuilderTest {

  private Level medievalLevel3;
  @Before
  public void setUp() {
    Level medievalLevel3 = Level.getBuilder(3,5,10,100).addRoom("room1").build();
  }

  @Test
  public void addRoomTest() {
    System.out.println(medievalLevel3.getLevelNumber());
  }

//  @Test
//  void addGoblinTest() {
//  }
//
//  @Test
//  void addOrcTest() {
//  }
//
//  @Test
//  void addOrgeTest() {
//  }
//
//  @Test
//  void addHumanTest() {
//  }
//
//  @Test
//  void addPotionTest() {
//  }
//
//  @Test
//  void addGoldTest() {
//  }
//
//  @Test
//  void addWeaponTest() {
//  }
//
//  @Test
//  void addSpecialTest() {
//  }
//
//  @Test
//  void buildTest() {
//  }
}