import java.util.List;

public interface Birds {
  public String getType();

  public String getCharacteristic();

  public boolean getIsExtinct();

  public int getWings();

  public List<String> getPreferredFood();

  public void setType(String type);

  public void setCharacteristic();

  public void setExtinct(boolean hasExtinct);

  public void setWings(int wings);

  public void addPreferredFood(String food);

  public void setCloseToWater(boolean closeToWater);

  public boolean getCloseToWater();

  public void setTotalNumWords(int totalNumWords);

  public void setFavoriteWord(String word);

  public int getTotalNumWords();

  public String getFavoriteWord();
}
