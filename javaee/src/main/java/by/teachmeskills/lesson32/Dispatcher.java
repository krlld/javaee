package by.teachmeskills.lesson32;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class Dispatcher {

    private final Map<String, View> viewMap = Map.of(
            "minsk", new MinskView(),
            "washington", new WashingtonView(),
            "beijing", new BeijingView(),
            "default", new DefaultView());

    public void dispatch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String view = request.getParameter("view");
        view = view == null || view.isBlank() ? "default" : view;
        System.out.println(view);
        viewMap.get(view).show(request, response);
    }
}
