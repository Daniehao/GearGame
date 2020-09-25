import java.util.ArrayList;

public class WaterFowl extends AbstractBirds{
  public WaterFowl() {
    setCharacteristic();
  }
  @Override
  public void setCharacteristic() {
    this.characteristic = "Living near water sources (fresh or salt).";
  }
}