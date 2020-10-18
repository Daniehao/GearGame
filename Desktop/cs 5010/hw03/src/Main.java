import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    System.out.println("Enter rows: ");
//    int rows = Integer.valueOf(sc.nextLine());
//    System.out.println("Enter columns: ");
//    int cols = Integer.valueOf(sc.nextLine());
//    System.out.println("Enter remains wall number: ");
//    int remains = Integer.valueOf(sc.nextLine());
//    System.out.println("Enter whether it is a perfect maze: ");
//    boolean isPerfect = sc.nextLine() == "true" ? true : false;
//    System.out.println("Enter whether it is a wrapping maze: ");
//    boolean isWrapping = sc.nextLine() == "true" ? true : false;
//    System.out.println("Enter the x of the start point: ");
//    int startX = Integer.valueOf(sc.nextLine());
//    System.out.println("Enter the y of the start point: ");
//    int startY = Integer.valueOf(sc.nextLine());
//    System.out.println("Enter the x of the target point: ");
//    int targetX = Integer.valueOf(sc.nextLine());
//    System.out.println("Enter the y of the target point: ");
//    int targetY = Integer.valueOf(sc.nextLine());

    int rows = 3;
    int cols = 4;
    int remains = 6;
    boolean isPerfect = true;
    boolean isWrapping = false;
    int startX = 0;
    int startY = 2;
    int targetX = 2;
    int targetY = 1;

    if (startX < 0 || startX >= rows || startY < 0 || startY >= cols) {
      throw new IllegalArgumentException("The start point is invalid!");
    } else if (targetX < 0 || targetX >= rows || targetY < 0 || targetY >= cols) {
      throw new IllegalArgumentException("The target point is invalid!");
    } else if (isWrapping && remains >= rows * cols - 1) {
      throw new IllegalArgumentException("The remains has to be less than rows * cols - 1 for " +
              "non-wrapping maze!");
    } else {
      Maze maze = new Maze(rows, cols, remains, isPerfect, isWrapping, startX, startY);
      System.out.println(String.format("Player's current location: (%d, %d)",
              maze.getPlayerPosX(), maze.getPlayerPosY()));
      System.out.println(String.format("Player's current gold amount: %d", maze.getPlayerGold()));
      maze.goDown();
      System.out.println(String.format("Player's current location: (%d, %d)",
              maze.getPlayerPosX(), maze.getPlayerPosY()));
      System.out.println(String.format("Player's current gold amount: %d", maze.getPlayerGold()));
      maze.goRight();
      System.out.println(String.format("Player's current location: (%d, %d)",
              maze.getPlayerPosX(), maze.getPlayerPosY()));
      System.out.println(String.format("Player's current gold amount: %d", maze.getPlayerGold()));
      maze.goDown();
      System.out.println(String.format("Player's current location: (%d, %d)",
              maze.getPlayerPosX(), maze.getPlayerPosY()));
      System.out.println(String.format("Player's current gold amount: %d", maze.getPlayerGold()));
      maze.goLeft();
      System.out.println(String.format("Player's current location: (%d, %d)",
              maze.getPlayerPosX(), maze.getPlayerPosY()));
      System.out.println(String.format("Player's current gold amount: %d", maze.getPlayerGold()));
      maze.goLeft();
      System.out.println(String.format("Player's current location: (%d, %d)",
              maze.getPlayerPosX(), maze.getPlayerPosY()));
      System.out.println(String.format("Player's current gold amount: %d", maze.getPlayerGold()));
    }
  }

}
