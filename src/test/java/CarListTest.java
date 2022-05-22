import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    private CarList carList;

    @org.junit.Before

    public void setUp() throws Exception {
        carList = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsthenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemoveByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemoveThenSizeMustBeDecreased() {
        Car car1 = new Car("BMW", 5);
        carList.add(car1);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car1));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car1 = new Car("BMW", 5);
        assertFalse(carList.remove(car1));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        carList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle (){
        Car car1 = new Car("BMW", 5);
        carList.add(car1, 50);
        Car carFromList=carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirstPosition (){
        Car car1 = new Car("BMW", 5);
        carList.add(car1, 0);
        Car carFromList=carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public void insertIntoLastPosition (){
        Car car1 = new Car("BMW", 5);
        carList.add(car1, 99);
        Car carFromList=carList.get(99);
        assertEquals("BMW", carFromList.getBrand());
    }
}