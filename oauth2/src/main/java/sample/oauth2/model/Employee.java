package sample.oauth2.model;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement
public class Employee implements Serializable {

    private Long id;
    private String ssn;
    private Date birthDate;
    private Float salary;
    private String name;
    private String email;
    private Department department;

    public Employee() {
        super();
    }

    public Employee(Long id, String ssn, Date birthDate, Float salary, String name, String email) {
        this.id = id;
        this.ssn = ssn;
        this.birthDate = birthDate;
        this.salary = salary;
        this.name = name;
        this.email = email;
    }

    public Employee(Long id, String ssn, Date birthDate, Float salary, String name, String email, Department department) {
        this(id, ssn, birthDate, salary, name, email);
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
