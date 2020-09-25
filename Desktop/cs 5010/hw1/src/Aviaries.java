import java.util.ArrayList;
import java.util.List;

public class Aviaries {
  private String aviaryName;
  private int currNum;
  private List<Birds> birdsList;
  private List<String> text;

  public Aviaries(Birds bird) {
    birdsList = new ArrayList<>();
    text = new ArrayList<>();

    birdsList.add(bird);
    setAviaryName(bird);
    currNum = 1;
    text.add(bird.getCharacteristic());
  }

  public void addBird(Birds bird) {
    birdsList.add(bird);
    currNum += 1;
    text.add(bird.getCharacteristic());
  }

  public void setAviaryName(Birds bird) {
    String birdClassName = bird.getClass().toString();
    if (birdClassName != "FlightlessBirds" && birdClassName != "PreyBirds"
            && birdClassName != "WaterFowl"){
      birdClassName = "Other";
    }
    this.aviaryName = birdClassName;
  }

  public int getCurrNum() {
    return currNum;
  }

  public List<Birds> getBirdsList() {
    return birdsList;
  }

  public String getAviaryName() {
    return aviaryName;
  }

  public String getText() {
    String textOfAviary = "";
    for (String eachText: text) {
      textOfAviary = textOfAviary + eachText;
    }
    return textOfAviary;
  }
}
