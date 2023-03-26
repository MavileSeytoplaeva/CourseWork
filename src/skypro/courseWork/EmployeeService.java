package skypro.courseWork;


public class EmployeeService {
    public static String printListOfEmployees(Employee[] employeeCount) {
        for (int i = 0; i < Employee.getId(); i++) {
            System.out.println(employeeCount[i]);
        }
        return "";
    }
    public static String countSalaryCostsPerMonth(Employee[] employeeCount) {
        int sum = 0;
        for (int i = 0; i < Employee.getId(); i++) {
            Employee salarySum = employeeCount[i];
            sum = sum + salarySum.getSalary();
        }
        return "Cумма затрат на зарплаты в месяц " + sum + " рублей.";
    }
    public static String findEmployeeWithMinSalary(Employee[] employeeCount) {
        for (int i = 0; i < Employee.getId(); i++) {
            Employee salary = employeeCount[i];
            int minSalary = salary.getSalary();
            for (Employee element : employeeCount) {
                if (minSalary > element.getSalary()) {
                    minSalary = element.getSalary();
                }
            }
            if (minSalary == salary.getSalary()) {
                System.out.println("Самая маленькая зарплата у " + salary.getFullname() + ". Она составляет " + minSalary+" рублей.");
            }
        }
        return "";
    }
    public static String findEmployeeWithMaxSalary(Employee[] employeeCount) {
        for (int i = 0; i < Employee.getId(); i++) {
            Employee salary = employeeCount[i];
            int maxSalary = salary.getSalary();
            for (Employee element : employeeCount) {
                if (maxSalary < element.getSalary()) {
                    maxSalary = element.getSalary();
                }
            }
            if (maxSalary == salary.getSalary()) {
                System.out.println("Самая большая зарплата у " + salary.getFullname() + ". Она составляет " + maxSalary+" рублей.");
            }
        }
        return "";
    }
    public static String printAverageSalary(Employee[] employeeCount) {
        int sum = 0;
        for (int i = 0; i < Employee.getId(); i++) {
            Employee salarySum = employeeCount[i];
            sum = sum + salarySum.getSalary();
        }
        int averageSalary = sum /= Employee.getId();
        return "Среднее значение зарплат "+averageSalary+" рублей.";
    }
    public static String printFullNamesOnly(Employee[] employeeCount) {
        for (int i = 0; i < Employee.getId(); i++) {
            Employee fullnamesOnly = employeeCount[i];
            System.out.println("ФИО " + fullnamesOnly.getFullname());
        }
        return "";
    }
}

