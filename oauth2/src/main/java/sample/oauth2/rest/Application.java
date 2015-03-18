package sample.oauth2.rest;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest/*")
public class Application extends ResourceConfig {

    public Application() {
        super.packages(true, "sample.oauth2.rest.resources");
        super.register(CORSResponseFilter.class);
    }

}