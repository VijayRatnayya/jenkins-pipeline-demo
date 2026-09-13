package com.vijay.web;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HelloServletTest {

    @Test
    public void applicationTest() {
        String message = "Hello from Jenkins CI/CD!";
        assertTrue(message.contains("Jenkins"));
    }
}
