package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            PrintWriter printWriter = resp.getWriter();

            boolean isPrime = true;
            List<Integer> nums = new ArrayList<>();
            for (int i = 2; i <= 542; i++) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime)
                    nums.add(i);
                else
                    isPrime = true;
            }
            printWriter.print("<html> <body> <table border=\"5\" cellpadding=\"10\"" +
                "<caption>Prime Numbers</caption>");
            int numbers = 0;
            for (int i = 0; i < 10; i++) {
                printWriter.print("<tr>");
                for (int j = 0; j < 10; j++) {
                    numbers++;
                    printWriter.print("<th>" + nums.get(numbers) + "</th>");
                }
                printWriter.print("</tr>");
            }
            printWriter.print("</table></body></html>");
        }


            }






