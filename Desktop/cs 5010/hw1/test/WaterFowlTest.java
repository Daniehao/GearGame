import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WaterFowlTest {
  private Birds waterfowl1;

  @Before
  public void setup() {
    waterfowl1 = new WaterFowl();
  }

  @Test
  public void setCharacteristicTest() {
    waterfowl1.setCharacteristic();
    assertEquals(waterfowl1.getCharacteristic(), "Living near water sources (fresh or salt).");
  }
}
