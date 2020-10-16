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
    List<Integer> savedWall = new ArrayList<>();
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
    while (removedCount < rows*cols - 1 || savedWall.size() < totalWalls - rows*cols + 1) {
      int randomInt = random.nextInt(walls.size());
      int[][] cellsPositions = getCellsPositionByWall(walls.get(randomInt));
      int cell1X = cellsPositions[0][0];
      int cell1Y = cellsPositions[0][1];
      int cell2X = cellsPositions[1][0];
      int cell2Y = cellsPositions[1][1];
      if (unionNums[cell1X][cell1Y] == unionNums[cell2X][cell2Y]) {
        savedWall.add(walls.get(randomInt));
      } else {
        Cell cell1 = maze[cell1X][cell1Y];
        Cell cell2 = maze[cell2X][cell2Y];
        if (cell1X == cell2X) {
          cell1.setNextCell(cell2, "right");
          cell2.setNextCell(cell1, "left");
        } else {
          cell1.setNextCell(cell2, "down");
          cell2.setNextCell(cell1, "up");
        }
        removedCount++;
        int unionNum1 = unionNums[cell1X][cell1Y];
        int unionNum2 = unionNums[cell2X][cell2Y];
        for (int cellIndex: unionToCells.get(unionNum1)) {
          unionNums[cellIndex/cols][cellIndex%cols] = unionNum2;
        }
        unionToCells.get(unionNum2).addAll(unionToCells.get(unionNum1));
        unionToCells.remove(unionNum1);
      }
      walls.remove(randomInt);
    }
    if (removedCount == rows*cols - 1) {
      for (int i = 0; i < walls.size(); i++) {
        savedWall.add(walls.get(i));
      }
    }

    if (savedWall.size() == totalWalls - rows*cols + 1) {
      for (int wall: walls) {
        int[][] cellsPositions = getCellsPositionByWall(wall);
        int cell1X = cellsPositions[0][0];
        int cell1Y = cellsPositions[0][1];
        int cell2X = cellsPositions[1][0];
        int cell2Y = cellsPositions[1][1];
      }
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

  private int[][] getCellsPositionByWall(int wallIndex) {
    if (wallIndex < rows* (cols - 1)) {
      int colIndex = wallIndex % (cols - 1);
      int rowIndex = wallIndex / (cols - 1);
      return new int[][] {{rowIndex, colIndex}, {rowIndex, colIndex + 1}};
    } else {
      wallIndex -= rows * (cols - 1);
      int colIndex = wallIndex % (rows - 1);
      int rowIndex = wallIndex / (rows - 1);
      return new int[][] {{rowIndex, colIndex}, {rowIndex + 1, colIndex}};
    }
  }
}
