package by.teachmeskills.lesson26.servlet;

import by.teachmeskills.lesson26.service.ValidateService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/handle-form")
public class FormHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/WEB-INF/lesson26/save-request.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (ValidateService.isValidName(name)) {
            req.setAttribute("message", "Enter correct name");
            req.getServletContext().getRequestDispatcher("/WEB-INF/lesson26/save-request.jsp").forward(req, resp);
        }
        String description = req.getParameter("description");
        if (ValidateService.isValidDescription(description)) {
            req.setAttribute("message", "Enter correct description");
            req.getServletContext().getRequestDispatcher("/WEB-INF/lesson26/save-request.jsp").forward(req, resp);
        }
        req.setAttribute("message", "Name :" + name + "\nDescription: " + description);
        req.getServletContext().getRequestDispatcher("/WEB-INF/lesson26/success.jsp").forward(req, resp);
    }
}
