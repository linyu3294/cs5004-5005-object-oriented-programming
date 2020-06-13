import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
  private Book got;
  private Person g_r_r_Martin;

  /**
   * A JUnit test class for the Book class.
   */

  @Before
  public void setUp() throws Exception {
    g_r_r_Martin = new Person ("George", "Martin", 1948);
    got = new Book("Game_Of_Thones", g_r_r_Martin, 40);

  }
  @Test
  public void testGetTitle() {
    assertEquals("Game_Of_Thrones", got.getTitle());
  }

  @Test
  public void testGetPrice() {
    assertEquals(40, got.getPrice(),0.01);
  }

  @Test
  public void getAuthor() {
    assertEquals(g_r_r_Martin, got.getAuthor());
  }
}