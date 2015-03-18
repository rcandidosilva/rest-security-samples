package sample.oauth2.rest.resources;

import sample.oauth2.model.Company;
import sample.oauth2.model.loader.DataLoader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/company")
public class CompanyService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getAllCompanies() {
        return DataLoader.getInstance().getAllCompanies();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Company getCompany(@PathParam("id") Long id) {
        return DataLoader.getInstance().getAllCompanies().stream().filter(c -> c.getId().equals(id)).findAny().get();
    }

}
