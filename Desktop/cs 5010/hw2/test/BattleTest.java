import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the battle class to check whether the game has correct winner, and whether each player
 * has the correct equipments, correct attack and defend strenth.
 */
public class BattleTest {
  private Battle battle1;
  private Player player1;
  private Player player2;

  @Before
  public void setup() {
    player1 = new Player(1);
    player2 = new Player(2);
    Equipment eq1 = new Gear(Type.HEAD, "Pretty Halmet", false, 2,
            3);
    Equipment eq2 = new Gear(Type.HEAD, "Cute Visor", false, 5, 3);
    Equipment eq3 = new Gear(Type.HEAD, "Cool Hat", false, 1, 1);
    Equipment eq4 = new Gear(Type.HAND, "Cute Gloves", false, 2, 3);
    Equipment eq5 = new Gear(Type.HAND, "Happy Swords", false, 1,
            0);
    Equipment eq6 = new Gear(Type.HAND, "Cool Shield", false, 2, 2);
    Equipment eq7 = new Gear(Type.FOOT, "Cute Boots", false, 0, 5);
    Equipment eq8 = new Gear(Type.FOOT, "Happy Sneakers", false, 1,
            4);
    Equipment eq9 = new Gear(Type.FOOT, "Cool hoverboard", false, 2,
            0);
    Equipment eq10 = new Gear(Type.FOOT, "Nice hoverboard", false, 3,
            3);
    battle1 = new Battle(eq1, eq2, eq3, eq4, eq5, eq6, eq7, eq8, eq9, eq10);
  }

  @Test
  public void chooseEquipmentsTest() {
    battle1.chooseEquipments(player1, player2);
    assertEquals("The current equipment type is HEAD, name is Cute Visor, attack " +
            "strength is 5, defend strength is 3.", battle1.getPlayer1TotalEquipments(player1));
    assertEquals("", battle1.getPlayer2TotalEquipments(player2));
  }

  @Test
  public void getPlayersEquipments() {
    while (battle1.getEquipments().size() != 0 && (!player1.getDone() || !player2.getDone())) {
      battle1.chooseEquipments(player1, player2);
    }
    assertEquals("The current equipment type is HEAD, name is Cute, Pretty Halmet, " +
                    "attack strength is 7, defend strength is 6.",
            player1.getEquipments().get(0).toString());
    assertEquals("The current equipment type is HAND, name is Cute, Happy Swords, " +
                    "attack strength is 3, defend strength is 3.",
            player1.getEquipments().get(1).toString());
    assertEquals("The current equipment type is FOOT, name is Happy, Cute Boots, " +
            "attack strength is 1, defend strength is 9.", player1.getEquipments().
            get(2).toString());
    assertEquals("The current equipment type is FOOT, name is Nice, Cool hoverboard, " +
                    "attack strength is 5, defend strength is 3.",
            player2.getEquipments().get(0).toString());
    assertEquals("The current equipment type is HAND, name is Cool Shield, attack " +
            "strength is 2, defend strength is 2.", player2.getEquipments().get(1).toString());
    assertEquals("The current equipment type is HEAD, name is Cool Hat, attack strength "
            +
            "is 1, defend strength is 1.", player2.getEquipments().get(2).toString());
  }

  @Test
  public void getPlayersAttackStrenth() {
    while (battle1.getEquipments().size() != 0 && (!player1.getDone() || !player2.getDone())) {
      battle1.chooseEquipments(player1, player2);
    }
    assertEquals("Player 1 has 11 points of attack strenth.",
            battle1.player1AttackPts(player1));
    assertEquals("Player 2 has 8 points of attack strenth.",
            battle1.player2AttackPts(player2));
  }

  @Test
  public void getPlayersDefendStrenth() {
    while (battle1.getEquipments().size() != 0 && (!player1.getDone() || !player2.getDone())) {
      battle1.chooseEquipments(player1, player2);
    }
    assertEquals("Player 1 has 18 points of defend strenth.",
            battle1.player1DefendPts(player1));
    assertEquals("Player 2 has 6 points of defend strenth.",
            battle1.player2DefendPts(player2));
  }

  @Test
  public void getEquipments() {
    assertEquals("The current equipment type is HEAD, name is Cute Visor, attack " +
            "strength is 5, defend strength is 3.", battle1.getEquipments().get(0).toString());
    assertEquals("The current equipment type is FOOT, name is Nice hoverboard, attack " +
            "strength is 3, defend strength is 3.", battle1.getEquipments().get(1).toString());
    assertEquals("The current equipment type is HEAD, name is Pretty Halmet, attack " +
            "strength is 2, defend strength is 3.", battle1.getEquipments().get(2).toString());
  }
}
