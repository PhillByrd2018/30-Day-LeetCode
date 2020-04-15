package Lambda;

import Employees.Employee;

public class Main {


    public static void main(String[] args) {

        System.out.println("This is the start of the first lambda of the section.");
        new Thread(() -> {
            Employee emp = new Employee("Phillip Byrd", 30);
            System.out.println("This is the start of the first lambda of the section FROM INSIDE THE LAMBDA");
            System.out.println(emp.toString());
        }).start();

       
        
    }
}