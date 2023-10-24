package by.teachmeskills.lesson22.servlet;

import by.teachmeskills.lesson22.service.AdultService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/adult")
public class AdultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ageStr = req.getParameter("age");
        if (ageStr == null) {
            resp.getWriter().println("Parameter age not found");
            return;
        }
        try {
            int age = Integer.parseInt(ageStr);
            resp.getWriter().println("Adult age: " + AdultService.isAdult(age));
        } catch (NumberFormatException exception) {
            resp.getWriter().println("Incorrect age");
        }
    }
}
