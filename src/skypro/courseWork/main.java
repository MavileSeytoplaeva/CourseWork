package skypro.courseWork;
import org.w3c.dom.ls.LSOutput;

public class main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.printListOfEmployees();
    }
}
//        Можно сначала придумать каждому отделу какое-то название. Потом сделать метод где будет выводить по имени "такой-то сотрудник работает
//        в отделе таком-то. В какой из отделов его перевести? 1 - Отдел снабжения и закупок (ОС), 2 -Отдел логистики (ОЛ), 3 - Отдел по работе с партнёрами(ОРП),
//4 - Отдел промышленной безопасности (ОПБ), 5 - Отдел технического контроля (ОТК). и потом по выбранной цифре вызвать setDepartment.
// https://gist.github.com/jelaiace/c1abb5e03749f7fe4aeb (пример)


