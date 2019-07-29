package com.dim4tech.example.httpclient2gbplus.client;

import com.dim4tech.example.httpclient2gbplus.server.ServerHttpRequestHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ApachHttpClient implements Worker {
    private static final Logger LOG = LoggerFactory.getLogger(ServerHttpRequestHandler.class);

    @Override
    public void doWork(int port, File file) {
        try {
            Request.Post("http://localhost:" + port)
                    .bodyFile(file, ContentType.WILDCARD)
                    .execute().returnContent();
        } catch (IOException e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
