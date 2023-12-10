package by.teachmeskills.lesson32;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/front-controller")
public class FrontController extends HttpServlet {

    private final Dispatcher dispatcher = new Dispatcher();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        dispatcher.dispatch(req, resp);
    }
}
