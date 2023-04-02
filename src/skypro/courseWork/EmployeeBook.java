package skypro.courseWork;

import java.lang.invoke.StringConcatFactory;
import java.util.Scanner;

public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook() {
        this.employees = new Employee[10];
        employees[0] = new Employee("Архипов Гордий Павлович", 1, 64900);
        employees[1] = new Employee("Соловьёв Федор Игоревич", 2, 80903);
        employees[2] = new Employee("Копылов Аполлон Авксентьевич", 3, 81128);
        employees[3] = new Employee("Королёв Ефим Тимофеевич", 4, 90535);
        employees[4] = new Employee("Авдеев Руслан Витальевич", 5, 90725);
        employees[5] = new Employee("Иванова Наталия Сергеевна", 1, 75586);
        employees[6] = new Employee("Кондратьева Неонила Вячеславовна", 2, 65770);
        employees[7] = new Employee("Доронина Ульяна Дмитриевна", 3, 85385);
        employees[8] = new Employee("Горбунова Женевьева Васильевна", 4, 82519);
        employees[9] = new Employee("Казакова Грета Дамировна", 5, 91960);
    }

    public void printListOfEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void countSalaryCostsPerMonth() {
        int sum = 0;
        for (Employee salarySum : employees) {
            sum = sum + salarySum.getSalary();
        }
        System.out.println("Cумма затрат на зарплаты в месяц " + sum + " рублей.");
    }

    public void findEmployeeWithMinSalary() {
        Employee minSalaryEmployee = employees[0];
        for (Employee element : employees) {
            if (minSalaryEmployee.getSalary() > element.getSalary()) {
                minSalaryEmployee = element;
            }
        }
        System.out.println("Самая маленькая зарплата у " + minSalaryEmployee.getFullname() + ". Она составляет " + minSalaryEmployee.getSalary() + " рублей.");
    }

    public void findEmployeeWithMaxSalary() {
        Employee maxSalaryEmployee = employees[0];
        for (Employee element : employees) {
            if (maxSalaryEmployee.getSalary() < element.getSalary()) {
                maxSalaryEmployee = element;
            }
        }
        System.out.println("Самая большая зарплата у " + maxSalaryEmployee.getFullname() + ". Она составляет " + maxSalaryEmployee.getSalary() + " рублей.");
    }

    public void printAverageSalary() {
        int sum = 0;
        for (Employee salarySum : employees) {
            sum = sum + salarySum.getSalary();
        }
        int averageSalary = sum /= employees.length;
        System.out.println("Среднее значение зарплат " + averageSalary + " рублей.");
    }

    public void printFullNamesOnly() {
        for (Employee fullnamesOnly : employees) {
            System.out.println("ФИО " + fullnamesOnly.getFullname());
        }
    }

    public void changeTheSalaryForEveryone(double percent) {
        double percentIncrease = 1.0 + (percent / 100);
        for (Employee employeeSalary : employees) {
            employeeSalary.setSalary((int) (employeeSalary.getSalary() * percentIncrease));
            System.out.println(employeeSalary.getSalary());
        }
    }

    public Employee findEmployeeWithMinSalaryInDepartment(int department) {
        Employee minSalaryEmployee = null;
        for (Employee element : employees) {
            if (department != element.getDepartment()) {
                continue;
            }
            if (minSalaryEmployee == null || minSalaryEmployee.getSalary() > element.getSalary()) {
                minSalaryEmployee = element;
            }
        }
        System.out.println(minSalaryEmployee);
        return minSalaryEmployee;
    }

    public Employee findEmployeeWithMaxSalaryInDepartment(int department) {
        Employee maxSalaryEmployee = null;
        for (Employee element : employees) {
            if (department != element.getDepartment()) {
                continue;
            }
            if (maxSalaryEmployee == null || maxSalaryEmployee.getSalary() < element.getSalary()) {
                maxSalaryEmployee = element;
            }
        }
        System.out.println(maxSalaryEmployee);
        return maxSalaryEmployee;
    }

    public void countSalaryCostsPerMonthByDepartment(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                sum = sum + employee.getSalary();
            }
        }
        System.out.println("Cумма затрат на зарплаты по отделу " + department + " в месяц " + sum + " рублей.");
    }

    public void printAverageSalaryByDepartment(int department) {
        int sum = 0;
        int employeesInDepartment = 0;
        for (Employee salarySum : employees) {
            if (department == salarySum.getDepartment()) {
                sum = sum + salarySum.getSalary();
                employeesInDepartment++;
            }
        }
        int averageSalary = sum /= employeesInDepartment;
        System.out.println("Среднее значение зарплат по отделу " + department + " " + " " + averageSalary + " рублей.");
    }

    public void changeTheSalaryForEveryoneInDepartment(int department, double percent) {
        double percentIncrease = 1.0 + (percent / 100);
        for (Employee employeeSalary : employees) {
            if (department == employeeSalary.getDepartment()) {
                employeeSalary.setSalary((int) (employeeSalary.getSalary() * percentIncrease));
                System.out.println(employeeSalary.getSalary());
            }
        }
    }

    public void printEmployeesInDepartment(int department) {
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                System.out.println("ФИО: " + employee.getFullname() + "." + " Зарплата: " + employee.getSalary());
            }
        }
    }

    public void employeeWithSalaryLessThanGiven(int number) {
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                System.out.println("ID: " + employee.getId() + ". ФИО: " + employee.getFullname() + ". Зарплата: " + employee.getSalary());
            }
        }
    }

    public void employeeWithSalaryMoreThanGiven(int number) {
        for (Employee employee : employees) {
            if (employee.getSalary() > number) {
                System.out.println("ID: " + employee.getId() + ". ФИО: " + employee.getFullname() + ". Зарплата: " + employee.getSalary());
            }
        }
    }

    public void addEmployee(Employee employee) {
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i] == null) {
                System.out.println("Новый сотрудник добавлен");
                employees[i] = employee;
                break;
            }
        }
    }

    public void removeEmployee(String fullname) {
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getFullname().equals(fullname)) {
                System.out.println(employees[i].getFullname() + " удален");
                employees[i] = null;
            }
        }
    }

    public void changeEmployeesData(String fullname) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Если вы хотите изменить и зарплату сотрудника и его отдел введите 0, если хотите изменить только его зарплату введите 1, если хотите изменить отдел введите 2");
        switch (scan.nextInt()) {
            case 0:
                for (int i = 0; i <= employees.length - 1; i++) {
                    if (employees[i].getFullname().equals(fullname)) {
                        System.out.println("Зарплата у " + employees[i].getFullname() + " " + employees[i].getSalary() + " и он работает в отделе " + employees[i].getDepartment() + " Это  " + department(employees[i].getDepartment()) + ". Введите новую зарплату");
                        employees[i].setSalary(scan.nextInt());
                        System.out.println("Введите новый отдел");
                        int newDepartment = scan.nextInt();
                        if (newDepartment == employees[i].getDepartment()) {
                            System.out.println("Извините он уже работает в этом отделе");
                        } else {
                            switch (newDepartment) {
                                case 1, 2, 3, 4, 5:
                                    employees[i].setDepartment(newDepartment);
                            }
                        }
                        System.out.println("Зарплата успешно изменена. Сейчас зарплата у " + employees[i].getFullname() + " " + employees[i].getSalary() + " и теперь он работает в отделе " + employees[i].getDepartment() + "(" + department(employees[i].getDepartment()) + ")");
                    }
                }
                break;
            case 1:
                for (int i = 0; i <= employees.length - 1; i++) {
                    if (employees[i].getFullname().equals(fullname)) {
                        System.out.println("Зарплата у " + employees[i].getFullname() + " " + employees[i].getSalary() + ". Введите новую зарплату ");
                        employees[i].setSalary(scan.nextInt());
                        System.out.println("Зарплата успешно изменена. Сейчас зарплата у " + employees[i].getFullname() + " " + employees[i].getSalary());
                    }
                }
                break;
            case 2:
                for (int i = 0; i <= employees.length - 1; i++) {
                    if (employees[i].getFullname().equals(fullname)) {
                        System.out.println(employees[i].getFullname() + " работает в отделе " + employees[i].getDepartment() + "(" + department(employees[i].getDepartment()) + ")" + ". В какой отдел перевести " + employees[i].getFullname());
                        System.out.println("1 - Отдел снабжения и закупок (ОС)");
                        System.out.println("2 - Отдел по работе с партнёрами(ОРП)");
                        System.out.println("3 - Отдел промышленной безопасности(ОПБ)");
                        System.out.println("4 - Отдел технического контроля (ОТК)");
                        System.out.println("5 - Отдел логистики (ОЛ)");
                        int newDepartment = scan.nextInt();
                        if (newDepartment == employees[i].getDepartment()) {
                            System.out.println("Извините он уже работает в этом отделе");
                        } else {
                            switch (newDepartment) {
                                case 1, 2, 3, 4, 5:
                                    employees[i].setDepartment(newDepartment);
                                    System.out.println("Отдел успешно изменён. Теперь новый отдел " + newDepartment + "(" + department(employees[i].getDepartment()) + ")");
                            }
                        }
                    }
                }
                break;
        }
        scan.close();
    }

    private void printFullnamesByDepartment(int department) {
        System.out.println("Отдел " + department);
        for (Employee departmentE : employees) {
            if (department == departmentE.getDepartment()) {
                System.out.println(departmentE.getFullname());
            }
        }
    }

    public void printListOfEmployeesByDepartment() {
        printFullnamesByDepartment(1);
        printFullnamesByDepartment(2);
        printFullnamesByDepartment(3);
        printFullnamesByDepartment(4);
        printFullnamesByDepartment(5);
    }

    public String department(int department) {
        for (Employee departmentNumber : employees) {
            if (departmentNumber.getDepartment() == department) {
                if (department == 1) {
                    return "Отдел снабжения и закупок (ОС)";
                }
                if (department == 2) {
                    return "Отдел по работе с партнёрами(ОРП)";
                }
                if (department == 3) {
                    return "Отдел промышленной безопасности(ОПБ)";
                }
                if (department == 4) {
                    return "Отдел технического контроля (ОТК)";
                }
                if (department == 5) {
                    return "Отдел логистики (ОЛ)";
                }
                break;
            }
        }
        return null;
    }
}

