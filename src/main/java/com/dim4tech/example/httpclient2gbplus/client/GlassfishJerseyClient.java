package com.dim4tech.example.httpclient2gbplus.client;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

public class GlassfishJerseyClient implements Worker {
    private Client client = ClientBuilder.newClient( new ClientConfig() );

    @Override
    public void doWork(int port, File file) {
        WebTarget webTarget = client.target("http://localhost:" + port + "/");
        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.WILDCARD);
        Response response = invocationBuilder.post(Entity.entity(file, MediaType.WILDCARD_TYPE));
        response.getEntity();
    }
}
