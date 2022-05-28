import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarSetTest {


    private CarSet carSet;

    @Before
    public void setUp() throws Exception {
//init
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand" + i, i));
        }
    }
    @Test
    public void whenAdd3SimilarObjectsThenSizeIncreaseBy1(){
        assertEquals(100, carSet.size());
        assertTrue(carSet.add(new Car("BMW", 10)));
        assertFalse(carSet.add(new Car("BMW", 10)));
        assertFalse(carSet.add(new Car("BMW", 10)));
        assertEquals(101, carSet.size());
    }
}