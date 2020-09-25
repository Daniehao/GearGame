import java.util.ArrayList;
import java.util.List;

public class Parrot extends AbstractBirds{
  public Parrot() {
    setCharacteristic();
  }
  @Override
  public void setCharacteristic() {
    characteristic = "Having a short, curved beak and are known for their intelligence and ability"
            + "to mimic sounds.";
  }
}
