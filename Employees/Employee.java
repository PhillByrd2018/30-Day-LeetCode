package Practice.Employees;

public class Employee {

    private String name;
    private int age;


    public Employee(String pName, int pAge) {
        this.name = pName;
        this.age = pAge;
    }


    public String  getName() {
        return this.name;
    }
    public void setName(String pName) {
        this.name = pName;
    }
    public int  getAge() {
        return this.age;
    }
    public void setAge(int pAge) {
        this.age = pAge;
    }

    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("Employee: " + this.name + ", Age: " + this.age);
        return s.toString();
    }
}