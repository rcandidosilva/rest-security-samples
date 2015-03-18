package sample.oauth2.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Department implements Serializable {

    private Long id;
    private String name;
    private String city;
    private Company company;

    public Department() {
        super();
    }

    public Department(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Department(Long id, String name, String city, Company company) {
        this(id, name, city);
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
