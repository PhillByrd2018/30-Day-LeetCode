import java.util.stream.Collectors;
import java.util.*;

public class AWSexam {

    // Given a list of features for a product and reviews of that product, return a
    // list of the most frequent one equal to numberOfTopWordsToReturn

    public static List<String> findMostFrequentWord(int numberOfWords, int numberOfTopWordsToReturn,
            List<String> wordsToSearch, int numberOfReviews, List<String> reviews) {

        List<String> ans = new ArrayList<>();
        Map<String, Integer> featureMap = new HashMap<>();

        featureMap = wordsToSearch.stream()
                .collect(Collectors.toMap(feat -> feat, feat -> findFrequency(feat, reviews)));

        while (ans.size() < numberOfTopWordsToReturn && !featureMap.isEmpty()) {
            ans.add(findMaxFrequencyInResults(featureMap));
        }
        return ans;
    }

    public static int findFrequency(String feature, List<String> reviews) {

        long ans = 0;
        List<String> keyWords = reviews.stream().map(r -> r.replaceAll("[^a-zA-Z ]", "").split("\\s+")).flatMap(Arrays::stream)
                .collect(Collectors.toList());

        ans = keyWords.stream().filter(kW -> kW.equalsIgnoreCase(feature)).count();

        return (int) ans;
    }

    public static String findMaxFrequencyInResults(Map<String, Integer> mapOfResults) {

        Map.Entry<String, Integer> maxEntry = mapOfResults.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        mapOfResults.remove(maxEntry.getKey());

        return maxEntry.getKey();
    }

    // PROBLEM #2
    // given a list of characters, find the largest subarray of like characters,
    // that would exist in the array.
    // [a,b,c,a] = [4]
    // [a,b,c] =[1,1,1]
    public static List<Integer> findSubArray(List<Character> movieClips){

        List<Integer> ans = new ArrayList<>();
        int index = 0;
        for (int i = 0; i< movieClips.size(); i++) {
            Character c = movieClips.get(i);
            index = movieClips.lastIndexOf(c);
            if (index == i) {
                ans.add(1);
            } else {
                ans.add(index - i+1);
                i += index;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        List<String> reviews = List.of(
                "I really like waterproof case for my phone. waterproof is the best thing because I swim a lot.",
                " I am a big fan of the waterproof case.", "The case is very cheap and pretty.",
                "          ",
                "This case is the worst. I am very unhappy with it. Even tho it is very functional.");
        List<String> keyWords = List.of("waterproof", "durable", "cheap", "bright", "cool", "functional");
        int numberOfWords = 6;
        int numberOfTopWordsToReturn = 3;
        int numberOfReviews = 4;
        System.out.println(findMostFrequentWord(numberOfWords, numberOfTopWordsToReturn, keyWords, numberOfReviews, reviews));
        
        List<Character> testCase1 = List.of('a', 'b', 'c');
        System.out.println("Expected: [1,1,1] :: Actual: " + findSubArray(testCase1));
        List<Character> testCase2 = List.of('a', 'b', 'c', 'd', 'e', 'a', 'g');
        System.out.println("Expected: [6, 1] :: Actual: " + findSubArray(testCase2));
        List<Character> testCase3 = List.of('a', 'b', 'c', 'd', 'e', 'a','f','g','h','f');
        System.out.println("Expected: [6,4] :: Actual: " + findSubArray(testCase3));
    }
}