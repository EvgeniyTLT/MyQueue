import java.util.Collections;

public interface CarQueue extends CarCollection {

    boolean add(Car car);

    Car peek();

    Car pol();
}
