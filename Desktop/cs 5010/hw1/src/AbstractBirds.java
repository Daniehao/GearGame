import java.util.ArrayList;
import java.util.List;

abstract class AbstractBirds implements Birds{
    String birdType;
    String characteristic;
    Boolean hasExtinct;
    int wings;
    String favoriteWord;
    int totalWords;
    List<String> preferredFood;

    boolean closeToWater;

    public void setPreferredFood() {
      preferredFood = new ArrayList<>();
    }
    public String getType() {
      return birdType;
    }

    public String getCharacteristic() {
      return characteristic;
    }

    public boolean getIsExtinct() {
      return hasExtinct;
    }

    public int getWings() {
      return wings;
    }

    public List<String> getPreferredFood(){
      return preferredFood;
    }

    public void setType(String type) {
      birdType = type;
    }

    public abstract void setCharacteristic();

    public void setExtinct(boolean hasExtinct) {
      this.hasExtinct = hasExtinct;
    }

    public void setWings(int wings) {
      this.wings = wings;
    }

    public void addPreferredFood(String food){
      preferredFood.add(food);
    }

    public void setCloseToWater(boolean closeToWater){
      this.closeToWater = closeToWater;
    }

    public boolean getCloseToWater(){
      return closeToWater;
    }

    public void setTotalNumWords(int totalNumWords){
      this.totalWords = totalNumWords;
    }

    public void setFavoriteWord(String word){
      this.favoriteWord = word;
    }

    public int getTotalNumWords(){
      return totalWords;
    }

    public String getFavoriteWord(){
      return favoriteWord;
    }
}
