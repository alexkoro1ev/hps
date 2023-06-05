package linked_list;

import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {

        ArrayList<Node> nodes = new ArrayList<Node>();

        if (!isNull()) {
            Node node = this.head;
            while (node != null) {
                if (node.value == _value) {
                    nodes.add(node);
                }
                node = node.next;
            }
        }

        return nodes;
    }

    public boolean remove(int _value)
    {
        if (isNull()) {
            return false;
        }

        if (this.head.equals(this.tail)) {
            clear();

            return true;
        }

        if (this.head.value == _value) {
            removeHead();

            return true;
        }

        Node node = this.head;
        while (node.next != null) {
            if (node.next.value == _value) {
                if (node.next.equals(this.tail)) {
                    node.next = null;
                    this.tail = node;

                    return true;
                }

                node.next = node.next.next;

                return true;
            }
            node = node.next;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        if (!isNull()) {
            Node node = this.head;
            while (node.next != null) {
                if (node.value == _value) {
                    removeHead();
                }
                if (node.next.value == _value) {
                    if (node.next.equals(this.tail)) {
                        node.next = null;
                        this.tail = node;
                    } else {
                        node.next = node.next.next;
                    }
                }
            }
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        if (isNull()) {
            return 0;
        }

        int counter = 0;
        Node node = this.head;
        while (node != null) {
            counter++;
            node = node.next;
        }

        return counter; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;

            return;
        }

        if (!isNull()) {
            Node node = this.head;
            while (!_nodeAfter.equals(node)) {
                node = node.next;
            }
            _nodeToInsert.next = node.next;
            node.next = _nodeToInsert;
        }
    }

    public boolean isNull() {
        return this.head == null;
    }
    private void removeHead() {
        this.head = this.head.next;
    }
}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}