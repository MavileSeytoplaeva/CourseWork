package skypro.courseWork;

import java.util.Objects;
public class Employee {
    private int id;
    private static int counter = 1;
    private String fullname;
    private int department;
    private int salary;

    public Employee(String fullname, int department, int salary) {
        this.fullname = fullname;
        this.department = department;
        this.salary = salary;
        this.id = counter;
        counter++;
    }

    @Override
    public String toString() {
        return "Fullname is " + fullname +
                ", department is " + department +
                ", salary is " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(fullname, employee.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname, department, salary);
    }

    public String getFullname() {
        return fullname;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public static void setId(int id) {
        Employee.counter = id;
    }

}
