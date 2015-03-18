package sample.oauth2.model.loader;

import org.fluttercode.datafactory.impl.DataFactory;
import sample.oauth2.model.Company;
import sample.oauth2.model.Department;
import sample.oauth2.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    private static final int N_COMPANIES = 5;
    private static final int N_DEPARTMENTS = 5;
    private static final int N_EMPLOYEES = 100;

    private static DataLoader instance;

    private DataFactory dataFactory = new DataFactory();

    private List<Company> allCompanies = new ArrayList<>();
    private List<Department> allDepartments = new ArrayList<>();
    private List<Employee> allEmployees = new ArrayList<>();

    public static DataLoader getInstance() {
        if (instance == null) {
            instance = new DataLoader();
        }
        return instance;
    }

    public DataLoader() {
        loadCompanies();
    }

    public void loadCompanies() {
        for (int i = 0; i < N_COMPANIES; i++) {
            Company company = new Company(
                    new Long(i), dataFactory.getBusinessName());
            loadDepartments(company);
            allCompanies.add(company);
        }

    }

    public void loadDepartments(Company company) {
        for (int i = 0; i < N_DEPARTMENTS; i++) {
            Department department = new Department(new Long(i),
                dataFactory.getAddress(), dataFactory.getCity(), company);
            loadEmployees(department);
            allDepartments.add(department);
        }
    }

    public void loadEmployees(Department department) {
        for (int i = 0; i < N_EMPLOYEES; i++) {
            Employee employee = new Employee(new Long(i),
                    dataFactory.getNumberText(8), dataFactory.getBirthDate(),
                    new Float(dataFactory.getNumberText(10)), dataFactory.getName(),
                    dataFactory.getEmailAddress(), department);
            allEmployees.add(employee);
        }
    }

    public List<Company> getAllCompanies() {
        return allCompanies;
    }

    public List<Department> getAllDepartments() {
        return allDepartments;
    }

    public List<Employee> getAllEmployees() {
        return allEmployees;
    }
}
