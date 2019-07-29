package com.dim4tech.example.httpclient2gbplus.server;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ServerHttpRequestHandler implements HttpRequestHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ServerHttpRequestHandler.class);

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        LOG.info("Request handled");
    }
}
