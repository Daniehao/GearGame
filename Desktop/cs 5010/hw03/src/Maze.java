import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Maze {
  private int rows;
  private int cols;
  private int remains;
  private Cell[][] maze;
  private boolean isWrapping;

  public Maze(int rows, int cols, int remains, boolean isWrapping) {
    this.rows = rows;
    this.cols = cols;
    this.remains = remains;
    this.isWrapping = isWrapping;
    generatePerfectMaze(rows, cols);
  }

  private void generatePerfectMaze(int rows, int cols) {
    int[][] unionNums = new int[rows][cols];
    List<Integer> walls = new ArrayList<>();
    Map<Integer, List<Integer>> unionToCells = new HashMap<>();
    generateCells(rows, cols);
    int totalWalls = (cols - 1) * rows + (rows - 1) * cols;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < rows; j++) {
        unionNums[i][j] = i + cols*j;
        List<Integer> temp = new ArrayList<>();
        temp.add(i + cols*j);
        unionToCells.put(i + cols*j, temp);
      }
    }
    for (int i = 0; i < totalWalls; i++) {
      walls.add(i);
    }
    Random random = new Random();
    int removedCount = 0;
    int saveCount = 0;
    while (removedCount < rows*cols - 1 || saveCount != totalWalls - rows*cols + 1) {
      int randomInt = random.nextInt(walls.size());
      walls.remove(randomInt);
      removedCount++;

    }

  }

  private void generateCells(int rows, int cols) {
    maze = new Cell[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < rows; j++) {
        maze[i][j] = new Cell();
      }
    }
  }

  private boolean checkRemovalValidation(int randomInt, int unionNums) {

  }

}
