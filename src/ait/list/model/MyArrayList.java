package ait.list.model;

import ait.list.interfaces.IList;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements IList<E> {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] elements;
    private int size;

    public MyArrayList() {
//        elements=new Object[10];
        this(10);
    }

    public MyArrayList(int initialCapacity) {                   //O(1)
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("illegal capacity" + initialCapacity);
        }
        if (initialCapacity > MAX_ARRAY_SIZE) {
            initialCapacity = MAX_ARRAY_SIZE;
        }
        elements = new Object[initialCapacity];
    }

    @Override
    public int size() {                           //O(1)
        return size;
    }

    @Override
    public boolean add(E element) {                 //O(n)
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    private void ensureCapacity() {                   //O(1)
        if (size == MAX_ARRAY_SIZE) {
            throw new OutOfMemoryError();
        }
        if (size == elements.length) {
            int newCapacity = elements.length + elements.length / 2;
            if (newCapacity > MAX_ARRAY_SIZE || newCapacity < 0) {
                newCapacity = MAX_ARRAY_SIZE;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @Override
    public void clear() {                              //O(n)
        for (int i = 0; i < size; i++) {
            elements[i] = null;

        }
        size = 0;

    }

    @Override
    public boolean add(int index, E element) {                //O(n)
        ensureCapacity();
        checkIndex(index);
        for (int i = 0; i < size; i++) {
            if (i == index) {
                System.arraycopy(elements, index, elements, index + 1, size - index);
                elements[i] = element;
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {                                 //O(1)
        checkIndex(index);
        return (E) elements[index];
    }

    private void checkIndex(int index) {                      //O(1)
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public int indexOf(Object o) {                       //O(n)
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }


        } else
            for (int i = 0; i < size; i++) {
                if (o == elements[i]) {
                    return i;
                }

            }
        return -1;

    }


    @Override
    public int lastIndexOf(Object o) {                    //O(n)
        if (o != null) {
            for (int i = size-1; i >= 0; i--) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else

            for (int i = size-1; i >= 0; i--) {
                if (elements[i] == o) {
                    return i;
                }
            }


        return -1;
    }

    @Override
    public E remove(int index) {                               //O(n)
        checkIndex(index);
        E victum = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, --size - index);
//        size--;
        return victum;
    }

    @Override
    public E set(int index, E element) {                        //O(1)
        checkIndex(index);
        E res = (E) elements[index];
        elements[index] = element;
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO
        return new Iterator<E>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public E next() {
                return (E) elements[i++];
            }
        };

    }
}
