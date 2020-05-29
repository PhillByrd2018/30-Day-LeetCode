package Challenger;

import java.util.ArrayList;

public class CourseScheduler {

    // we create a class to tell if a course is visited or not to find the cycle in
    // our graph.
    static class Course {
        private boolean visited;
        private boolean processed;
        private ArrayList<Course> pre = new ArrayList<Course>();

        void addPre(Course preCourse) {
            pre.add(preCourse);
        }

        // this method is the core logic to the solution
        // we want to see if the current node is processed or not. If the node's
        // adjacent node is being process
        // then we know that it is in a deadlock cycle.
        boolean isCyclic() {

            // if we are processing the course currently that is a cyclic graph and we can't
            // do all the courses
            if (processed) {
                return false;
            }

            // if we already visited the course and no cycle was found then we can return
            if (visited) {
                return true;
            }
            //else we set the course and visited
            visited = true;

            //we then loop through all the prerequisites performing the same check
            for (Course preCourse : pre) {
                if (preCourse.isCyclic()) {
                    return true;
                }
            }

            //if we arrive here then we have gone through all the combinations and there is no cyclic graph
            visited = false;
            processed = true;
            return false;
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // create list of courses
        Course clist[] = new Course[numCourses];

        // initialize array with new course objects
        for (int i = 0; i < numCourses; i++) {
            clist[i] = new Course();
        }

        // pair the course with the prerequisites from the params
        for (int[] couple : prerequisites) {
            Course c1 = clist[couple[0]];
            Course c2 = clist[couple[1]];
            c1.addPre(c2);
        }

        // check every course and its prerequisites for a cyclic graph
        for (int i = 0; i < numCourses; i++) {
            if (clist[i].isCyclic()) {
                return false;
            }
        }

        // if none is detected then we return true, we can complete all the courses
        return true;
    }

    public static void main(String[] args) {
        int[][] pre = {{1,0},{0,1}};
        System.out.println("Expected: false :: Actual: " + canFinish(2, pre));
    }
}