import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Battle class basically contains operations for players to choose their gears from the ten
 * selected gears as well as the one to get the winner of the game.
 */
public class Battle {
  private Boolean isFirstPlayer;
  private List<Equipment> equipments;

  /**
   * Constructor for Battle class.
   *
   * @param eq1  The 1st selected equipment.
   * @param eq2  The 2nd selected equipment.
   * @param eq3  The 3rd selected equipment.
   * @param eq4  The 4th selected equipment.
   * @param eq5  The 5th selected equipment.
   * @param eq6  The 6th selected equipment.
   * @param eq7  The 7th selected equipment.
   * @param eq8  The 8th selected equipment.
   * @param eq9  The 9th selected equipment.
   * @param eq10 The 10th selected equipment.
   */
  public Battle(Equipment eq1, Equipment eq2, Equipment eq3, Equipment eq4, Equipment eq5,
                Equipment eq6, Equipment eq7, Equipment eq8, Equipment eq9, Equipment eq10) {
    equipments = new ArrayList<>();
    addEquipments(eq1);
    addEquipments(eq2);
    addEquipments(eq3);
    addEquipments(eq4);
    addEquipments(eq5);
    addEquipments(eq6);
    addEquipments(eq7);
    addEquipments(eq8);
    addEquipments(eq9);
    addEquipments(eq10);
    Collections.sort(equipments);
    isFirstPlayer = true;
  }

  /**
   * Get the sorted equipment list by the attack power and follows by the defend power.
   *
   * @return The sorted equipment list.
   */
  public List<Equipment> getEquipments() {
    return equipments;
  }

  /**
   * Add an Equipment to the game.
   *
   * @param equipment An equipment object.
   */
  public void addEquipments(Equipment equipment) {
    equipments.add(equipment);
  }

  /**
   * Method to decide which player should add equipment for the current round.
   *
   * @param player1 The 1st player.
   * @param player2 The 2nd player.
   */
  public void chooseEquipments(Character player1, Character player2) {
    if (!player1.getDone() && isFirstPlayer) {
      addEquipmentToPlayer(player1);
    } else if (!player2.getDone() && !isFirstPlayer) {
      addEquipmentToPlayer(player2);
    }
  }

  /**
   * Add equipment to the player in the current round. Always choose to combine with the equipments
   * that the player already have, and if combine equipments fails, then add the single equipment to
   * the player.
   *
   * @param player The player of the current round.
   */
  private void addEquipmentToPlayer(Character player) {
    boolean addCombined = false;
    for (int i = 0; i < equipments.size(); i++) {
      Equipment currBestEquipment = equipments.get(i);
      if (player.checkCombination(currBestEquipment)) {
        player.combineEquipments(currBestEquipment);
        equipments.remove(i);
        addCombined = true;
        isFirstPlayer = !isFirstPlayer;
        break;
      }
    }
    if (!addCombined) {
      for (int j = 0; j < equipments.size(); j++) {
        Equipment currBestEquipment = equipments.get(j);
        if (player.checkSingle(currBestEquipment)) {
          player.addSingle(currBestEquipment);
          player.addAttack(currBestEquipment.getAttackPts());
          player.addDefend(currBestEquipment.getDefendPts());
          equipments.remove(j);
          isFirstPlayer = !isFirstPlayer;
          break;
        } else if (j == equipments.size() - 1) {
          isFirstPlayer = !isFirstPlayer;
          player.setDone();
        }
      }
    }
  }

  /**
   * Return the string of the equipments that player 1 have.
   * @return The output of player 1's equipments.
   */
  public String getPlayer1TotalEquipments(Character player1) {
    String str = "";
    List<Equipment> player1Equipments = player1.getEquipments();
    for (Equipment equipment: player1Equipments) {
      str += equipment.toString();
    }
    return str;
  }

  /**
   * Return the string of the equipments that player 2 have.
   * @return The output of player 2's equipments.
   */
  public String getPlayer2TotalEquipments(Character player2) {
    String str = "";
    List<Equipment> player2Equipments = player2.getEquipments();
    for (Equipment equipment: player2Equipments) {
      str += equipment.toString();
    }
    return str;
  }

  /**
   * Return the string of player 1's attack strength.
   * @return The player's attack strength.
   */
  public String player1AttackPts(Character player1) {
    int num = player1.getTotalAttackPts();
    return String.format("Player 1 has %s points of attack strenth.", num);
  }

  /**
   * Return the string of player 1's defend strength.
   * @return The player's defend strength.
   */
  public String player1DefendPts(Character player1) {
    return String.format("Player 1 has %s points of defend strenth.", player1.getTotalDefendPts());
  }

  /**
   * Return the string of player 2's attack strength.
   * @return The player's defend strength.
   */
  public String player2AttackPts(Character player2) {
    return String.format("Player 2 has %s points of attack strenth.", player2.getTotalAttackPts());
  }

  /**
   * Return the string of player 2's defend strength.
   * @return The player's defend strength.
   */
  public String player2DefendPts(Character player2) {
    return String.format("Player 2 has %s points of defend strenth.", player2.getTotalDefendPts());
  }

  /**
   * Get the winner by who has the lower damage.
   *
   * @param player1 The 1st player.
   * @param player2 The 2nd player.
   * @return The result of the game.
   */
  public String getWinner(Character player1, Character player2) {
    int player1Damage = player2.getTotalAttackPts() - player1.getTotalDefendPts();
    int player2Damage = player1.getTotalAttackPts() - player2.getTotalDefendPts();
    if (player1Damage < player2Damage) {
      return "Player 1 wins.";
    } else if (player1Damage > player2Damage) {
      return "Player 2 wins.";
    } else {
      return "Two players are tie.";
    }
  }
}
