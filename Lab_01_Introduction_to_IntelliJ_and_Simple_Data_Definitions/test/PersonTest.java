import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Person class.
 */
public class PersonTest {

  private Person john;

  @Before
  public void setUp() {

    john = new Person("John", "Doe", 1945);
  }

  @Test
  public void testFirst() {
    assertEquals("John", john.getFirstName());

  }

  @Test
  public void testSecond() {
    assertEquals("Doe", john.getLastName());
  }

  @Test
  public void testYearOfBirth() {
    assertEquals(1945, john.getYearOfBirth());
  }

}