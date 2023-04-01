package skypro.courseWork;

import java.util.Scanner;

public class EmployeeBook {
    private Employee[] employees;
    private int size = Employee.getCounter();

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
        for (Employee salary : employees) {
            int minSalary = salary.getSalary();
            for (Employee element : employees) {
                if (minSalary > element.getSalary()) {
                    minSalary = element.getSalary();
                }
            }
            if (minSalary == salary.getSalary()) {
                System.out.println("Самая маленькая зарплата у " + salary.getFullname() + ". Она составляет " + minSalary + " рублей.");
            }
        }
    }

    public void findEmployeeWithMaxSalary() {
        for (Employee salary : employees) {
            int maxSalary = salary.getSalary();
            for (Employee element : employees) {
                if (maxSalary < element.getSalary()) {
                    maxSalary = element.getSalary();
                }
            }
            if (maxSalary == salary.getSalary()) {
                System.out.println("Самая большая зарплата у " + salary.getFullname() + ". Она составляет " + maxSalary + " рублей.");
            }
        }
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

    public int findEmployeeWithMinSalaryInDepartment(int department) {
        Employee[] departmentSalary = new Employee[employees.length];
        int j = 0;
        int minSalary = 100000;
        for (Employee employee : employees) {
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

    public int findEmployeeWithMaxSalaryInDepartment(int department) {
        Employee[] departmentSalary = new Employee[employees.length];
        int j = 0;
        int maxSalary = 0;
        for (Employee employee : employees) {
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

    public void countSalaryCostsPerMonthByDepartment(int department) {
        Employee[] departmentSalary = new Employee[employees.length];
        int sum = 0;
        int j = 0;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                departmentSalary[j] = new Employee(employee.getFullname(), employee.getDepartment(), employee.getSalary());
                sum = sum + departmentSalary[j].getSalary();
            }
            j++;
        }
        System.out.println("Cумма затрат на зарплаты по отделу " + department + " в месяц " + sum + " рублей.");
    }

    public void printAverageSalaryByDepartment(int department) {
        Employee[] departmentSalary = new Employee[employees.length];
        int sum = 0;
        int j = 0;
        int employeesInDepartment = 0;
        for (Employee salarySum : employees) {
            if (department == salarySum.getDepartment()) {
                departmentSalary[j] = new Employee(salarySum.getFullname(), salarySum.getDepartment(), salarySum.getSalary());
                sum = sum + departmentSalary[j].getSalary();
                j++;
                employeesInDepartment++;
            }
        }
        int averageSalary = sum /= employeesInDepartment;
        System.out.println("Среднее значение зарплат по отделу " + department + " " + " " + averageSalary + " рублей.");
    }

    public void changeTheSalaryForEveryoneInDepartment(int department, double percent) {
        double percentIncrease = 1.0 + (percent / 100);
        Employee[] departmentSalary = new Employee[employees.length];
        int j = 0;
        for (Employee employeeSalary : employees) {
            if (department == employeeSalary.getDepartment()) {
                departmentSalary[j] = new Employee(employeeSalary.getFullname(), employeeSalary.getDepartment(), employeeSalary.getSalary());
                departmentSalary[j].setSalary((int) (departmentSalary[j].getSalary() * percentIncrease));
                System.out.println(departmentSalary[j].getSalary());
                j++;
            }
        }
    }

    public void printEmployeesInDepartment(int department) {
        Employee[] departmentSalary = new Employee[employees.length];
        int j = 0;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                departmentSalary[j] = new Employee(employee.getFullname(), employee.getDepartment(), employee.getSalary());
                System.out.println("ФИО: " + departmentSalary[j].getFullname() + "." + " Зарплата: " + departmentSalary[j].getSalary());
                j++;
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

    public void addEmployee(String fullname, int department, int salary) {
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i] == null) {
                System.out.println("Новый сотрудник добавлен");
                Employee newEmployee = new Employee(fullname, department, salary);
                employees[i] = newEmployee;
                break;
            }
        }
    }

    public void removeEmployee(String fullname) {
        for (int i = 0; i <= employees.length; i++) {
            size = Employee.getCounter() - 1;
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getFullname().equals(fullname)) {
                System.out.println(employees[i].getFullname() + " удален");
                System.arraycopy(employees, i + 1, employees, i + 1, size - i - 1);
                int removeNumber = size - i;
                employees[size - removeNumber] = null;
                return;
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
                        System.out.println("Зарплата у " + employees[i].getFullname() + " " + employees[i].getSalary() + " и он работает в отделе " + employees[i].getDepartment() + " Это  "+department(employees[i].getDepartment())+". Введите новую зарплату");
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
                        System.out.println("Зарплата успешно изменена. Сейчас зарплата у " + employees[i].getFullname() + " " + employees[i].getSalary() + " и теперь он работает в отделе " + employees[i].getDepartment()+"("+department(employees[i].getDepartment())+")");
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
                        System.out.println(employees[i].getFullname() + " работает в отделе " + employees[i].getDepartment() +"("+department(employees[i].getDepartment())+")"+". В какой отдел перевести " + employees[i].getFullname());
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
                                    System.out.println("Отдел успешно изменён. Теперь новый отдел " + newDepartment+"("+department(employees[i].getDepartment())+")");
                            }
                        }
                    }
                }
                break;
        }
        scan.close();
    }

    public void printFullnamesByDepartment(int department) {
        System.out.println("Отдел "+department);
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
            if (departmentNumber.getDepartment() == department){
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

