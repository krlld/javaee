package by.teachmeskills.lesson22.servlet;

import by.teachmeskills.lesson22.service.AdultService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/adult")
public class AdultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ageStr = req.getParameter("age");
        PrintWriter writer = resp.getWriter();
        if (ageStr == null || ageStr.isEmpty()) {
            writer.println("Parameter age not found");
            return;
        }
        try {
            int age = Integer.parseInt(ageStr);
            writer.println("Adult age: " + AdultService.isAdult(age));
        } catch (NumberFormatException exception) {
            writer.println("Incorrect age");
        }
    }
}
