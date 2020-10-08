import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the Player class to check whether all of the functions in Player class works fine.
 */
public class PlayerTest {
  private Character player1;
  private Equipment gear1;
  private Equipment gear2;
  private Equipment gear3;
  private Equipment gear4;

  @Before
  public void setup() {
    player1 = new Player(1);
    gear1 = new Gear(Type.HAND, "Happy Gloves", false, 2, 3);
    gear2 = new Gear(Type.HEAD, "Pretty halmet", false, 5, 2);
    gear3 = new Gear(Type.HEAD, "Cute Visor", false, 5, 1);
    gear4 = new Gear(Type.HEAD, "Cute halmet", false, 1, 0);
  }

  @Test
  public void checkAddGetAttack() {
    player1.addAttack(3);
    player1.addAttack(4);
    assertEquals(7, player1.getTotalAttackPts());
  }

  @Test
  public void checkAddGetDefend() {
    player1.addDefend(3);
    player1.addDefend(4);
    assertEquals(7, player1.getTotalDefendPts());
  }

  @Test
  public void addSingleTest() {
    player1.addSingle(gear1);
    player1.addSingle(gear2);
    assertEquals(1, player1.getHeadCount());
    assertEquals(1, player1.getHandCount());
    assertEquals(0, player1.getFootCount());
  }

  @Test
  public void checkCombinationTest() {
    player1.addSingle(gear1);
    player1.addSingle(gear2);
    assertEquals(true, player1.checkCombination(gear3));
    assertEquals(true, player1.checkCombination(gear4));
  }

  @Test
  public void combineEquipmentsTest() {
    player1.addSingle(gear1);
    player1.addSingle(gear2);
    assertEquals("The current equipment type is HEAD, name is Pretty, Cute Visor, " +
                    "attack strength is 10, defend strength is 3.",
            player1.combineEquipments(gear3).toString());
    assertEquals(false, player1.checkCombination(gear4));
  }

}
