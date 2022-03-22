package com.company;

import org.w3c.dom.Node;

import java.util.Iterator;

public class LinkedList implements List {
    private int size;
    private Node a;
    private Node b;

    private static class Node {
        private int val;
        private Node next;

        Node(int tal) {
            this.val = val;
        }
    }

    private class LinkedListIterator implements Iterator<Integer> {
        private int index;

        private LinkedList.Node node = a;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Integer next() {
            Integer temp;
            index++;
            temp = node.val;
            return temp;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int get(int index) {
        checkValidIndex(index);
        if (index == size - 1) {
            return b.val;
        }
            Node tempNode = a;
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    break;
                }
                    tempNode = tempNode.next;

            }
            return tempNode.val;

    }

        @Override
        public void add ( int val){
            Node node = new Node(val);
            if (size == 0){
                addFirstEl(node);
                return;
            }
            addToEnd(node);
        }

        @Override
        public void add ( int index, int val){
            checkValidIndexForAdd(index);
            Node node = new Node(val);
            if (size == 0) {
                addFirstEl(node);
                return;
            }
            if (index == size) {
                addToEnd(node);
                return;
            }
            if (index == 0) {
                addFromStart(node);
                return;
            }
            Node tempNode = a;
            for (int i = 0; i < index; i++) {
                if (i == index - 1) {
                    node.next = tempNode.next;
                    tempNode.next = node;
                    break;
                }
                tempNode = tempNode.next;
            }
            size++;
        }

        @Override
        public void delete ( int index){
            checkValidIndex(index);
            if (index == 0) {
                a = a.next;
            } else {
                Node tempNode = a;
                for (int i = 1; i <= index; i++) {
                    if (index == i) {
                        if (tempNode.next == b) {
                            b = tempNode;
                        }
                        tempNode.next = tempNode.next.next;
                        break;
                    }
                    tempNode = tempNode.next;
                }
            }
            size--;
        }
    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        Node node = a;
        for (int i = 0; i < size; i++) {
            list.append(node.val);
            list.append(" ");
            node = node.next;
        }
        return String.valueOf(list);
    }


        private void checkValidIndex ( int index){
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
        }

    private void addFirstEl(Node node) {
        a = node;
        b = node;
        size++;
    }

    private void addToEnd(Node node) {
        b.next = node;
        b = node;
        size++;
    }

    private void checkValidIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void addFromStart(Node node) {
        node.next = a;
        a = node;
        size++;
    }
    }
