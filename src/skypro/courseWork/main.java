package skypro.courseWork;
import org.w3c.dom.ls.LSOutput;

public class main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.printListOfEmployees(3);
        employeeBook.changeTheSalaryForEveryoneInDepartment(3, 50);
        employeeBook.printListOfEmployees(3);
        employeeBook.printEmployeesInDepartment(3);
    }
}
