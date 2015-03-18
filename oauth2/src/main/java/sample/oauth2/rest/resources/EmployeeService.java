package sample.oauth2.rest.resources;


import sample.oauth2.model.loader.DataLoader;
import sample.oauth2.model.Employee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/employee")
public class EmployeeService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAllEmployees() {
        return DataLoader.getInstance().getAllEmployees();
    }

    @GET
    @Path("/{companyId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees(@PathParam("companyId") Long companyId) {
        return DataLoader.getInstance().getAllEmployees().stream()
                .filter(e -> e.getDepartment().getCompany().getId().equals(companyId))
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{companyId}/{departmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees(@PathParam("companyId") Long companyId,
                                       @PathParam("departmentId") Long departmentId) {
        return DataLoader.getInstance().getAllEmployees().stream()
                .filter(e -> e.getDepartment().getCompany().getId().equals(companyId)
                        && e.getDepartment().getId().equals(departmentId))
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{companyId}/{departmentId}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("companyId") Long companyId,
                                @PathParam("departmentId") Long departmentId, @PathParam("id") Long id) {
        return DataLoader.getInstance().getAllEmployees().stream()
                .filter(e -> e.getDepartment().getCompany().getId().equals(companyId)
                        && e.getDepartment().getId().equals(departmentId) && e.getId().equals(id))
                .findAny().get();
    }


}
