import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {

    public static String[] testCase1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
    public static String[] testCase2 = {"", ""};
    public static String[] testCase3 = {"", "", ""};
  


    public static List<List<String>> groupAnagramsGreedy(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        List<String> strList = new ArrayList<String>(Arrays.asList(strs));

        for (int i = 0; i < strList.size(); i++ ) {
            List<String> ansRow = new ArrayList<>();
            String pointer1 = strList.get(i);

            if (!ansRow.contains(pointer1)) {
                ansRow.add(pointer1);
            }
            for (int j = i+1; j < strList.size(); j++) {
                String pointer2 = strList.get(j);

                if (pointer1.isEmpty() && pointer2.isEmpty()) {
                    ansRow.add(pointer2);
                    break;
                }

                if (isAnagram(pointer1, pointer2)){
                    if (!ansRow.contains(pointer2)) {
                        ansRow.add(pointer2);
                        strList.remove(j);
                    }
                } 
            }
            if (ansRow.size() != 0) {
                ans.add(ansRow);
            }
            
        }
        return ans;
    }

    public static boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }
        Set<Character> searchable = new HashSet<>();
        
        for (char ch : str2.toCharArray()) { 
  
            searchable.add(ch); 
        }

        for (char ch : str1.toCharArray()) {
           if (searchable.contains(ch)) {
               searchable.remove(ch);
           }
        }

        return searchable.isEmpty();
    }




    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList();

        Map<String, List> ans = new HashMap<String, List>();

        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());

    }


    public static boolean isAnagramSingle(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return true;
        }

        if (s.isEmpty() || t.isEmpty()) {
            return true;
        }

        char[] cS = s.toCharArray();
        char[] tS = t.toCharArray();

        Arrays.sort(cS);
        Arrays.sort(tS);

        if (!String.valueOf(cS).equals(String.valueOf(tS))) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println("===============================================================================");

        System.out.println("Expected: [[ate,eat,tea],[nat,tan],[bat]] :: Actual: " + groupAnagrams(testCase1));
        System.out.println("Expected: [['' , '']] :: Actual: " + groupAnagrams(testCase2));
        System.out.println("Expected: [['' , '', '']] :: Actual: " + groupAnagrams(testCase3));

        System.out.println("===============================================================================");

        System.out.println("Expected: true :: Actual: " + isAnagramSingle("anagram", "nagaram"));
        System.out.println("Expected: true :: Actual: " + isAnagramSingle("", ""));
        System.out.println("Expected: false :: Actual: " + isAnagramSingle("", "4444444"));




    }

}