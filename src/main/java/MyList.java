public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] element;
    private int minCapacity;

    public MyList() {
        element = new Object[DEFAULT_CAPACITY];
    }
    public E getElement(int index) {
        return (E)element[index];
    }

    public MyList(int capacity) {
        if (capacity > 0) {
            element = new Object[capacity];
        } else if (capacity == 0) {
            element = new Object[]{};
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);
        }
    }
    private void ensureCapa() {
        int newSize = element.length*2;
        Object[] copyElement = new Object[newSize];
        if (size >= 0) System.arraycopy(element, 0, copyElement, 0, size);
        element = copyElement;
    }
    public void addE(E e) {
        if (size == element.length) {
            ensureCapa();
        }
        element[size++] = e;
    }
    public void add(int index, E e) {
        checkIndex(index);
        if (size == element.length) {
            ensureCapa();
        }
        if (size - index >= 0) System.arraycopy(element, index, element, index + 1, size - index);
        element[index]= e;
        size++;
    }
    private void checkIndex(int index) {
        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();

            }
        } catch (IndexOutOfBoundsException E) {
            System.out.println("Out of bounds");
        }
    }
    public E remote(int index) {
        E result = (E) element[index];
        checkIndex(index);
        if (size - index >= 0) System.arraycopy(element, index + 1, element, index, size - index);
        element[size - 1] = null;
        size--;

        return result;
    }
    public int getSize() {
        return size;
    }
    public E[] clone() {
        Object[] newElement = new Object[size];
        for (int i = 0; i < size ; i++) {
            newElement[i] = element[i];
        }
        return (E[]) newElement;
    }
    public boolean contains(E o) {
        for (int i = 0; i < size - 1; i++) {
            if (o.equals(element[i])) {
                return true;
            }
        }
        return false;
    }
    public int indexOf(E o) {
        for (int i = 0; i < size - 1; i++) {
            if (o.equals(element[i])) {
                return i;
            }
        }
        return -1;
    }
    public void ensureCapacity(int minCapacity) {
        if (element.length < minCapacity) {
            Object[] newElement = new Object[minCapacity];
            if (size >= 0) System.arraycopy(element, 0, newElement, 0, size);
            element = newElement;
        }
    }
    public void clear() {
        for (Object o:element
             ) {
            o = null;
        }
        size = 0;
    }
    public String toString() {
        return "element 0: "+ getElement(0);
    }
}

