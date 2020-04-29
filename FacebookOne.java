import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FacebookOne {

    public static String testCase1 = "/a/../../b/../c//.//";
    public static String testCase2 = "/a//b////c/d//././/..";

    public static String simplifyPath(String path) {

        if (path.isEmpty()) {
            return path;
        }

        Stack<String> stack = new Stack<String>();
        String[] elementsOfPath = path.split("/");
        List<String> elementList = new ArrayList<String>(Arrays.asList(elementsOfPath));
        elementList.removeAll(Arrays.asList("", null));

        for (String element : elementList) {
            if (element.equals(".")) {
                continue;
            } else if (element.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(element);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (String ansElement : stack) {
            ans.append("/");
            ans.append(ansElement);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("Expected: /c :: Actual: " + simplifyPath(testCase1));
        System.out.println("Expected: /a/b/c :: Actual: " + simplifyPath(testCase2));
    }
}
