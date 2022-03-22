package com.company;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(10);
        list.add(20);
        list.add(2, 30);
        list.delete(3);

        System.out.println("LinkedList : " + list);
        System.out.println("Number in index 2 is : " + list.get(2));
        System.out.println("LinkedList is empty : " + list.isEmpty());
        System.out.println("Size of list is : " + list.size());

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println("\n");
    }
}
