package com.bobocode.cs;

import com.bobocode.util.ExerciseNotCompletedException;

import java.util.NoSuchElementException;

/**
 * {@link ArrayList} is an implementation of {@link List} interface. This resizable data structure
 * based on an array and is simplified version of {@link java.util.ArrayList}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com">visit our website</a></strong>
 * <p>
 *
 * @author Serhii Hryhus
 */
public class ArrayList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 5;
    /**
     * This constructor creates an instance of {@link ArrayList} with a specific capacity of an array inside.
     *
     * @param initCapacity - the initial capacity of the list
     * @throws IllegalArgumentException – if the specified initial capacity is negative or 0.
     */

    private int capacity;

    private int size;

    private T[] table;

    public ArrayList(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = initCapacity;
        this.table = (T[]) new Object[initCapacity];
    }

    /**
     * This constructor creates an instance of {@link ArrayList} with a default capacity of an array inside.
     * A default size of inner array is 5;
     */
    public ArrayList() {

        this.capacity = DEFAULT_CAPACITY;
        this.table = (T[]) new Object[DEFAULT_CAPACITY];

    }

    /**
     * Creates and returns an instance of {@link ArrayList} with provided elements
     *
     * @param elements to add
     * @return new instance
     */
    public static <T> List<T> of(T... elements) {
        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Adds an element to the array.
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        ResizeIfNecessary();
        table[size] = element;
        size++;
    }

    private void ResizeIfNecessary() {
        if (size > capacity / 2) {
            ExtendArray();
        }
    }

    private void ExtendArray() {
        capacity = capacity + (capacity >> 1);
        T[] newTable = (T[]) new Object[]{capacity};
        System.arraycopy(table, 0, newTable, 0, size);
        table = newTable;
    }

    /**
     * Adds an element to the specific position in the array where
     *
     * @param index   index of position
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Retrieves an element by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index index of element
     * @return en element
     */
    @Override
    public T get(int index) {

        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Returns the first element of the list. Operation is performed in constant time O(1)
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getFirst() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        return table[0];
    }

    /**
     * Returns the last element of the list. Operation is performed in constant time O(1)
     *
     * @return the last element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return table[size - 1];
    }

    /**
     * Changes the value of array at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   position of value
     * @param element a new value
     */
    @Override
    public void set(int index, T element) {

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        table[index] = element;
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return deleted element
     */
    @Override
    public T remove(int index) {
        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Checks for existing of a specific element in the list.
     *
     * @param element is element
     * @return If element exists method returns true, otherwise it returns false
     */
    @Override
    public boolean contains(T element) {
        throw new ExerciseNotCompletedException(); // todo: implement this method
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return amount of saved elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {

        table = (T[]) new Object[capacity];
        size = 0;
    }
}
