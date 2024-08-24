package com.bobocode.cs;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.lang.Math.max;

/**
 * {@link RecursiveBinarySearchTree} is an implementation of a {@link BinarySearchTree} that is based on a linked nodes
 * and recursion. A tree node is represented as a nested class {@link Node}. It holds an element (a value) and
 * two references to the left and right child nodes.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com">visit our website</a></strong>
 * <p>
 *
 * @param <T> a type of elements that are stored in the tree
 * @author Taras Boychuk
 * @author Maksym Stasiuk
 */
public class RecursiveBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {

    private Node<T> root;
    private int size;

    @SafeVarargs
    public static <T extends Comparable<T>> RecursiveBinarySearchTree<T> of(T... elements) {
        RecursiveBinarySearchTree<T> tree = new RecursiveBinarySearchTree<>();
        Stream.of(elements).forEach(tree::insert);
        return tree;
    }

    @Override
    public boolean insert(T element) {
        if (root == null) {
            root = Node.of(element);
            size++;
            return true;
        }
        return insert(root, element);
    }

    private boolean insert(Node<T> node, T element) {

        int comparisonResult = node.element.compareTo(element);
        if (comparisonResult > 0) {
            if (node.left == null) node.left = Node.of(element);
            else return insert(node.left, element);
        } else if (comparisonResult < 0) {
            if (node.right == null) node.right = Node.of(element);
            else return insert(node.right, element);
        } else return false;

        size++;
        return true;
    }

    @Override
    public boolean contains(T element) {
        Objects.requireNonNull(element);
        return contains(element, root);


    }

    private boolean contains(T element, Node<T> node) {
        if (node == null) {
            return false;
        }
        int comparisonResult = node.element.compareTo(element);
        if (comparisonResult == 0) return true;
        if (comparisonResult > 0) return contains(element, node.left);
        else return contains(element, node.right);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int depth() {
        if (root == null || (root.right == null && root.left == null)) return 0;
        return depth(root) - 1;
    }

    private int depth(Node<T> node) {
        if (node == null) return 0;
        return max(depth(node.left), depth(node.right)) + 1;
    }

    @Override
    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversal(consumer, root);
    }

    private void inOrderTraversal(Consumer<T> consumer, Node<T> node) {
        if (node == null) return;
        inOrderTraversal(consumer, node.left);
        consumer.accept(node.element);
        inOrderTraversal(consumer, node.right);
    }

    static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;

        public Node(T element) {
            this.element = element;
        }

        static <T> Node<T> of(T element) {
            return new Node<>(element);
        }
    }

}
