package by.teachmeskills.lesson22.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

@WebServlet(urlPatterns = {"/minsk", "/washington", "/beijing"})
public class TimeServlet extends HttpServlet {
    private static final Map<String, ZoneId> zoneIdMap = Map.of(
            "minsk", ZoneId.of("GMT+3"),
            "washington", ZoneId.of("GMT-4"),
            "beijing", ZoneId.of("GMT+8")
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String city = req.getServletPath().substring(1);
        String time = ZonedDateTime.now(zoneIdMap.get(city)).toLocalTime().toString();
        resp.getWriter().println("Time in %s %s".formatted(city, time));
    }
}
