package Challenger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueNumber {


    public static int[] testCase1 = {7,7,7,7,7,7};

    public static Map<Integer, Integer> freqMap;
    public static Queue<Integer> orderOfElements;

    public static void FirstUnique(int[] nums) {
         freqMap = new HashMap<>();
         orderOfElements  = new LinkedList<Integer>();

        for (Integer num : nums) {
            orderOfElements.add(num);
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        freqMap.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
        orderOfElements.forEach(num -> System.out.println("Number: " + num));
    }

    public static int showFirstUnique() {

        while(!orderOfElements.isEmpty() && freqMap.get(orderOfElements.element()) > 1) {
            orderOfElements.remove();
        }
        if (orderOfElements.isEmpty()) {
            return -1;
        }
        return orderOfElements.element();
    }

    public static void add(int value) {
        orderOfElements.add(value);
        freqMap.put(value, freqMap.getOrDefault(value, 0)+1);

    }

    public static void main(String[] args) {

        FirstUnique(testCase1);
        System.out.println("showFirstUnique: " + showFirstUnique());
        add(7);
        add(3);
        add(3);
        add(7);
        add(17);
        System.out.println("showFirstUnique: " + showFirstUnique());
        
    }
}