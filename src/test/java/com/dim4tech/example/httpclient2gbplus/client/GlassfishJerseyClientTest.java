package com.dim4tech.example.httpclient2gbplus.client;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class GlassfishJerseyClientTest extends AbstractHttpClientTest {
    private GlassfishJerseyClient client = new GlassfishJerseyClient();

    @BeforeEach
    void setUp() throws IOException {
        super.setUp();
    }

    @AfterEach
    void tearDown() throws IOException {
        super.tearDown();
    }

    @Test
    void doWork() {
        Assertions.assertDoesNotThrow(() -> client.doWork(server.getLocalPort(), tmpFile));
    }
}