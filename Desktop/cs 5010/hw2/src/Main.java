/**
 * A demo to go over the Role Playing game and print out each character's equipment, attack strenth,
 * defend strenth, and the last winner for the game.
 */
public class Main {
  /**
   * Main method for Main class and it prints the result for the two demos.
   *
   * @param args The input args for main
   */
  public static void main(String[] args) {
    //demo 1
    Character player1 = new Player(1);
    Character player2 = new Player(2);
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
    Battle battle1 = new Battle(eq1, eq2, eq3, eq4, eq5, eq6, eq7, eq8, eq9, eq10);
    while (battle1.getEquipments().size() != 0 && (!player1.getDone() || !player2.getDone())) {
      battle1.chooseEquipments(player1, player2);
    }
    System.out.println(battle1.getPlayer1TotalEquipments(player1));
    System.out.println(battle1.getPlayer2TotalEquipments(player2));
    System.out.println(battle1.player1AttackPts(player1));
    System.out.println(battle1.player2AttackPts(player2));
    System.out.println(battle1.player1DefendPts(player1));
    System.out.println(battle1.player2DefendPts(player2));
    System.out.println(battle1.getWinner(player1, player2));

    //demo 2
    Character player01 = new Player(1);
    Character player02 = new Player(2);
    Equipment eq01 = new Gear(Type.HEAD, "Pretty Halmet", false, 2,
            0);
    Equipment eq02 = new Gear(Type.HEAD, "Cute Visor", false, 1, 3);
    Equipment eq03 = new Gear(Type.HEAD, "Cool Hat", false, 0, 1);
    Equipment eq04 = new Gear(Type.HAND, "Cute Gloves", false, 2,
            3);
    Equipment eq05 = new Gear(Type.HAND, "Happy Swords", false, 1,
            0);
    Equipment eq06 = new Gear(Type.HAND, "Cool Shield", false, 1,
            5);
    Equipment eq07 = new Gear(Type.FOOT, "Cute Boots", false, 5, 1);
    Equipment eq08 = new Gear(Type.FOOT, "Happy Sneakers", false, 0,
            40);
    Equipment eq09 = new Gear(Type.FOOT, "Cool hoverboard", false, 2,
            0);
    Equipment eq010 = new Gear(Type.FOOT, "Nice hoverboard", false, 2,
            3);
    Battle battle2 = new Battle(eq01, eq02, eq03, eq04, eq05, eq06, eq07, eq08, eq09, eq010);
    while (battle2.getEquipments().size() > 0 && (!player01.getDone() || !player02.getDone())) {
      battle2.chooseEquipments(player01, player02);
    }
    System.out.println(battle2.getPlayer1TotalEquipments(player01));
    System.out.println(battle2.getPlayer2TotalEquipments(player02));
    System.out.println(battle2.player1AttackPts(player01));
    System.out.println(battle2.player2AttackPts(player02));
    System.out.println(battle2.player1DefendPts(player01));
    System.out.println(battle2.player2DefendPts(player02));
    System.out.println(battle2.getWinner(player01, player02));
  }
}
