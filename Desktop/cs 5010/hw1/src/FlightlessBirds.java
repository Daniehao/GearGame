import java.util.ArrayList;
import java.util.List;

public class FlightlessBirds extends AbstractBirds{
  public FlightlessBirds() {
    setCharacteristic();
  }

  @Override
  public void setCharacteristic() {
    this.characteristic = "Living on the ground and have no (or undeveloped) wings.";
  }
}
