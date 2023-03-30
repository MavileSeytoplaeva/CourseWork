package skypro.courseWork;


import javax.swing.text.Element;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.Objects;

public class EmployeeService {
    public static String printListOfEmployees(Employee[] employeeCount) {
        for (int i = 0; i < employeeCount.length; i++) {
            System.out.println(employeeCount[i]);
        }
        return "";
    }

    public static String countSalaryCostsPerMonth(Employee[] employeeCount) {
        int sum = 0;
        for (int i = 0; i < employeeCount.length; i++) {
            Employee salarySum = employeeCount[i];
            sum = sum + salarySum.getSalary();
        }
        return "Cумма затрат на зарплаты в месяц " + sum + " рублей.";
    }

    public static String findEmployeeWithMinSalary(Employee[] employeeCount) {
        for (int i = 0; i < employeeCount.length; i++) {
            Employee salary = employeeCount[i];
            int minSalary = salary.getSalary();
            for (Employee element : employeeCount) {
                if (minSalary > element.getSalary()) {
                    minSalary = element.getSalary();
                }
            }
            if (minSalary == salary.getSalary()) {
                System.out.println("Самая маленькая зарплата у " + salary.getFullname() + ". Она составляет " + minSalary + " рублей.");
            }
        }
        return "";
    }

    public static String findEmployeeWithMaxSalary(Employee[] employeeCount) {
        for (int i = 0; i < employeeCount.length; i++) {
            Employee salary = employeeCount[i];
            int maxSalary = salary.getSalary();
            for (Employee element : employeeCount) {
                if (maxSalary < element.getSalary()) {
                    maxSalary = element.getSalary();
                }
            }
            if (maxSalary == salary.getSalary()) {
                System.out.println("Самая большая зарплата у " + salary.getFullname() + ". Она составляет " + maxSalary + " рублей.");
            }
        }
        return "";
    }

    public static String printAverageSalary(Employee[] employeeCount) {
        int sum = 0;
        for (int i = 0; i < employeeCount.length; i++) {
            Employee salarySum = employeeCount[i];
            sum = sum + salarySum.getSalary();
        }
        int averageSalary = sum /= employeeCount.length;
        return "Среднее значение зарплат " + averageSalary + " рублей.";
    }

    public static String printFullNamesOnly(Employee[] employeeCount) {
        for (int i = 0; i < employeeCount.length; i++) {
            Employee fullnamesOnly = employeeCount[i];
            System.out.println("ФИО " + fullnamesOnly.getFullname());
        }
        return "";
    }

    public static int changeTheSalaryForEveryone(Employee[] employeeCount, double percent) {
        double percentIncrease = 1.0 + (percent / 100);
        for (int i = 0; i < employeeCount.length; i++) {
            Employee employeeSalary = employeeCount[i];
            employeeSalary.setSalary((int) (employeeSalary.getSalary() * percentIncrease));
            System.out.println(employeeSalary.getSalary());
        }
        return 0;
    }

    public static int findEmployeeWithMinSalaryInDepartment(Employee[] employeeCount, int department) {
        Employee[] departmentSalary = new Employee[employeeCount.length];
        int j = 0;
        int minSalary = 100000;
        for (int i = 0; i < employeeCount.length; i++) {
            Employee employee = employeeCount[i];
            if (department == employee.getDepartment()) {
                departmentSalary[j] = new Employee(employee.getFullname(), employee.getDepartment(), employee.getSalary());
                if (minSalary > departmentSalary[j].getSalary()) {
                    minSalary = departmentSalary[j].getSalary();
                }
            }
            j++;
        }
        return minSalary;
    }
    public static int findEmployeeWithMaxSalaryInDepartment(Employee[] employeeCount, int department) {
        Employee[] departmentSalary = new Employee[employeeCount.length];
        int j = 0;
        int maxSalary = 0;
        for (int i = 0; i < employeeCount.length; i++) {
            Employee employee = employeeCount[i];
            if (department == employee.getDepartment()) {
                departmentSalary[j] = new Employee(employee.getFullname(), employee.getDepartment(), employee.getSalary());
                if (maxSalary < departmentSalary[j].getSalary()) {
                    maxSalary = departmentSalary[j].getSalary();
                }
            }
            j++;
        }
        return maxSalary;
    }
    public static String countSalaryCostsPerMonthByDepartment(Employee[] employeeCount, int department) {
        Employee[] departmentSalary = new Employee[employeeCount.length];
        int sum = 0;
        int j = 0;
        for (Employee employee : employeeCount) {
            if (department == employee.getDepartment()) {
                departmentSalary[j] = new Employee(employee.getFullname(), employee.getDepartment(), employee.getSalary());
                sum = sum + departmentSalary[j].getSalary();
            }
            j++;
        }
        return "Cумма затрат на зарплаты по отделу "+department+" в месяц " + sum + " рублей.";
    }
    public static String printAverageSalaryByDepartment(Employee[] employeeCount, int department) {
        Employee[] departmentSalary = new Employee[employeeCount.length];
        int sum = 0;
        int j = 0;
        int employeesInDepartment = 0;
        for (Employee salarySum : employeeCount) {
            if (department == salarySum.getDepartment()) {
                departmentSalary[j] = new Employee(salarySum.getFullname(), salarySum.getDepartment(), salarySum.getSalary());
                sum = sum + departmentSalary[j].getSalary();
                j++;
                employeesInDepartment++;
            }
        }
        int averageSalary = sum /= employeesInDepartment;
        return "Среднее значение зарплат " + averageSalary + " рублей.";
    }
    public static int changeTheSalaryForEveryoneInDepartment(Employee[] employeeCount, int department, double percent) {
        double percentIncrease = 1.0 + (percent / 100);
        Employee[] departmentSalary = new Employee[employeeCount.length];
        int j = 0;
        for (Employee employeeSalary : employeeCount) {
            if (department == employeeSalary.getDepartment()) {
                departmentSalary[j] = new Employee(employeeSalary.getFullname(), employeeSalary.getDepartment(), employeeSalary.getSalary());
                departmentSalary[j].setSalary((int) (departmentSalary[j].getSalary() * percentIncrease));
                System.out.println(departmentSalary[j].getSalary());
                j++;
            }
        }
        return 0;
    }
    public static String printEmployeesInDepartment(Employee[] employeeCount, int department) {
        Employee[] departmentSalary = new Employee[employeeCount.length];
        int j = 0;
        for (Employee employee : employeeCount) {
            if (department == employee.getDepartment()) {
                departmentSalary[j] = new Employee(employee.getFullname(), employee.getDepartment(), employee.getSalary());
                System.out.println("ФИО: " + departmentSalary[j].getFullname()+"." + " Зарплата: " + departmentSalary[j].getSalary());
                j++;
            }
        }
        return "";
    }

    //    3. Получить в качестве параметра число и найти:
//            1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
//            2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public static String employeeWithSalaryLessThanGiven(Employee[] employeeCount, int number) {
        for (Employee employee : employeeCount) {
            if (employee.getSalary() < number) {
                System.out.println("ID: "+employee.getId()+". ФИО: "+employee.getFullname()+". Зарплата: "+employee.getSalary());
            }
        }
        return "";
    }
    public static String employeeWithSalaryMoreThanGiven(Employee[] employeeCount, int number) {
        for (Employee employee : employeeCount) {
            if (employee.getSalary() > number) {
                System.out.println("ID: "+employee.getId()+". ФИО: "+employee.getFullname()+". Зарплата: "+employee.getSalary());
            }
        }
        return "";
    }
}


