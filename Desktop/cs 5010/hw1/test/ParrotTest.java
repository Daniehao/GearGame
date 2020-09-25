import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParrotTest {
  private Birds parrotBird1;

  @Before
  public void setup() {
    parrotBird1 = new Parrot();
  }

  @Test
  public void setCharacteristicTest() {
    parrotBird1.setCharacteristic();
    assertEquals(parrotBird1.getCharacteristic(), "Having a short, curved beak and are known "
            + "for their intelligence and ability" + "to mimic sounds.");
  }
}
