import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigeonsTest {
  private Birds pigeon1;

  @Before
  public void setup() {
    pigeon1 = new Pigeons();
  }

  @Test
  public void setCharacteristicTest() {
    pigeon1.setCharacteristic();
    assertEquals(pigeon1.getCharacteristic(), "Feeding their young \"bird milk\" very " +
            "similar to the milk of mammals.");
  }
}
