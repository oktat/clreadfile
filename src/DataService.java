import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataService {
    File file;
    Scanner sc;
    public DataService() {        
        initService();
    }
    private void initService() {
        try {
            tryInitService();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található!");
            System.err.println(e.getMessage());
        }
    }
    private void tryInitService() 
            throws FileNotFoundException {
        file = new File("employees.txt");
        sc = new Scanner(file);
    }
    public ArrayList<Employee> readFile() {
        ArrayList<Employee> empList = new ArrayList<>();
        while(sc.hasNext()){
            String line = sc.nextLine();
            empList.add(getEmployee(line));
        }        
        return empList;
    }
    private Employee getEmployee(String line) {
        String[] lineArray = line.split(":");
        Employee emp = new Employee(
            Integer.parseInt(lineArray[0]),
            lineArray[1],
            lineArray[2],
            Double.parseDouble(lineArray[3])
        );
        return emp;
    }
}
