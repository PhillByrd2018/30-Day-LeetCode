package Challenger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {

        Map<Character, Integer> frequencyMap = new TreeMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Character> characters = new ArrayList<>(frequencyMap.keySet());        
        Collections.sort(characters, (a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        StringBuilder ans = new StringBuilder();
        for (char c : characters) {
            int copies = frequencyMap.get(c);
            buildAns(c, copies, ans);
        }

        return ans.toString();
        
    }
    
    public static void buildAns(char c, int freq, StringBuilder str) {

        for (int i = 0; i < freq; i++) {
            str.append(c);
        }
    }

    public static void main(String[] args) {
        System.out.println("Expected: bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbac :: Actual: "
                + frequencySort("abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbc"));
    }
}