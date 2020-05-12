package Challenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainVisits {

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();

        // validations
        if (cpdomains.length == 0) {
            return ans;
        }

        Map<String, Integer> frequencyDomainMap = new HashMap<String, Integer>();

        for (String domain : cpdomains) {
            String[] splitDomain = domain.split(" ");
            domainCounterHelper(splitDomain[1], Integer.parseInt(splitDomain[0]), frequencyDomainMap);
        }

        for (Map.Entry<String, Integer> domainPair : frequencyDomainMap.entrySet()) {
            StringBuilder str = new StringBuilder();
            str.append(domainPair.getValue() + " " + domainPair.getKey());
            ans.add(str.toString());
        }

        return ans;
    }

    public static void domainCounterHelper(String domain, int visits, Map<String, Integer> freqMap) {
        freqMap.put(domain, freqMap.getOrDefault(domain, 0) + visits);
        int locationOfDot = domain.indexOf(".");
        String subDomain = domain.substring(locationOfDot + 1, domain.length());
        while (locationOfDot != -1) {
            freqMap.put(subDomain, freqMap.getOrDefault(subDomain, 0) + visits);
            locationOfDot = subDomain.indexOf(".");
            subDomain = subDomain.substring(locationOfDot + 1, subDomain.length());

        }
    }

    public static void main(String[] args) {

        String[] testCase1 = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
        System.out.println(
                "Expected: [ 901 mail.com , 50 yahoo.com , 900 google.mail.com , 5 wiki.org , 5 org , 1 intel.mail.com , 951 com ] :: Actual: "
                        + subdomainVisits(testCase1));
    }
}

// Map of the key word and the frequency
// loop through the list
// split by spaces to get the number and the domain

// helper method that takes in the domain string, the number of visits, and the
// map
// takes the whole string and insert it into the map with the value;
// then it will find the first index of the '.' and take everything from i+1
// into the map with the value
// repeat until string is done ie no '.' can be found

// loop through the map keys and create the string outputs needed to populate
// the list with their key values.
