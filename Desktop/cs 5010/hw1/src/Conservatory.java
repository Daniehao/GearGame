import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Conservatory {
  List<Aviaries> aviariesList;
  Map<String, Integer> foodMap;
  int aviariesIndex;
  Map<Birds, Integer> birdsAviariesMap;
  Map<String, List<Integer>> typeMap;

  public Conservatory() {
    aviariesList = new ArrayList<>();
    foodMap = new HashMap<>();
    aviariesIndex = 0;
    birdsAviariesMap = new HashMap<>();
    typeMap = new HashMap<>();
  }

  public void addRescue(Birds bird) {
    if (!bird.getIsExtinct() && aviariesList.size() < 20) {
      addBirdInAviaries(bird);
    }
    else if (aviariesList.size() >= 20) {
      throw new IllegalArgumentException("The aviaries are full.");
    }
    else {
      throw new IllegalArgumentException("The bird has already extinct.");
    }
  }

  public void addBirdInAviaries(Birds bird) {
    String birdClass = bird.getClass().toString();
    if (birdClass != "FlightlessBirds" && birdClass != "PreyBirds" && birdClass != "WaterFowl") {
      birdClass = "Other";
    }
    for (int i = 0; i < aviariesList.size(); i++) {
      //Use current aviary
      if (aviariesList.get(i).getAviaryName() == birdClass && aviariesList.get(i).getCurrNum() < 5) {
        addIntoLists(bird, i);
      }
    }
    //create aviary
    if (aviariesList.size() < 20) {
      aviariesIndex++;
      aviariesList.add(new Aviaries(bird));
      addIntoLists(bird, aviariesIndex);
    } else {
      throw new IllegalArgumentException("There are already 20 aviaries!");
    }
  }

  private void addIntoLists(Birds bird, int i) {
    aviariesList.get(i).addBird(bird);
    birdsAviariesMap.put(bird, i);
    addFoodMap(bird);
    if (!typeMap.containsKey(bird.getType())) {
      typeMap.put(bird.getType(), new ArrayList<>());
    }
    typeMap.get(bird.getType()).add(i);
  }

  public void addFoodMap(Birds bird) {
    List<String> foodList = bird.getPreferredFood();
    int n = foodList.size();
    for (int i = 0; i < n; i++) {
      String food = foodList.get(i);
      if (foodMap.containsKey(food)) {
        foodMap.put(food, foodMap.get(i) + 1);
      } else {
        foodMap.put(food, 1);
      }
    }
  }

  public String getFoodMap() {
    String foodStr = "";
    for (String food: foodMap.keySet()) {
      foodStr = foodStr + food + "quantity is: " + foodMap.get(food) + ".";
    }
    return foodStr;
  }

  public String getTypeMap() {
    Map<String, List<Integer>> treeMap = new TreeMap<>(typeMap);
    String rst = "";
    for (String str : treeMap.keySet()) {
      rst = rst + "Type is" + str + "Bird aviaries are: " + treeMap.get(str) + ".";
    }
    return rst;
  }

  public String getBirdAviary(Birds bird) {
    for (Birds birdInMap: birdsAviariesMap.keySet()) {
      if (birdInMap.equals(bird)){
        return "This bird is in Aviary: " + birdsAviariesMap.get(birdInMap) + ".";
      }
    }
    return "This bird is not in current aviaries.";
  }

  public String getBirdDescription(Aviaries aviary) {
    return aviary.getText();
  }

  public Map<Integer, List<Birds>> getAviariesLocationBirds() {
    Map<Integer, List<Birds>> aviaryLocation = new HashMap<>();
    for (int i = 0; i < aviariesList.size(); i++) {
      aviaryLocation.put(i, aviariesList.get(i).getBirdsList());
    }
    return aviaryLocation;
  }
}
