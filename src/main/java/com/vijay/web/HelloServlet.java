package com.vijay.web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        response.getWriter().println(
            "<html>" +
            "<head><title>Jenkins Maven Web App</title></head>" +
            "<body>" +
            "<h1>Hello from Jenkins CI/CD!</h1>" +
            "<p>Application built successfully using Maven.</p>" +
            "<p>Deployed through Jenkins.</p>" +
            "</body>" +
            "</html>"
        );
    }
}
