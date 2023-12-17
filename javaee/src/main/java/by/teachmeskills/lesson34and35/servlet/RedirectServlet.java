package by.teachmeskills.lesson34and35.servlet;

import by.teachmeskills.lesson34and35.domain.UrlPair;
import by.teachmeskills.lesson34and35.service.UrlPairService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    private final UrlPairService urlPairService = new UrlPairService();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String alias = req.getParameter("alias");
        try {
            UrlPair urlPair = urlPairService.findByAlias(alias);
            resp.sendRedirect(urlPair.url());
            log.info("Redirect to " + urlPair.url());
        } catch (IllegalArgumentException e) {
            resp.getWriter().println(e.getMessage());
            log.warn(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String body = req.getReader().lines()
                    .reduce(String::concat).orElseThrow();
            UrlPair urlPair = objectMapper.readValue(body, UrlPair.class);
            urlPairService.save(urlPair);
        } catch (IllegalArgumentException e) {
            resp.getWriter().println(e.getMessage());
            log.warn(e.getMessage());
        } catch (Exception e) {
            resp.getWriter().print("Something wrong");
            log.warn(e.getMessage());
        }
    }
}
