package by.teachmeskills.lesson21;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

public class StaticHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        File file = new File("src/resources/index.html");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = bf.readLine()) != null) {
                sb.append(str);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        String html = sb.toString();
        exchange.getResponseHeaders().set("Content-Type", "text/html");
        exchange.sendResponseHeaders(200, html.getBytes().length);
        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(html.getBytes());
        }
    }
}
