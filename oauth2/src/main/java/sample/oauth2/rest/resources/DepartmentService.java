package sample.oauth2.rest.resources;

import sample.oauth2.model.Department;
import sample.oauth2.model.loader.DataLoader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/department")
public class DepartmentService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getAllDepartments() {
        return DataLoader.getInstance().getAllDepartments();
    }

    @GET
    @Path("/{companyId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getDepartments(@PathParam("companyId") Long companyId) {
        return DataLoader.getInstance().getAllDepartments().stream()
                .filter(d -> d.getCompany().getId().equals(companyId)).collect(Collectors.toList());
    }

    @GET
    @Path("/{companyId}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Department getDepartment(@PathParam("companyId") Long companyId, @PathParam("id") Long id) {
        return DataLoader.getInstance().getAllDepartments().stream()
                .filter(d -> d.getCompany().getId().equals(companyId) && d.getId().equals(id)).findAny().get();
    }

}
