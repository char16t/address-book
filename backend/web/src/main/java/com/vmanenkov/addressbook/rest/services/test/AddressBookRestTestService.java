package com.vmanenkov.addressbook.rest.services.test;

import com.vmanenkov.addressbook.model.test.Test;
import com.vmanenkov.addressbook.rest.model.test.TestRest;
import com.vmanenkov.addressbook.rest.model.test.TestSimple;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.exceptions.TestDisabledException;
import com.vmanenkov.services.test.TestService;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/test/performance")
@RequestScoped
@Profiled
public class AddressBookRestTestService {

    @Inject
    private TestService testService;

    @GET
    @NoCache
    @Path("/simple")
    @Produces(MediaType.APPLICATION_JSON)
    public TestSimple testSimple() {
        Random r = new Random();
        return new TestSimple(r.nextInt(), r.nextInt(), r.nextInt(), r.nextInt());
    }

    @GET
    @NoCache
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public TestRest testPostgresqlGet() throws TestDisabledException {
        Test model = testService.get();
        return convertToRest(model);
    }

    // Здесь потребуется прислать JSON
    @POST
    @NoCache
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TestRest testPostgresqlInsert(TestRest rest) throws TestDisabledException {
        Test model = testService.insert(rest.getDescription());
        return convertToRest(model);
    }

    // Можно использовать переменные из пути:
    @PUT
    @NoCache
    @Path("/insert/{description}")
    @Produces(MediaType.APPLICATION_JSON)
    public TestRest testPostgresqlInsert(@PathParam("description") String description) throws TestDisabledException {
        Test model = testService.insert(description);
        return convertToRest(model);
    }

    private TestRest convertToRest(Test model) {
        if (model != null) {
            return new TestRest(model.getId(), model.getDescription());
        }
        else {
            return null;
        }
    }
}
