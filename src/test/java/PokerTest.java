
import com.proyectomobiliario.test.Poker;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Camilo Wong
 */
public class PokerTest {
    
    public PokerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
     public void straightTest() {
         Poker poker = new Poker();
         int[] test1 = new int[]{2, 3, 4 ,5, 6};
         int[] test2 = new int[]{14, 5, 4 ,2, 3};
         int[] test3 = new int[]{7, 7, 12 ,11, 3, 4, 14};
         int[] test4 = new int[]{7, 3, 2};
         
         assertTrue("escalera " + Arrays.toString(test1), poker.isPokerStraight(test1));
         assertTrue("escalera " + Arrays.toString(test2), poker.isPokerStraight(test2));
         assertFalse("no es escalera " + Arrays.toString(test3),poker.isPokerStraight(test3));
         assertFalse("no es escalera " + Arrays.toString(test3),poker.isPokerStraight(test4));
     }
}
