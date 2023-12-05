import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        DataService ds = new DataService();
        ArrayList<Employee> empList = ds.readFile();
        for(Employee emp : empList) {
            System.out.println(emp.name);
        }
    }
}
