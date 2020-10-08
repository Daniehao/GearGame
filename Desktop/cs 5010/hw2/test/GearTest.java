import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GearTest {
  private Equipment gear1;
  private Equipment gear2;
  private Equipment gear3;

  @Before
  public void setup() {
    gear1 = new Gear(Type.HAND, "Happy Gloves", false, 2, 3);
    gear2 = new Gear(Type.HEAD, "Pretty halmet", false, 5, 2);
    gear3 = new Gear(Type.HEAD, "Cute Visor", false, 5, 1);
  }

  @Test
  public void getGearNameTest() {
    assertEquals("Happy Gloves", gear1.getGearName());
  }

  @Test
  public void getGearTypeTest() {
    assertEquals(Type.HAND, gear1.getGearType());
  }

  @Test
  public void getDefendPtsTest() {
    assertEquals(3, gear1.getDefendPts());
  }

  @Test
  public void getAttackPtsTest() {
    assertEquals(2, gear1.getAttackPts());
  }

  @Test
  public void getCombinedTest() {
    assertEquals(false, gear1.getIsCombined());
  }

  @Test
  public void compareToTest() {
    List<Equipment> equipments = new ArrayList<>();
    equipments.add(gear1);
    equipments.add(gear2);
    equipments.add(gear3);
    Collections.sort(equipments);
    System.out.println(equipments.get(0).toString());
    System.out.println(equipments.get(1).toString());
    System.out.println(equipments.get(2).toString());
    assertEquals("The current equipment type is HEAD, name is Pretty halmet, " +
            "attack strength is 5, defend strength is 2.", equipments.get(0).toString());
    assertEquals("The current equipment type is HEAD, name is Cute Visor, " +
            "attack strength is 5, defend strength is 1.", equipments.get(1).toString());
    assertEquals("The current equipment type is HAND, name is Happy Gloves, " +
            "attack strength is 2, defend strength is 3.", equipments.get(2).toString());
  }
}
