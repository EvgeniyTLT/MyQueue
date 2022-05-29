public class CarHashSet implements CarSet {

    private static final int INITIAL_CAPASITI = 16;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPASITI];

    @Override
    public boolean add(Car car) {
        int position = getElementPosition(car, array.length);
        if (array[position] == null) {
            Entry entry = new Entry(car, array[position]);
            array[position] = entry;
            size++;
            return true;
        } else {
            Entry existenElement = array[position];
            while (true) {
                if (existenElement.value.equals(car)) {
                    return false;
                } else if (existenElement.next == null) {
                    existenElement.next = new Entry(car, null);
                    size++;
                    return true;
                } else {
                    existenElement = existenElement.next;
                }
            }
        }
    }

    @Override
    public boolean remove(Car car) {
        int position = getElementPosition(car, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.next;
        if (secondLast.value.equals(car)) {
            array[position] = last;
            size--;
            return true;
        }
        while (last != null) {
            if (last.value.equals(car)) {
                secondLast.next = last.next;
                size--;
                return true;
            } else {
                secondLast = last;
                last = last.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    private int getElementPosition(Car car, int arrayLength) {
        return Math.abs(car.hashCode() % arrayLength);
    }

    private static class Entry {
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
