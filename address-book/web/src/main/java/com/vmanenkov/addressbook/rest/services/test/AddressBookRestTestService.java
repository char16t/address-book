package com.vmanenkov.addressbook.rest.services.test;

import com.vmanenkov.addressbook.model.test.Test;
import com.vmanenkov.addressbook.rest.model.TestRest;
import com.vmanenkov.addressbook.rest.model.TestSimple;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.exceptions.TestDisabledException;
import com.vmanenkov.services.test.TestService;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    @Path("/postgresql")
    @Produces(MediaType.APPLICATION_JSON)
    public TestRest testPostgresql() throws TestDisabledException {

        Random r = new Random();
        Test model = testService.get();
        if (model == null)
            model = testService.insert("Description:" + r.nextInt(10000));
        model = testService.update(model, "Description:" + r.nextInt(10000));
        return convertToRest(model);
    }

    private TestRest convertToRest(Test model) {
        return new TestRest(model.getId(), model.getDescription());
    }
}
