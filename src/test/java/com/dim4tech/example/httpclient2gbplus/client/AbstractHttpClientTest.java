package com.dim4tech.example.httpclient2gbplus.client;

import com.dim4tech.example.httpclient2gbplus.server.ServerHttpRequestHandler;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

abstract class AbstractHttpClientTest {
    private Logger LOG = LoggerFactory.getLogger(AbstractHttpClientTest.class);

    HttpServer server = ServerBootstrap.bootstrap()
            .registerHandler("*", new ServerHttpRequestHandler())
            .create();

    File tmpFile;

    void setUp() throws IOException {
        tmpFile = File.createTempFile("temp_", "_3Gb");
        tmpFile.deleteOnExit();
        LOG.info("Temp File {}", tmpFile.getAbsolutePath());
        Path path = Path.of(tmpFile.toURI());
        try (OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.WRITE)) {
            for(int i = 0; i < 3 * 1024; i++) {
                outputStream.write(new byte[1024 * 1024]);
            }
        }
        server.start();
    }

    void tearDown() throws IOException {
        Files.delete(Paths.get(tmpFile.toURI()));
        server.stop();
    }
}
