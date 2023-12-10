package by.teachmeskills.lesson32;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BeijingView implements View {

    @Override
    public void show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/beijing").forward(request, response);
    }
}
