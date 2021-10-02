package ru.lena.exersize;

public class List {
    private Node first;
    private Node last;
    private int size = 0;

    public static class Node {
        private Node prev;
        private Object object;
        private Node next;

        public Node(Node prev, Object object, Node next) {
            this.prev = prev;
            this.object = object;
            this.next = next;
        }
    }

    public void addFirst(Object object) {
        Node node = new Node(null, object, first);
        if (first != null) {
            first.prev = node;
        }
        else {
            last = node;
        }
        first = node;
        size++;
    }

    public void addLast(Object object) {
        Node node = new Node(last, object, null);
        last.next = node;
        last = node;
        size++;
    }

    public void add(Object object) {
        if (size == 0) {
            addFirst(object);
        } else {
            addLast(object);
        }
    }

    public int returnIndex(int index) { // for the fool's principle
        if (index < 0) {
            return 0;
        }
        if (index > size) {
            return size;
        }
        return index;
    }

    public Node returnNode(int index) { // method for getting current node
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void add(Object object, int index) {
        index = returnIndex(index);
        if (index == 0) {
            addFirst(object);
        } else if (index == size) {
            addLast(object);
        } else {
            Node node = returnNode(index);
            Node newNode = new Node(node.prev, object, node);
            Node previous = node.prev;
            previous.next = newNode;
            node.prev = newNode;
            size++;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object get(int index) {
        index = returnIndex(index); // in case index is out of list's range
        return returnNode(index).object;
    }

    public Object remove(int index) {
        index = returnIndex(index);
        if (index == 0){
            Node second = first.next;
            second.prev = null;
            Object removedObject = first;
            first = second;
            size--;
            return removedObject;
        }
        if (index == size - 1){
            Node almostLast = last.prev;
            almostLast.next = null;
            Object removedObject = last;
            size--;
            last = almostLast;
            return removedObject;
        }
        if (index < size - 1) {
            Node node = returnNode(index);
            Node previousNode = node.prev;
            Node nextNode = node.next;
            previousNode.next = nextNode;
            nextNode.prev = previousNode;
            size--;
            return node.object;
        } else {
            return null; // if index equals size then there is no objects there already
        }
    }

    public Object set(Object object, int index) {
        index = returnIndex(index);
        if (index == size) {
            addLast(object);
            return null; // there was no objects in here before adding one just now
        }
        Node node = returnNode(index);
        Object oldObject = node.object;
        node.object = object;
        return oldObject;
    }

    public int indexOf(Object object) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.object.equals(object)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    public boolean contains(Object object) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.object == object) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
