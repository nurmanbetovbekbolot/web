package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RandomSum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        int max=100;
        int min=1;
        int range=max-min+1;
        int a= (int) (( Math.random()*range)+min);
        int b= (int) (( Math.random()*range)+min);
        int sum=a+b;


        printWriter.print("The Sum of two numbers "+sum);

    }
}